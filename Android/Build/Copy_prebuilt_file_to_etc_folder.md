
# Copy Prebuilt File to `/etc`

`Android.mk`:  

        LOCAL_MODULE_CLASS := ETC
        LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)