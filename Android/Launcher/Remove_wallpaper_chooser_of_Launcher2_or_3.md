
# Remove Wallpaper Chooser of Launcher2 / 3

###### Description:  
If you integrate both Launcher2 / 3 in system for some reason(Ex: migrate Launcher2 shortcuts to Launcher3 via OTA),  
We can see 2 "Wallpapers" menus under:  
"Settings" -> "Display" -> "Wallpapers"

###### Root Cause:  
1. To migrate shortcuts from Launcher2(KK) to Launcher3(L), we need to integrate Launcher2.apk in L image
2. Both Launcher2 / 3 have Wallpaper Chooser
3. "Settings" -> "Display" -> "Wallapers" will detect all available Wallpaper Chooser

###### How to Fix:  
Remove Launcher2 Wallpaper Chooser in AndroidManifest.xml:

        <!-- Remove Launcher2 Wallpaper Chooser because we just use Launcher3's Wallpaper Chooser Only -->
        <!--
        <activity
            android:name="com.android.launcher2.WallpaperChooser"
            android:theme="@style/Theme.WallpaperPicker"
            android:label="@string/pick_wallpaper"
            android:icon="@mipmap/ic_launcher_wallpaper"
            android:finishOnCloseSystemDialogs="true"
            android:process=":wallpaper_chooser">
            <intent-filter>
                <action android:name="android.intent.action.SET_WALLPAPER" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
            <meta-data android:name="android.wallpaper.preview"
                android:resource="@xml/wallpaper_picker_preview" />
        </activity>
        -->
        