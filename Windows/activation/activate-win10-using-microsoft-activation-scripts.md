# Activate Win10 using Microsoft Activation Scripts

## Steps
* Install Win10 from Official ISO
* Press `win` + `r` and type `powershell` to run "PowerShell"
* Type `irm https://get.activated.win | iex`
* Select `[1] HWID` and wait activation complete
* Go to Settings > Activation > Check if Windows is activated
* If Windows Defender blocks the powershell process, allow the threat and re-run the script

## References
* [Microsoft Activation Scripts (MAS)](https://github.com/massgravel/Microsoft-Activation-Scripts)
* <https://massgrave.dev/>
* [Error when using new Activation Code irm https://get.activated.win | iex #507](https://github.com/massgravel/Microsoft-Activation-Scripts/issues/507)
* [irm : Unable to resolve remote name #498](https://github.com/massgravel/Microsoft-Activation-Scripts/issues/498)

# 使用 Microsoft Activation Scripts(MAS) 激活 Windows 10

## 方法
* 下载官方 Windows 10 ISO 进行安装
* 按下 `Win` + `r` 键 > 输入 `powershell` 然后回车
* 输入 `irm https://get.activated.win | iex`
* 选择 `[1] HWID` 然后等待激活完成
* 在 Windows 设置 > 激活 > 确认是否已经激活
* 如果 Windows 防火墙提示发现威胁阻止了 Powershell 进程，允许该威胁后再次运行脚本

## 参考资料
* [Microsoft Activation Scripts (MAS)](https://github.com/massgravel/Microsoft-Activation-Scripts)
* <https://massgrave.dev/>
* [Error when using new Activation Code irm https://get.activated.win | iex #507](https://github.com/massgravel/Microsoft-Activation-Scripts/issues/507)
* [irm : Unable to resolve remote name #498](https://github.com/massgravel/Microsoft-Activation-Scripts/issues/498)
