
# Reboot to Recovery Mode(built-in App)

Sometimes we want to write a built-in app(built in BSP environment) to reboot the device to recovery mode.

#### Android Version  
Android L 5.1.1

#### Steps
* Permissions

        <uses-permission android:name="android.permission.REBOOT" />
        <uses-permission android:name="android.permission.RECOVERY" />

* Use PowerManager to reboot to recovery mode

        public void reboot() {
            PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
            if (pm != null) {
                pm.reboot("recovery");  // reason parameter: "recovery"
            }
        }

#### Sample Source Code
* [Reboot](./Reboot)

#### References
* [Reboot in Recovery Android](http://stackoverflow.com/questions/7111539/reboot-in-recovery-android)
* [How does the reboot into recovery mode work?](https://groups.google.com/forum/#!topic/android-porting/t4aD6IeHZ-0)