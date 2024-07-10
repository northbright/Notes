# Install WSL 2 on Windows

## Steps

#### Install WSL with Default Distro(Ubuntu)
* Run "PowerShell" as **Administrator**

  ```
  wsl --install
  ```

  or

  ```
  wsl --install -d ubuntu
  ```
  
  * Click "OK" to Allow Windows Main Process to Make Change to Your PC
  * It says: >
    
    > Ubuntu is installed.
    > Requested operation succeeded. It won't take effect until reboot.

  * If You Got "WslRegisterDistribution error 0x80370102", Enable VTx in BIOS Settings
    See [Fix "0x80370102" Error when Install Linux Distro for WSL 2](https://github.com/northbright/Notes/blob/master/Windows/wsl/fix-0x80370102-error-when-install-linux-distro-for-wsl-2.md) for more information.

* Reboot PC

* Type "Ubuntu" in the Search Bar and Click "Ubuntu" to Start Ubuntu

* You'll be Asked to Input Username and Password to Create a Linux Account

#### Check Distro and WSL Version
* Run "PowerShell" as **Administrator**

  ```
  wsl -l -v
  ```

  Output:
  | NAME | STATE | VERSION |
  | :--: | :--: | :--: |
  | Ubuntu | Runnint | 2 |

* If WSL version is 1, Set Default WSL Version to 2(optional)

  ```
  wsl --set-default-version 2
  ```

## References
* [How to Install WSL 2 on Windows 10, 11, and Server 2022](https://www.configserverfirewall.com/windows-10/windows-subsystem-for-linux-2/)
* [How to Convert WSL 1 Linux Distribution to WSL 2 in Windows Subsystem for Linux](https://www.configserverfirewall.com/windows-10/convert-wsl-1-linux-distribution-to-wsl-2/)
* [Fix "0x80370102" Error when Install Linux Distro for WSL 2](https://github.com/northbright/Notes/blob/master/Windows/wsl/fix-0x80370102-error-when-install-linux-distro-for-wsl-2.md)
