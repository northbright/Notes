/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.onetimeinitializer;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.net.URISyntaxException;
import java.util.Set;

// Make default font scale configurable.
// Step 1. import necessary packages.
import android.os.RemoteException;
import android.content.res.Configuration;
import android.app.ActivityManagerNative;

/**
 * A class that performs one-time initialization after installation.
 *
 * <p>Android doesn't offer any mechanism to trigger an app right after installation, so we use the
 * BOOT_COMPLETED broadcast intent instead.  This means, when the app is upgraded, the
 * initialization code here won't run until the device reboots.
 */
public class OneTimeInitializerService extends IntentService {

    // class name is too long
    private static final String TAG = OneTimeInitializerService.class.getSimpleName()
            .substring(0, 22);

    // Name of the shared preferences file.
    private static final String SHARED_PREFS_FILE = "oti";

    // Name of the preference containing the mapping version.
    private static final String MAPPING_VERSION_PREF = "mapping_version";

    // This is the content uri for Launcher content provider. See
    // LauncherSettings and LauncherProvider in the Launcher app for details.
    private static final Uri LAUNCHER_CONTENT_URI =
            Uri.parse("content://com.android.launcher2.settings/favorites?notify=true");

    private static final String LAUNCHER_ID_COLUMN = "_id";
    private static final String LAUNCHER_INTENT_COLUMN = "intent";

    private SharedPreferences mPreferences;

    public OneTimeInitializerService() {
        super("OneTimeInitializer Service");
    }

    // Make default font scale configurable.
    // Step 2. Add updateFontScale() function.
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


    @Override
    public void onCreate() {
        super.onCreate();
        mPreferences = getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);

        // Make default font scale configurable.
        // Step 3. Call updateFontScale() one time.
        updateFontScale();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "OneTimeInitializerService.onHandleIntent");
        }

        final int currentVersion = getMappingVersion();
        int newVersion = currentVersion;
        if (currentVersion < 1) {
            if (Log.isLoggable(TAG, Log.INFO)) {
                Log.i(TAG, "Updating to version 1.");
            }
            updateDialtactsLauncher();

            newVersion = 1;
        }

        updateMappingVersion(newVersion);
    }

    private int getMappingVersion() {
        return mPreferences.getInt(MAPPING_VERSION_PREF, 0);
    }

    private void updateMappingVersion(int version) {
        SharedPreferences.Editor ed = mPreferences.edit();
        ed.putInt(MAPPING_VERSION_PREF, version);
        ed.commit();
    }

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
                                "com.android.contacts".equals(componentName.getPackageName()) &&
                                "com.android.contacts.activities.DialtactsActivity".equals(
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
}
