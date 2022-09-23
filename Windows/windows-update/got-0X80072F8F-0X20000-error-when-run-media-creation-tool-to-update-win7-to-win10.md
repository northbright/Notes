# Got 0X80072F8F - 0X20000 Error When Run Media Creation Tool to Update Win7 to Win10

## Problem
* Want to run [MediaCreationTool21H2](https://go.microsoft.com/fwlink/?LinkId=691209) to update Windows 7 to Windows 10
* Got 0X80072F8F - 0X20000 error when run [MediaCreationTool21H2](https://go.microsoft.com/fwlink/?LinkId=691209)

## Root Cause
* Some server that the MediaCreationTool21H2.exe tries to talk to apparently no longer speaks the old TLS 1.0 security protocol, but Windows 7 SP1 still has the newer TLS 1.1 and TLS 1.2 disabled by default

## Solution
1. Install ["Easy fix 51044” MSI](https://download.microsoft.com/download/0/6/5/0658B1A7-6D2E-474F-BC2C-D69E5B9E9A68/MicrosoftEasyFix51044.msi)
2. Install [KB3140245](https://www.catalog.update.microsoft.com/search.aspx?q=kb3140245)

## References
* [Media Creation Tool - error code 0X80072F8F - 0X20000](https://answers.microsoft.com/en-us/windows/forum/all/media-creation-tool-error-code-0x80072f8f-0x20000/4f8bbe1c-b5af-4cc9-958e-c6c8f3f0b524?page=4)
  * See Markus Kuhn's answer on page 3
* [Update to enable TLS 1.1 and TLS 1.2 as default secure protocols in WinHTTP in Windows](https://support.microsoft.com/en-us/topic/update-to-enable-tls-1-1-and-tls-1-2-as-default-secure-protocols-in-winhttp-in-windows-c4bd73d2-31d7-761e-0178-11268bb10392#bkmk_easy)
* [[Fix] Media Creation Tool Error 0x80072F8F – 0x20000 in Windows 7/8](https://www.winhelponline.com/blog/media-creation-tool-error-0x80072f8f-0x20000/)
