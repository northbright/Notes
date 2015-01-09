
# Copy Boot Animation

Boot animation file is `/system/media/bootanimation.zip`  
We need to copy bootanimation.zip to `/system/media/bootanimation.zip` in `.mk` file.

`device/xx/xx.mk`:  

    # Boot Animation
    PRODUCT_COPY_FILES += \
        device/xx/xx/bootanimation.zip:system/media/bootanimation.zip
