
# Add Preference in Settings to Launch Apk

Ex:  
You want to add "My App Preference" in Settings -> Developer Options:

1. Add string resource in `packages/apps/Settings/res/values/strings.xml`:

        <!-- My App Preference -->
        <string name="my_app_title">My App</string>
        <string name="my_app_summary">Launch My App</string>

2. Add preference in `packages/apps/res/xml/development_prefs.xml`:

    	<PreferenceScreen android:key="my_preference"
            android:title="@string/my_app_title"
            android:summary="@string/my_app_summary">
        </PreferenceScreen>

3. Add preference in `packages/apps/Settings/src/com/android/settings/DevelopmentSettings.java`:

        public void onCreate(Bundle icicle) {        
            ......
            // Add My App Preference
            Preference my_preference = findPreference("my_preference");
            if (my_preference != null) {
                try {
                    Intent LaunchIntent = getPackageManager()
                        .getLaunchIntentForPackage("com.xx.app");  // get launch intent for your package
                    my_preference.setIntent(LaunchIntent);  // set intent

                    mAllPrefs.add(my_preference);
                } catch (Exception e) {
                    e.printStackTrace();
                    removePreference(my_preference);
                }
            }
            ......
