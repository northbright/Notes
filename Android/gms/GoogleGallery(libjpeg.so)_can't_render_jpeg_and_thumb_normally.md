
# Google Gallery can't render jpeg and thumb normally

Android Version: KitKat 4.4.4  
GMS Version: 4.4 R5

Google Gallery can't render jpeg and thumb normally sometimes(GMS 4.4 R5).  
Ex: <http://gallery.dralzheimer.stylesyndication.de/galleries/wallpaper/Cloudfire-Wallpaper.jpg>

* GMS's libjpeg.so will override AOSP's libjpeg.so
* libjpeg.so in GMS 4.4 R5 has this issue but the one in GMS 4.4 R4 not.
* AOSP's libjpeg.so works
* If you want to replace GMS 4.4 R5's libjpeg.so with AOSP's, please remove the photo on device and copy it again and reboot the device or Google Gallery will read the cache on /data(it'll take no effect).