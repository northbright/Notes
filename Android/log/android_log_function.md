
# Android / NDK apps use `__android_log_print()` to output log messages

`system/core/liblog/logd_write.c`:  
    
    int __android_log_print(int prio, const char *tag, const char *fmt, ...)


#### References
* <http://stackoverflow.com/questions/16720854/android-ndk-android-log-print-function-andlogcat>