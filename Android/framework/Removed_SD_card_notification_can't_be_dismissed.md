
# "Removed SD card" notification can't be dismissed

Android Version: KitKat 4.4.4

* Description
    * Boot device with SD card inserted
    * Unmount SD card in "Settings" -> "Storage" -> "Unmount SD card"
    * Remove SD card from device
    * "Removed SD card" notification pops and can't be dismissed like other notifications

* Why  
  It's by AOSP design:  
  `frameworks/base/packages/SystemUI/src/com/android/systemui/usb/StorageNotification.java`:

        } else if (newState.equals(Environment.MEDIA_REMOVED)) {
            setMediaStorageNotification(
                com.android.internal.R.string.ext_media_nomedia_notification_title,
                com.android.internal.R.string.ext_media_nomedia_notification_message,
                com.android.internal.R.drawable.stat_notify_sdcard_usb,
                true, false, null);   // penultimate parameter is "dismissable"

        private synchronized void setMediaStorageNotification(
            int titleId, int messageId, int icon, boolean visible, boolean dismissable, PendingIntent pi) {
            ....}
