
# 4.2 OTA update 至 4.4，GoogleOneTimeInitializer会修改Dialer的Intents,导致Launcher2中的Dialer显示机器人，点击后“找不到应用”

* Bug Detail  
  4.2的default_workspace包含有Dialer在home screen上，但是OTA升级至4.4(均带GMS)后，Dialer的icon显示为机器人，点击后“找不到应用”

* Root Cause  
  + 所带的GMS包含GoogleOnetimeInitializer，会在`android.permission.RECEIVE_BOOT_COMPLETED`的broadcast发出后，执行1次。  
  + 会去使用Launcher2的content resolver来check dialer的intent。如果满足以下条件：  
      + package name / class name = `com.android.contacts/com.android.contacts.activities.DialtactsActivity`
      + 或 package name / class name = `com.android.dialer/com.android.dialer.DialtactsActivity`  
      
    那么package name / class name将会被替换成`com.google.android.dialer/com.android.dialer.DialtactsActivity`  
    可以使用Dex2jar + jd-GUI来decompile GoogleOneTimeInitializer的代码。

* How to Fix  
  + GoogleOneTimeInitializer会在结束的时候发出action为`com.google.android.onetimeinitializer.ONE_TIME_INITIALIZED`的broadcast
  + 参考AOSP的OneTimeInitializer，写一个receiver来在收到该broadcast之后，再次修改Dialer为：  
  `com.android.dialer/com.android.dialer.DialtactsActivity`
  + 具体代码可以参考[./UpdateLauncherDB](./UpdateLauncherDB)(copy / modify from packages/apps/OneTimeInitializer).

* Code Piece  
<pre><code>

    private void updateDialtactsLauncher() {
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(LAUNCHER_CONTENT_URI,
                new String[]{LAUNCHER_ID_COLUMN, LAUNCHER_INTENT_COLUMN}, null, null, null);
        if (c == null) {
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
                        if (Intent.ACTION_MAIN.equals(intent.getAction()) &&
                                componentName != null &&
                                "com.google.android.dialer".equals(componentName.getPackageName()) &&
                                "com.android.dialer.DialtactsActivity".equals(
                                        componentName.getClassName()) &&
                                categories != null &&
                                categories.contains(Intent.CATEGORY_LAUNCHER)) {

                            final ComponentName newName = new ComponentName("com.android.dialer",
                                    "com.android.dialer.DialtactsActivity");
                            intent.setComponent(newName);
                            final ContentValues values = new ContentValues();
                            values.put(LAUNCHER_INTENT_COLUMN, intent.toUri(0));

                            String updateWhere = LAUNCHER_ID_COLUMN + "=" + favoriteId;
                            cr.update(LAUNCHER_CONTENT_URI, values, updateWhere, null);
                            if (Log.isLoggable(TAG, Log.INFO)) {
                                Log.i(TAG, "Updated " + componentName + " to " + newName);
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

