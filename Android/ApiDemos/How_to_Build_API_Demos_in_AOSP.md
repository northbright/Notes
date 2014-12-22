
# How to Build ApiDemos in AOSP Environment(Android L)

* Copy `development/samples/ApiDemos/*` to `packages/apps/`
* Uncomment `#include $(BUILD_PACKAGE)` in `ApiDemos/Android.mk` and `ApiDemos/tests/Android.mk`
        
        # Android.mk
        ......
        include $(BUILD_PACKAGE)  #uncomment this line to build this package
        ......