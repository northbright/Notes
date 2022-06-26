# BitComet Disappeared on Windows 10

## Problem
* BitComet program / link disappeared suddenly after Windows 10 started

## Root Cause
* Windows Defender Antivirus recognized BitComet as "PUA:Win32/BitComet" and blocked BitComet

## Solution
* Goto Windows Defender Antivirus > Click the event > Restore
* Turn off PUA(Potentially unwanted app blocking)

## References
* [Detect and block potentially unwanted applications](https://docs.microsoft.com/en-us/microsoft-365/security/defender-endpoint/detect-block-potentially-unwanted-apps-microsoft-defender-antivirus?view=o365-worldwide)
* [windows defender blocks qbittorrent - PUA and/or Trojan detection](https://github.com/qbittorrent/qBittorrent/issues/14489)
