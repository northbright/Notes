
# Set Default Email Signature - Android 4.4.4

We may use "Sent from" + `ro.product.model` as default Email signature(Ex: Sent from XX Tablet).

1. Make it possbile to use internal APIs(@hide) - android.os.SystemProperties  
Remove `LOCAL_SDK_VERSION` in `packages/apps/Email/src/com/android/email/Android.mk`:

        # Set default signature
        # Step 0. Remove LOCAL_SDK_VERSION to use @hide internal API. Ex: import android.os.SystemProperties
        #LOCAL_SDK_VERSION := current 

2. Modify `packages/apps/Email/src/com/android/email/activity/setup/AccountSetupOptions.java`:  
    
    * import android.os.SystemProperties
    
            import android.os.SystemProperties;
    * Combine "Sent from" + `ro.product.model` to make default signature and save account settings
    
            private void onDone() {
                final Account account = mSetupData.getAccount();
                ......
	            // Set default signature
                // Step 2. Get "ro.product.model" prop
                String model = SystemProperties.get("ro.product.model");
                // Step 3. Get "Sent From" string resource from overlay folder
                String sentFromStr = this.getString(R.string.sent_from);
                // Step 4. Set Signature
                String signature = sentFromStr + " " + model;
                account.setSignature(signature);

                // Finally, write the completed account (for the first time) and then
                // install it into the Account manager as well.  These are done off-thread.
                // The account manager will report back via the callback, which will take us to
                // the next operations.
                ......
                Utility.runAsync(new Runnable() {
                    @Override
                    public void run() {
                        final Context context = AccountSetupOptions.this;
                        AccountSettingsUtils.commitSettings(context, account);  // save account settings
                        EmailServiceUtils.setupAccountManagerAccount(context, account,
                            email, calendar, contacts, mAccountManagerCallback);

3. Add "Sent from" string in overlay folder  
`overlay/packages/apps/UnifiedEmail/res/values/strings.xml`:

        <?xml version="1.0" encoding="utf-8"?>
        <resources xmlns:xliff="urn:oasis:names:tc:xliff:document:1.2">
            <!-- For Default Email Signature -->
            <add-resource type="string" name="sent_from" />
                <string name="sent_from">Sent from</string>

        </resources>

