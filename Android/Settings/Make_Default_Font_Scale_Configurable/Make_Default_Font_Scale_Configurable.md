
# Make Default Font Scale Configurable

* About Default Font Size and Scale 
 
Android default font scale is 1.0(font size normal).  
You may find the font scale -> font size map under:  

`packages/apps/Settings/res/values/arrays.xml`

    <string-array name="entries_font_size">
        <item msgid="6490061470416867723">Small</item>
        <item msgid="3579015730662088893">Normal</item>
        <item msgid="1678068858001018666">Large</item>
        <item msgid="490158884605093126">Huge</item>
    </string-array>

    <string-array name="entryvalues_font_size" translatable="false">
        <item>0.85</item>
        <item>1.0</item>
        <item>1.15</item>
        <item>1.30</item>
    </string-array>

* Direct But Not Configurable Way

`frameworks/base/core/java/android/content/res/Configuration.java`

    public void setToDefaults() {
        // fontScale = 1; // default
        fontScale = 1.15f; // Set font size to large

* Configurable Way(useful for different SKUs / Products)

  * copy the way in "Settings"->"Display"->"Font Size" to write font settings.
       
            // packages/apps/Settings/src/com/android/settings/DisplaySettings.java:

            public void writeFontSizePreference(Object objValue) {
                try {
                    mCurConfig.fontScale = Float.parseFloat(objValue.toString());
                    ActivityManagerNative.getDefault().updatePersistentConfiguration(mCurConfig);
                } catch (RemoteException e) {
                    Log.w(TAG, "Unable to save font size");
                }
            }

  * Use `packages/apps/OneTimeInitializer` to update the font scale after boot only one time.

* Implementation  
    
    1. Add permissions in `packages/apps/OneTimeInitializer/AndroidManifest.xml`:
    
            <!-- Add android.permission.CHANGE_CONFIGURATION and android.permission.WRITE_SETTINGS to update font scale -->
            <uses-permission
                android:name="android.permission.CHANGE_CONFIGURATION"/>
            <uses-permission
                android:name="android.permission.WRITE_SETTINGS"/>
    
    2. Make res folder: `mkdir -p packages/apps/OneTimeInitializer/res/values`.
    3. Add `"default_font_scale"` string resource in `packages/apps/OneTimeInitializer/res/values/font_scale.xml`:

            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                <string name="default_font_scale">1</string>
            </resources>

    4. Add overlay font_scale.xml(ex: set to 1.15) under overlay folders to make font scale configurable.
    5. Modify `packages/apps/OneTimeInitializer/src/com/android/onetimeinitializer/OneTimeInitializerService.java`

        * Step 1 - import necessary packages.
        
                import android.os.RemoteException;
                import android.content.res.Configuration;
                import android.app.ActivityManagerNative;

        * Step 2 - Add updateFontScale() function.

                public void updateFontScale() {
                    Configuration c;
                    boolean DEBUG = false;
                    String TAG = "FontScale";
                    try {
                        c = ActivityManagerNative.getDefault().getConfiguration();
                        if (DEBUG)
                            Log.v(TAG, "OneTimeInitializerService(): onCreate(): ActivityManagerNative.getDefault().getConfiguration(), c.fontScale = " + c.fontScale);

                        String s = getResources().getString(R.string.default_font_scale);
                        if (DEBUG)
                            Log.v(TAG, "getResources().getString(R.string.default_font_scale) = " + s);

                        c.fontScale = Float.parseFloat(s);
                        if (DEBUG)
                            Log.v(TAG, "c.fontScale = Float.parseFloat(s) = " + c.fontScale);

                        try {
                            ActivityManagerNative.getDefault().updatePersistentConfiguration(c);
                        } catch (RemoteException e) {
                            Log.v(TAG, "Unable to save font size");
                        }
                    } catch (RemoteException e) {
                        Log.v(TAG, "Unable to retrieve font size");
                    }
                }

        * Step 3 - Call updateFontScale() one time in onCreate().

                public void onCreate() {
                    ......
                    updateFontScale();
                }

* Sample Code:  
[./OneTimeInitializer](./OneTimeInitializer)