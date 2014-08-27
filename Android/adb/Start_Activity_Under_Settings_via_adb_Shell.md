
# Start Activity Under Settings via adb Shell

The activity name under Settings contains '$'.  
Ex:  
`<activity android:name="Settings$VpnSettingsActivity"`  

Because '$' will be escaped by shell, we use '\$'.  
Ex:  
`adb shell am start -n com.android.settings/.Settings\$VpnSettingsActvity`
