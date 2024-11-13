# Use ExifTool to Make it Easy to Select Photos when Using Print Service on Taobao App on iOS to Print Photos

## Problem
* Purchased the photo print service from one provider on Taobao App on iOS
* Some photos are stored in the SD card which were taken using digital camera.
* Using AirDrop to copy the photos on the SD card from mac to iPhone
* Click "Upload Photos" button for the order in Taobao app.
* Taobao app can NOT open album(such as "recent" which sorts the photo by created time) but can only open a dialog to show all photos sorted by original date / time.
* The photos need to print are mixed in the photos on the iPhone due to their original date / time.
* It takes a long time to find and select the photos to print in the dialog.

## Solution
Use [ExifTool](https://exiftool.org/) to bulk set original date / time of photos to **NOW** to make these photos in the end of all photos in the dialog.

* [Install ExifTool on Ubuntu](https://github.com/northbright/Notes/blob/master/Software/exiftool/install-exiftool-on-ubuntu.md)
* [Bulk Set Original Date and Time of Photos using ExifTool](https://github.com/northbright/Notes/blob/master/Software/exiftool/bulk-set-original-date-and-time-of-photos-using-exiftool.md)

---------------------

# 使用 ExifTool 让 iOS 上的淘宝 App 在使用冲印照片服务时更容易选择照片

## 问题
* 购买了 iOS 的淘宝 App 上的照片冲印服务商的照片冲印服务
* 一些照片是由数码相机拍摄的，存放在 SD 卡上
* 使用 AirDrop 将这些照片从 mac 上传送到 iPhone 上
* 在淘宝 App 的订单页面，点击“上传照片”按钮
* 淘宝 App 不能打开相簿（比如“最近项目”，是按照创建时间降序排列的），只能打开一个对话框按照拍摄日期/时间的顺序来显示所有照片
* 要冲印的照片因为拍摄日期不是最新的，所以混在 iPhone 的原来的照片中
* 需要花费很长时间来查找和选择需要冲印的照片

## 解决方法
使用 [ExifTool](https://exiftool.org/) 来批量设置照片的拍摄日期到“现在”，这些照片将会出现在对话框的最后。

* [Install ExifTool on Ubuntu](https://github.com/northbright/Notes/blob/master/Software/exiftool/install-exiftool-on-ubuntu.md)
* [Bulk Set Original Date and Time of Photos using ExifTool](https://github.com/northbright/Notes/blob/master/Software/exiftool/bulk-set-original-date-and-time-of-photos-using-exiftool.md)
