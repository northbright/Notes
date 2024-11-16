# Update BIOS of HP Z238

## Steps

#### Download Latest BIOS
* Visit [HP 客户支持](https://support.hp.com/cn-zh) and search "z238"
* Select Z238 tower workstation > Software and Driver > BIOS > Click "Download" to get [sp154352](https://ftp.hp.com/pub/softpaq/sp154001-154500/sp154352.exe)

#### Run [sp154352.exe] to Extract the BIOS Files
Click "sp154352.exe" and extract BIOS files(default path: `C:\SWSetup\sp154352`).

#### Update BIOS
* Go to `C:\SWSetup\sp154352\HPFWUPDREC`
* Click "HPBIOSUPDREC.exe" > Update > Continue without Create BIOS Backup Partition > Next
* After the new version of BIOS is flashed, it'll reboot **AUTOMATICALLY**

## Refrences
* [惠普工作站如何升级UEFI BIOS](https://jingyan.baidu.com/article/046a7b3ea9542ff9c27fa9d3.html)
