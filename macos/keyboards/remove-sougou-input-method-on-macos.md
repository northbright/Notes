# Remove Sougou Input on macOS

## Steps
* Switch to another input method(e.g. built-in `简体拼音`)
* Terminate Sougou Input Method Service process
  * Open "Activity Monitor"(活动监视器)
  * Click "Process Name" to sort processes by name
  * Select Sougou Input Method(搜狗输入法)
  * Click "X" button > "Force Quit"（强制退出）
* Remove Sougou Input Method files
  * Open a Terminal window
  * Run the following commands:
 
    ```sh
    sudo rm -rf ~/Library/Input\ Methods/SogouInput.app
    sudo rm -rf ~/Library/Caches/SogouServices
    sudo rm -rf ~/Library/Caches/com.sogou.installType
    sudo rm -rf ~/Library/Caches/com.sogou.SGSkinManager
    sudo rm -rf ~/Library/Caches/com.sogou.SogouHelper
    sudo rm -rf ~/.sogouinput
    ```

## References
* [macOS 完全卸载搜狗输入法和 Rime 输入法的方法](https://linux.do/t/topic/392950)
* [一分钟完成，Mac OS系统删除第三方（搜狗/百度/科大讯飞/微信）输入法最新教程 Sequoia 15（2025.08.25）](https://zhuanlan.zhihu.com/p/1943364739674665662)
* [Mac彻底卸载搜狗输入法，看这一篇就够了](https://blog.csdn.net/m0_46696320/article/details/105842563)
* [详细步骤：如何在 macOS 上手动卸载第三方输入法](https://www.sysgeek.cn/macos-uninstall-third-party-input-method/)
