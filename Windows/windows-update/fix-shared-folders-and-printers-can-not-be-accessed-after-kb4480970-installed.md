# Fix Shared Folders and Printers Can Not Be Accessed After KB4480970 Installed

## Problem
* Shared folders and printers on Windows 7 PC can not be accessed by others after KB4480970 installed
* The shared folders and printers are 
* `ping` the IP of the PC succeeded
* Failed to explore the shared resources by inputing `\\PC-Name` or `\\IP`

## Root Cause
* KB4480970 was installed automatically via Windows Update
* It has known network issue

## Solution(Temporary)
* Run a cmd as adimistrator
* Input:

   `reg add HKLM\SOFTWARE\Microsoft\Windows\CurrentVersion\Policies\system /v LocalAccountTokenFilterPolicy /t REG_DWORD /d 1 /f`

  > **Warning:** The above registry ‘hack’ is just a quick fix. But keep in mind, that this is lowering security – your client has ‘admin credentials’ on shares (bad, if malware nooping your network). So keep this registry change in mind – after Microsoft has released a fix, reset the LocalAccountTokenFilterPolicy to 0.

  See [Network issues with updates KB4480970 and KB4480960](https://borncity.com/win/2019/01/09/netzwerk-issues-with-updates-kb4480970-and-kb4480960/) for more information

## Solution(Updated)
* This issue is resolved in [KB4487345](https://support.microsoft.com/en-us/help/4487345)

## References
* [Network issues with updates KB4480970 and KB4480960](https://borncity.com/win/2019/01/09/netzwerk-issues-with-updates-kb4480970-and-kb4480960/)
* [KB4480970 causes on the Windows 2008 R2 Server impossibility to connect to by Clients](https://social.technet.microsoft.com/Forums/en-US/c69f6413-0ca6-42cc-8a30-6d57ef49f3ff/kb4480970-causes-on-the-windows-2008-r2-server-impossibility-to-connect-to-by-clients?forum=winserverwsus)
* [January 8, 2019—KB4480970 (Monthly Rollup)](https://support.microsoft.com/en-us/help/4480970/windows-7-update-kb4480970)
* [Description of the update for Windows 7 SP1 and Windows Server 2008 R2: January 11, 2019](https://support.microsoft.com/en-us/help/4487345/update-for-windows-7-sp1-and-windows-server-2008-r2)
