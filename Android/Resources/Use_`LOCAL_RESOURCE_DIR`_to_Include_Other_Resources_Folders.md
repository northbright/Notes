
# Use `LOCAL_RESOURCE_DIR` to Include Other Resources Folders

Ex: `Android.mk`:

    LOCAL_RESOURCE_DIR += $(LOCAL_PATH)/res 
    LOCAL_RESOURCE_DIR += packages/apps/Camera/res