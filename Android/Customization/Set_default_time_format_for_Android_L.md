
# Set Default Time Format for Android L

We can find new string `def_time_format` in  
`packages/SettingsProvider/res/values/customize.xml`:

    <!-- Time format,default vlaue is 24 : 24 format,other value is 12 format -->
    <string name="def_time_format" translatable="false">24</string>

So, We can add overlay file of SettingsProvider to set default time format to 12:  
`overlay/frameworks/base/packages/SettingsProvider/res/values/defaults.xml`:  
    
    <string name="def_time_format" translatable="false">12</string>