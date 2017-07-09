# UBNT UAP AC Lite will not Power on when Plug into TP-Link-SG1005P POE Switch

#### Problem
* New version of UBNT UAP AC Lite has a "802.3af Support" badge.
* We plugged it into TP-Link-SG1005P POE Switch and it worked well for 3 days.
* It could not power on after day 4 any more.

#### Root Cause
* Maybe UAP AC Lite(new version) does not support 802.3af very well.
* Passive 24V PoE is not an industry standard like 802.3at and 802.3af.


#### Solution
* Use adapter(24V 0.5A) in the box to use 24V passive POE.

#### References
* [Ubiquiti UniFi UAP-AC-Lite and UAP-AC-LR will not power up when plugged into PoE switch](https://gtacknowledge.extremenetworks.com/articles/Solution/Ubiquiti-UniFi-UAP-AC-Lite-and-UAP-AC-LR-will-not-power-up-when-plugged-into-PoE-switch)

-----------------------------

# UBNT UAP AC Lite插入TP-Link SG1005P POE交换机后不能供电

#### 问题
* 新版本的UBNT UAP AC Lite在包装盒上有支持802.3af的标签。
* 插入TP-Link SG1005P POE交换机后正常使用了3天。
* 第4天开始，再也不能给UAP AC Lite供电了，灯也不亮。

#### 原因
* 可能新版UAP AC Lite支持802.3af不是太好。
* 被动24V POE供电不是类似802.3at/802.3af那样的工业标准。

#### 解决方案
* 使用包装盒中自带的24V 0.5A的电源适配器就能正常上电了。

#### 参考资料
* [Ubiquiti UniFi UAP-AC-Lite and UAP-AC-LR will not power up when plugged into PoE switch](https://gtacknowledge.extremenetworks.com/articles/Solution/Ubiquiti-UniFi-UAP-AC-Lite-and-UAP-AC-LR-will-not-power-up-when-plugged-into-PoE-switch)
