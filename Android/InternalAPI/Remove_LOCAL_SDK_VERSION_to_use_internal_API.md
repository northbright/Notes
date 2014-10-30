
# Remove LOCAL_SD_VERSION to use internal(@hide) APIs in AOSP

Sometimes, you may use internal APIs(android.os.SystemProperties) in AOSP (packages/apps/Email).  
But you may get the error: "can not find symbol: xx" when build the source.

How to Fix:

* Check if `LOCAL_SDK_VERSION := current` exists in `Android.mk`  
* Remove or comment it.