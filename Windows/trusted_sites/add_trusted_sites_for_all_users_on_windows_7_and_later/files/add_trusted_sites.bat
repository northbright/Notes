@echo off
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\github.com" /v https /d 2 /t REG_DWORD /f
reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Domains\cnbeta.com" /v http /d 2 /t REG_DWORD /f
