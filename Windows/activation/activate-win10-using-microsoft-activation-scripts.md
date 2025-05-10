# Activate Win10 using Microsoft Activation Scripts

## Steps
* Install Win10 from Official ISO
* Press `win` + `r` and type `powershell` to run "PowerShell"
* Type `irm https://massgrave.dev/get | iex`
  The recommended method: `irm https://get.activated.win | iex` may fail and get "can not resolve get.activated.win" error because that DNS providers in China block the new site.

* Select `[1] HWID` and wait activation complete
* Go to Settings > Activation > Check if Windows is activated

## References
* [Microsoft Activation Scripts (MAS)](https://github.com/massgravel/Microsoft-Activation-Scripts)
* <https://massgrave.dev/>
