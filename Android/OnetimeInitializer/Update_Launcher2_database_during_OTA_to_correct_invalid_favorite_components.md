
# Update Launcher2 Database During OTA to Correct Invalid Favorite Components

Sometimes, after OTA(Ex: from 4.2 to 4.4), you may find some favorite icons / hotseats were replaced with "Robot" icon.  
It'll pop up a "The app isn't installed" message when click these icons.

#### Root Cause  
  * Each favorite icon or hotseat is one record in the `favorites` table of Launcher2 database:  
     `/data/data/com.android.launcher/databases/launcher.db`  
     Each record includes a `component` which is consist of package name and class name.  
     Ex:  `component=com.google.android.gms/.common.settings.GoogleSettingsActivity`  
     package: `com.google.android.gms`  
     class: `com.google.android.gms.common.settings.GoogleSettingsActivity`

  * Launcher2 Database won't be erased after OTA
  * Package name or class name is changed in new system image

#### How to Fix  
  We can leverage AOSP's OneTimeInitializer to update the invalid component records in launcher.db.

  * Copy `packages/apps/OneTimeInitializer` to a new `packages/apps/MyOneTimeInitialzer`

  * Modify `AndroidManifest.xml` if GMS packages are prebuilt.
        
            <receiver
                android:name=".OneTimeInitializerReceiver">
                <intent-filter>
                    <!-- If GMS is prebuilt, GoogleOneTimeInitializer will send this broadcast after it's done -->
                    <action
                        android:name="com.google.android.onetimeinitializer.ONE_TIME_INITIALIZED"/>
                    <!-- If GMS is NOT prebuilt, use receiver for BOOT_COMPLETED as AOSP's OneTimeInitializer
                    <action
                        android:name="android.intent.action.BOOT_COMPLETED"/>
                    -->
                </intent-filter>
            </receiver>

  * Modify `OneTimeInitializerReceiver.java`  
    Replace `updateDialtactsLauncher()` to `updateLauncherDB()` and copy the following code:

    <pre><code>
    private void updateLauncherDB() {
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(LAUNCHER_CONTENT_URI,
                new String[]{LAUNCHER_ID_COLUMN, LAUNCHER_INTENT_COLUMN}, null, null, null);
        if (c == null) {
            return;
        }

        Resources res = getResources();
        String[] oldComponents = res.getStringArray(R.array.old_components);
        String[] newComponents = res.getStringArray(R.array.new_components);

        if (oldComponents == null || oldComponents.length == 0 ||
            newComponents == null || newComponents.length == 0) {
            return;
        }

        try {
            if (Log.isLoggable(TAG, Log.DEBUG)) {
                Log.d(TAG, "Total launcher icons: " + c.getCount());
            }

            while (c.moveToNext()) {
                long favoriteId = c.getLong(0);
                final String intentUri = c.getString(1);
                if (intentUri != null) {
                    try {
                        final Intent intent = Intent.parseUri(intentUri, 0);
                        final ComponentName componentName = intent.getComponent();
                        final Set<String> categories = intent.getCategories();

                        for (int i = 0; i < oldComponents.length; i++) {
                            String[] strs = oldComponents[i].split("/");
                            String oldPkgName = strs[0];
                            String oldClassName = strs[1];
                            if (oldClassName.startsWith("."))
                                oldClassName = oldPkgName + oldClassName;

                            if (Intent.ACTION_MAIN.equals(intent.getAction()) &&
                                componentName != null && categories != null &&
                                categories.contains(Intent.CATEGORY_LAUNCHER) &&
                                oldPkgName.equals(componentName.getPackageName()) &&
                                oldClassName.equals(componentName.getClassName())) {

                                if (newComponents[i].length() == 0) {  // new component == null, remove old component in database
                                    Log.v(TAG, "need to remove: " + oldComponents[i]);

                                    String deleteWhere = LAUNCHER_ID_COLUMN + "=" + favoriteId;
                                    cr.delete(LAUNCHER_CONTENT_URI, deleteWhere, null);
                                } else {
                                    Log.v(TAG, oldComponents[i] + " -> " + newComponents[i]);

                                    strs = newComponents[i].split("/");
                                    String newPkgName = strs[0];
                                    String newClassName = strs[1];

                                    if (newClassName.startsWith("."))
                                        newClassName = newPkgName + newClassName;

                                    Log.v(TAG, "oldPkgName = " + oldPkgName);
                                    Log.v(TAG, "oldClassName = " + oldClassName);
                                    Log.v(TAG, "newPkgName = " + newPkgName);
                                    Log.v(TAG, "newClassName = " + newClassName);

                                    final ComponentName newName = new ComponentName(newPkgName, newClassName);
                                    intent.setComponent(newName);
                                    final ContentValues values = new ContentValues();
                                    values.put(LAUNCHER_INTENT_COLUMN, intent.toUri(0));

                                    String updateWhere = LAUNCHER_ID_COLUMN + "=" + favoriteId;
                                    cr.update(LAUNCHER_CONTENT_URI, values, updateWhere, null);
                                }
                            }
                        }
                    } catch (RuntimeException ex) {
                        Log.e(TAG, "Problem moving Dialtacts activity", ex);
                    } catch (URISyntaxException e) {
                        Log.e(TAG, "Problem moving Dialtacts activity", e);
                    }
                }
            }

        } finally {
            if (c != null) {
                c.close();
            }
        }
    }
        </code></pre>

  * To update components in launcher.db,  
    add two string array resources for old components and new components(same order and count):  
      `mkdir -p res/values`  
      `vi res/values/update_components.xml`:  

        <?xml version="1.0" encoding="utf-8"?>
        <resources>
            <string-array name="old_components" translatable="false">
                <item>com.box.android/.activities.SplashScreenActivity</item>
                <item>com.google.android.gms/.common.settings.GoogleSettingsActivity</item>
                <item>com.android.gallery3d/com.android.camera.CameraLauncher</item>
            </string-array>
            <string-array name="new_components" translatable="false">
                <item></item> <!-- leave empty means remove this component in db -->
                <item>com.google.android.gms/.app.settings.GoogleSettingsActivity</item>
                <item>com.google.android.GoogleCamera/com.android.camera.CameraLauncher</item>
            </string-array>
        </resources>

    Leave empty`<item></item>` means you want to remove such favorite in launcher.db

#### Complete Example Source Code:  
<https://github.com/northbright/MyOneTimeInitializer>