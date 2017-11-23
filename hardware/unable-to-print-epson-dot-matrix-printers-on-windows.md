# Unable Print to EPSON Dot Matrix Printer

#### Details
* EPSON dot matrix printers work fine before.
* It can not print to EPSON printers suddenly(November, 2017).
* Reinstall printer drivers does **NOT** work.

#### Root Cause
Windows Updates installed:

* Windows 7
  KB4048957, KB4048960

* Windows 10
  KB4048952, KB4048953, KB4048954, KB4048955

#### Solution
* Windows 7 / 8
  * Microsoft have now issued an updated patch which will should download automatically via Windows Update.
  * You may also install the update manually from here:
    <https://support.microsoft.com/en-us/help/4055038/november-21-2017-kb4055038>

* Windows 10
  * Microsoft's patch is not ready(2017/11/23).
  * Uninstall Windows Updates.

        wusa /uninstall /kb:4048952 /quiet /warnrestart
        wusa /uninstall /kb:4048953 /quiet /warnrestart
        wusa /uninstall /kb:4048954 /quiet /warnrestart
        wusa /uninstall /kb:4048955 /quiet /warnrestart

#### References
* [Unable to Print to Epson Dot Matrix printers after Windows Updates](https://www.tachytelic.net/2017/11/unable-print-dot-matrix-printers-windows-updates/)
* [Microsoft confirms Epson Printer bug caused by November 2017 updates](https://www.ghacks.net/2017/11/17/microsoft-confirms-epson-printer-bug-caused-by-november-2017-updates/)
* <https://support.microsoft.com/en-us/help/4055038/november-21-2017-kb4055038>
