
# How to set SystemProperties in AOSP

1. Use system uid in `AndroidManifest.xml`:

        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
            package="com.android.setprop"
            android:sharedUserId="android.uid.system" >

2. Use platform key in `Android.mk`:

        LOCAL_CERTIFICATE := platform

3. If `LOCAL_SDK_VERSION` exists in `Android.mk`, remove it to use @hide internal API: `android.os.SystemProperties`

4. Import package in Java source code:

        import android.os.SystemProperties;

5. Property name / value requirements:
    * Property name length should <= 31:  
      `PROP_NAME_MAX` in `prebuilts/ndk/XX/platforms/android-XX/arch-XX/usr/include/sys/system_properties.h`
    * Property value length should <= 92:  
      `PROP_VALUE_MAX` in `prebuilts/ndk/XX/platforms/android-XX/arch-XX/usr/include/sys/system_properties.h`
    * Property name has `sys.` prefix will be cleared after reboot.
    * Property name has `persist.xx` prefix will keep the value after reboot.
    * Property name and caller's UID / GID should follow the perm(prefix) and UID / GID defined in `system/core/init/property_service.c`:

            struct {
                const char *prefix;
                unsigned int uid;
                unsigned int gid;
            } property_perms[] = {
                { "net.rmnet0.",      AID_RADIO,    0 },
                { "net.gprs.",        AID_RADIO,    0 },
                { "net.ppp",          AID_RADIO,    0 },
                { "net.qmi",          AID_RADIO,    0 },
                { "net.lte",          AID_RADIO,    0 },
                { "net.cdma",         AID_RADIO,    0 },
                { "ril.",             AID_RADIO,    0 },
                { "gsm.",             AID_RADIO,    0 },
                { "persist.radio",    AID_RADIO,    0 },
                { "net.dns",          AID_RADIO,    0 },
                { "sys.usb.config",   AID_RADIO,    0 },
                { "net.usb0.",        AID_RADIO,    0 },
                { "net.",             AID_SYSTEM,   0 },
                { "dev.",             AID_SYSTEM,   0 },
                { "runtime.",         AID_SYSTEM,   0 },
                { "hw.",              AID_SYSTEM,   0 },
                { "sys.",             AID_SYSTEM,   0 },
                { "sys.powerctl",     AID_SHELL,    0 },
                { "service.",         AID_SYSTEM,   0 },
                { "wlan.",            AID_SYSTEM,   0 },
                { "bluetooth.",       AID_BLUETOOTH,    0 },
                { "dhcp.",            AID_SYSTEM,   0 },
                { "dhcp.",            AID_DHCP,     0 },
                { "debug.",           AID_SYSTEM,   0 },
                { "debug.",           AID_SHELL,    0 },
                { "log.",             AID_SHELL,    0 },
                { "service.adb.root", AID_SHELL,    0 },
                { "service.adb.tcp.port", AID_SHELL,    0 },
                { "persist.sys.",     AID_SYSTEM,   0 },
                { "persist.service.", AID_SYSTEM,   0 },
                { "persist.security.", AID_SYSTEM,   0 },
                { "persist.service.bdroid.", AID_BLUETOOTH,   0 },
                { "selinux."         , AID_SYSTEM,   0 },
                { "wc_transport.",     AID_BLUETOOTH,   AID_SYSTEM },
                { "usb_uicc.", AID_SYSTEM,  0 },
                { NULL, 0, 0 }
            };

6. Set / get properties.  
        
        final String PROP_NAME = "persist.sys.my.prop";
        ....
        public void set(View view) {
            SystemProperties.set(PROP_NAME, "1");
            int ret = SystemProperties.getInt(PROP_NAME, 0);
            // SystemProperties.getString(PROP_NAME); // for string value
        }


7. Build apk in AOSP environment:

        make clean-MY_PACKAGE  // if already exists
        make MY_PACKAGE

8. Here's the [sample code(./SetProp)](./SetProp)
9. Reference:<http://www.cnblogs.com/riskyer/p/3424132.html>