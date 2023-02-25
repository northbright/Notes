# BitLocker Device Encryption is Enabled by Default on a Clean Install Windows 11 after OOBE

## Problem
* Made a clean Windows 11 Home installation on Dell Precision 3460
* Activated Windows 11 Successfully
* Boot PC via a USB disk with WinPE Installed
* Found Yellow Lock Icon On Drive C / D(Bitlocker) in Explorer

## Root Cause
BitLocker Device Encryption is enabled by default on a clean install Windows 11 after OOBE. See [BitLocker Device Encryption](https://learn.microsoft.com/en-us/windows/security/information-protection/bitlocker/bitlocker-device-encryption-overview-windows-10#bitlocker-device-encryption)

  > When a clean installation of Windows 11 or Windows 10 is completed and the out-of-box experience is finished, the computer is prepared for first use. As part of this preparation, BitLocker Device Encryption is initialized on the operating system drive and fixed data drives on the computer with a clear key that is the equivalent of standard BitLocker suspended state. In this state, the drive is shown with a warning icon in Windows Explorer. The yellow warning icon is removed after the TPM protector is created and the recovery key is backed up, as explained in the following bullet points.

## Disable Automatic BitLocker Device Encryption

Set `PreventDeviceEncryption` to `1`(DWORD).

* Subkey: `HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\BitLocker`
* Type: `DWORD`
* Value: `PreventDeviceEncryption` equal to 1 (True)

## References
* [BitLocker: need a key but I never installed it](https://www.dell.com/community/Windows-10/BitLocker-need-a-key-but-I-never-installed-it/td-p/6019486)
* [BitLocker Device Encryption](https://learn.microsoft.com/en-us/windows/security/information-protection/bitlocker/bitlocker-device-encryption-overview-windows-10#bitlocker-device-encryption)
* [How to Disable Automatic BitLocker Encryption](https://social.technet.microsoft.com/Forums/Lync/en-US/227d1806-8c29-41a8-b05f-ab07ad7c4aa4/how-to-disable-automatic-bitlocker-encryption)
