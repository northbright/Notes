# Run sysdiagnose on iPhone

## Solution
#### Method A: Use Hardware Buttons
* Keep press "Volume -", "Volume +" and "Side / Top Button(power button)" for 1.5 second to start sysdiagnose
* You’ll feel a short vibration when sysdiagnose starts
* Go to Settings, tap Privacy & Security > Analytics & Improvements > Analytics Data
* If "stack-xx.ips" and stack-xx.000.ips" exist, it succeeded to start sysdiagnose
* Wait a while(5 minutes) to see "sysdiagnose-xx.tar.gz" generated

#### Method B: Use AssistiveTouch
* Go to Settings > Accessibility > Touch
* Turn on AssistiveTouch > Customize Top Level Menu
* Tap "+" > Select "Analytics"
* Tap AssistiveTouch tool > Analytics
* It'll show “AssistiveTouch Gathering analytics” message
* After a while(5 minutes), it'll show "Gathering analytics done" message

## Get sysdiagnose log file.
* Go to Settings, tap Privacy & Security > Analytics & Improvements > Analytics Data
* Select "sysdiagnose-xx.tar.gz" and send it to mac via AirDrop
* Extract the file

## References
* [Use diagnostics to research device issues](https://support.apple.com/zh-cn/guide/platform-support/supd3f43814e/web)
* [iOS耗电量测试——Sysdiagnose。](https://www.cnblogs.com/yzy1314/p/13230034.html)
