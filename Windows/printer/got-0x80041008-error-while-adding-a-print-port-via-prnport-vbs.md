# Got `0x80041008` Error while Adding a Print Port via [`prnport.vbs`](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc754352(v=ws.10))

## Background
* Plan to add a network printer programmatically
  1. Use [prnport.vbs](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc754352(v=ws.10)) to add a print port
  2. Use [printui.dll,PrintUIEntry](https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/rundll32-printui) to add a network printer
* It added an EPSON L6168 printer specified IP: 192.168.1.159 via the BAT file successfully:

      cscript "c:\Windows\System32\Printing_Admin_Scripts\zh-CN\prnport.vbs" -a -r IP_192.168.1.159 -h 192.168.1.159

      rundll32 printui.dll,PrintUIEntry /if /b "MyPrinter" /f "\\server\Path\To\Driver\E_WF1SQE.INF" /r "IP_192.168.1.159" /m "EPSON L6160 Series"

* It **failed** to add a Canon G3800 printer specified IP: 192.168.1.59 via the **SAME** BAT file(JUST change the IP)

## Problem
* Got `0x80041008` error code while run [prnport.vbs](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc754352(v=ws.10)) to add a print port the BAT file:
  > 无法创建/更新端口 IP_192.168.1.59 错误 0x80041008 Invalid parameter

## Root Cause
* The printer port uses TCP raw protocol but **NOT** TCP LPR(default if not specified)

## Solution
* Use `-o{raw|lpr}` option to specify which protocol the port uses: TCP raw or TCP LPR

      cscript "c:\Windows\System32\Printing_Admin_Scripts\zh-CN\prnport.vbs" -a -r IP_192.168.1.59 -h 192.168.1.59 -o raw

      rundll32 printui.dll,PrintUIEntry /if /b "G3800 Scanner" /f "\\server\PATH\To\Driver\G3000P6.inf" /r "IP_192.168.1.59" /m "Canon G3000 series Printer"

## References
* [rundll32 printui.dll,PrintUIEntry](https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/rundll32-printui)
* [Prnport.vbs](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2008-R2-and-2008/cc754352(v=ws.10))
* [How do I add a standard TCP/IP printer port from a command line?](https://superuser.com/questions/61659/how-do-i-add-a-standard-tcp-ip-printer-port-from-a-command-line/235405)
* [Printer Install Script - prndrvr.vbs, prnport.vbs, and prnmngr.vbs just comes up with "useage" - how do I properly execute?](https://social.technet.microsoft.com/Forums/windows/en-US/aabb9a4a-6e02-49b3-8af5-aeb7c43f1ed3/printer-install-script-prndrvrvbs-prnportvbs-and-prnmngrvbs-just-comes-up-with)
