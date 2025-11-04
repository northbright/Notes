# Upgrade Hikvision NVR from USB Drive

## Steps
1. Get Latest NVR Firmware

  * Method A: Call Hikvision Service to get the firmware of NVR
    * Call `4008005998` and press `2`(NVR and Camera)
    * Provide Model and SN to support engineer
      * Go to NVR > maintainence > basic info > "Model" and "SN"
    * Support engineer will provides firmware download links according to the model and SN 
    * It needs to upgrade 2 or more times if current version is too far behind latest version
       
      e.g. To upgrade `v3.47.97.Build 171104` to `v3.4.112.Build 200617`, it has to upgrade NVR to `v3.4.107.Build 190927` firstly.  

  * Method B: Get Latest NVR Firmware from Hikvision Official Site
    * Visit [升级包与驱动下载](https://partners.hikvision.com/support/upgrade/download)
    * Input the Product SN of NVR and Query
      * You may find the SN on web portal: Go to Preferences > System > System Settings > Product SN
    * Input Current Firmware Version（主控版本）and Query
      * You may find the firmware version on web portal: Go to Preferences > System > System Settings > Firmware Version（主控版本）
    * Download the latest firmware

2. Prepare USB drive
  * Extract the downloaded `.zip` file to a dir
  * Copy `digicap.dav` to the root of a USB drive

3. Upgrade NVR
  * Plug the USB drive into NVR
  * Go to NVR > mantainence > upgrade > local upgrade tab
  * Select the USB drive
  * Select `digicap.dav`
  * Click "Upgrade" button
  * It'll reboot after the upgrade is done

4. All settings(include channel, network, storage plan...) will keep after upgrade

## Reference
* [【NVR 3.0】外接显示器版本升级](https://knowbot.hikvision.com/webchatbot-pc/#/sharingPath?params=359393&sysNum=1693447044565&flowItemId=9880&type=1)
