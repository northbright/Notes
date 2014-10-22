
# `PRODUCT_PREBUILT_WEBVIEWCHROMIUM` will be set to true in GMS

AOSP's chromium packages will be skipped while building with GMS because `PRODUCT_PREBUILT_WEBVIEWCHROMIUM` is set to true in GMS.

in `external/chromium_org/Android.mk`:

    # Don't include anything if the product is using a prebuilt webviewchromium.
    ifneq ($(PRODUCT_PREBUILT_WEBVIEWCHROMIUM),yes)  // skip for GMS

    # We default to release for the Android build system. Developers working on
    # WebView code can build with "make GYP_CONFIGURATION=Debug".
    GYP_CONFIGURATION := Release

    include $(CHROMIUM_DIR)/GypAndroid.$(HOST_OS)-$(TARGET_ARCH).mk
    include $(CHROMIUM_DIR)/android_webview/Android.mk  // skip AOSP's LOCAL_MODULE := android_webview_java

    endif

So if you meet the ` MODULE.TARGET.JAVA_LIBRARIES.android_webview_java already defined by external/chromium_org/android_webview.  Stop.` error, you may have the GMS folder in your BSP but NOT include GMS mk file in your device mk.
