
# Home Button Can't Work

Android Version: KitKat 4.4.4

You may find home button can't work sometimes.

adb logcat:  
`V/KeyguardServiceDelegate(  826): **** onKeyguardExitResult(false) CALLED ****`

* Root Cause:  
  * `Settings.Global.DEVICE_PROVISIONED` was not set to 1 after device's provisioned for some reason.  
  * User data partition was not cleared. This will make Provision and GMS SetupWizard not run again to set `Settings.Global.DEVICE_PROVISIONED` to 1 after reboot.
  * Keyguard will enter input resitrict mode when `Settings.Global.DEVICE_PROVISIONED` = 0
  * `launchHoneForHotKey()` won't show home if Keyguard is in input restrict mode and `onKeyguardExitResult` is call with `false`.
  
* Workflow:
  * `frameworks/base/policy/src/com/android/internal/policy/impl/PhoneWindowManager.java`:  
  in `launchHoneForHotKey()`, `mKeyguardDelegate.isInputRestricted() = true` and `onKeyguardExitResult(success)` is called with `success` = `false`. This won't call `startDockOrHome()`.
    
            void launchHomeFromHotKey() {  // launch home after click "Home" button
                if (mKeyguardDelegate != null && mKeyguardDelegate.isShowingAndNotHidden()) {
                    // don't launch home if keyguard showing
                } else if (!mHideLockScreen && mKeyguardDelegate.isInputRestricted()) { // isInputRestricted()=true
                    // when in keyguard restricted mode, must first verify unlock
                    // before launching home
                    mKeyguardDelegate.verifyUnlock(new OnKeyguardExitResult() {
                        public void onKeyguardExitResult(boolean success) {  // success = false in callback
                            if (success) {  // will not go this way
                                try {
                                    ActivityManagerNative.getDefault().stopAppSwitches();
                                } catch (RemoteException e) {
                                }
                                sendCloseSystemWindows(SYSTEM_DIALOG_REASON_HOME_KEY);
                                startDockOrHome();
                            }
                        }
                    });
                } else {
                    // no keyguard stuff to worry about, just launch home!
                    try {
                        ActivityManagerNative.getDefault().stopAppSwitches();
                    } catch (RemoteException e) {
                    }
                    sendCloseSystemWindows(SYSTEM_DIALOG_REASON_HOME_KEY);
                    startDockOrHome();  // should show home normally in this way
                }
            }

  * The reason `mKeyguardDelegate.isInputRestricted()` = `true` is:
    `KeyguardUpdateMonitor::isDeviceProvisioned()` return `false`.
    `/frameworks/base/packages/Keyguard/src/com/android/keyguard/KeyguardViewMediator.java`:  

            public boolean isInputRestricted() {
                return mShowing || mNeedToReshowWhenReenabled || !mUpdateMonitor.isDeviceProvisioned();
            }

  * The reason `onKeyguardExitResult(boolean success)` is called with `false` is also:  
  `KeyguardUpdateMonitor::isDeviceProvisioned()` return `false`.

      * `frameworks/base/packages/Keyguard/src/com/android/keyguard/KeyguardViewMediator.java`:  
        `KeyguardViewMediator::verifyUnlock()` will invoke `callback.onKeyguardExitResult(false)` if `mUpdateMonitor.isDeviceProvisioned()` return `false`.

                public void verifyUnlock(IKeyguardExitCallback callback) {
                    synchronized (this) {
                        if (!mUpdateMonitor.isDeviceProvisioned()) {  // isDeviceProvisioned() return false.
                            try {
                                callback.onKeyguardExitResult(false);  // pass false to success
                            ....

      * `frameworks/base/packages/Keyguard/src/com/android/keyguard/KeyguardUpdateMonitor.java`:

                public boolean isDeviceProvisioned() {
                    return mDeviceProvisioned;
                }

                private KeyguardUpdateMonitor(Context context) {  // constructor
                    ......
                    mDeviceProvisioned = isDeviceProvisionedInSettingsDb();  // init to false before setup wizard
                    // Since device can't be un-provisioned, we only need to register a content observer
                    // to update mDeviceProvisioned when we are...
                    if (!mDeviceProvisioned) {
                        watchForDeviceProvisioning();  // set to 1 if Provision or GMS setupwizard complete
                    }
                    ....

                private boolean isDeviceProvisionedInSettingsDb() {
                    return Settings.Global.getInt(mContext.getContentResolver(),
                        Settings.Global.DEVICE_PROVISIONED, 0) != 0;
                }

* `Settings.Global.DEVICE_PROVISIONED` will be set to `1` in 2 ways:

    * AOSP's Provision package  
    `packages/apps/Provision/src/com/android/provision/DefaultActivity.java`:

            protected void onCreate(Bundle icicle) {
                super.onCreate(icicle);

                // Add a persistent setting to allow other apps to know the device has been provisioned.
                Settings.Global.putInt(getContentResolver(), Settings.Global.DEVICE_PROVISIONED, 1);
                Settings.Secure.putInt(getContentResolver(), Settings.Secure.USER_SETUP_COMPLETE, 1);
                // remove this activity from the package manager.
                PackageManager pm = getPackageManager();
                ComponentName name = new ComponentName(this, DefaultActivity.class);
                pm.setComponentEnabledSetting(name, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);
            }
    `setComponentEnabledSetting()` will disable Provision package itself in `/data/system/packages.xml`:
    
            <disabled-components>
                <item name="com.android.provision.DefaultActivity" />
            </disabled-components>    

    * with GMS installed
    AOSP's Provision will be overrided by GMS's SetupWizard by default.
    It will set `Settings.Global.DEVICE_PROVISIONED` on setup completed.
    GoogleSetupWizard w

* How to fix:  
    * Insert a new record into `/data/data/com.android.providers.settings/databases/settings.db` to set `device_provisioned` to 1:  

            adb root  // need root permission
            adb shell
            sqlite3 /data/data/com.android.providers.settings/databases/settings.db
            >insert into global (name, value) VALUES('device_provisioned', 1);
            >.quit
 
    * Then reboot the device

* References:
    * <https://code.google.com/p/android/issues/detail?id=19575>
    * <https://code.google.com/p/android/issues/detail?id=8503#c33>
    * <http://www.cnblogs.com/mythou/p/3425570.html>