# PC with Gigabyte Dual-BIOS Mainboard Failed to Boot to Main BIOS

## Problem
* PC with Gigabyte B85 Dual-BIOS Mainboard
* Failed to Boot to Main BIOS
  1. Show Gigabyte Dual BIOS Title and Blank Screen for 2 - 3 Seconds
  2. Restart Automatically
  3. Repeat 1 - 2(Reboot) Again and Again

## Root Cause
* Main BIOS's Corrupted

## Solution
0. Power Off

1. Replace the CMOS Battery Firstly
   Dead battery may be the reason that main BIOS was corrupted.

2. Force Gigabyte Mainboard to Boot to Backup BIOS

Short PIN 1: `CS#`(Chip Select) and PIN 8: `VCC` on the M-BIOS(Main BIOS).

```
             VCC                        
            +---+  +---+  +---+  +---+  
            |   |  |   |  |   |  |   |  
+---------->| 8 |  | 7 |  | 6 |  | 5 |  
|           |   |  |   |  |   |  |   |  
|         +-+---+--+---+--+---+--+---+-+
|         |                            |
|         |                            |
|Short Out|                            |
|         |          M-BIOS            |
|         |                            |
|         |                            |
|         |                            |
|         +-+---+--+---+--+---+--+---+-+
|           |   |  |   |  |   |  |   |  
+-----------+ 1 |  | 2 |  | 3 |  | 4 |  
            |   |  |   |  |   |  |   |  
            +---+  +---+  +---+  +---+  
             CS#                        
                                        
              /\                        
             /__\                       
                                        
          PIN 1 Mark                    
```

You may use a paper clip to keep shorting PIN 1 and PIN 8 on M-BIOS.

3.  Power On the PC and Restore M-BIOS with B-BIOS(Backup BIOS)
* It'll show a menu to restore M-BIOS with B-BIOS

## References
* [电脑开机显示GIGABYTE-UEFI DualBIOS怎么办？](https://www.zhihu.com/question/48330250)
* [电脑开机显示GIGABYTE-UEFI DUaIBIOS解决](https://www.bilibili.com/read/cv22598111/)
* [技嘉主板进不去bios](https://zhidao.baidu.com/question/1869987118502412667.html)
* [[GUIDE] Forcing backup BIOS on Gigabyte motherboards.](https://www.overclockers.com/forums/threads/guide-forcing-backup-bios-on-gigabyte-motherboards.697533/)

----------------

# 技嘉 Dual BIOS 主板启动到主 BIOS 失败

## 问题
* Gigabyte B85 Dual-BIOS 主板
* 启动到主 BIOS 失败
  1. 显示 Gigabyte Dual BIOS 标题和空白画面 2 - 3 秒
  2. 然后自动重启
  3. 重复 1 - 2

## 原因
* 主 BIOS 损坏（掉 BIOS）

## 解决方法
0. 关机

1. 更换 CMOS 电池
   电池用尽可能是主 BIOS 损坏的原因之一。

2. 强制主板启动到备用 BIOS

短接 M-BIOS(主 BIOS)上的 PIN 1: `CS#`(Chip Select) 和 PIN 8: `VCC`。

```
             VCC                        
            +---+  +---+  +---+  +---+  
            |   |  |   |  |   |  |   |  
+---------->| 8 |  | 7 |  | 6 |  | 5 |  
|           |   |  |   |  |   |  |   |  
|         +-+---+--+---+--+---+--+---+-+
|         |                            |
|         |                            |
|Short Out|                            |
|         |          M-BIOS            |
|         |                            |
|         |                            |
|         |                            |
|         +-+---+--+---+--+---+--+---+-+
|           |   |  |   |  |   |  |   |  
+-----------+ 1 |  | 2 |  | 3 |  | 4 |  
            |   |  |   |  |   |  |   |  
            +---+  +---+  +---+  +---+  
             CS#                        
                                        
              /\                        
             /__\                       
                                        
          PIN 1 Mark                    
```

可以使用回形针来保持短接 M-BIOS 的 PIN 1 和 PIN 8。

3. 启动 PC 然后使用 B-BIOS（备份 BIOS）来恢复主 BIOS。
* 显示一个菜单来使用备份 BIOS 来恢复主 BIOS

## 参考资料
* [电脑开机显示GIGABYTE-UEFI DualBIOS怎么办？](https://www.zhihu.com/question/48330250)
* [电脑开机显示GIGABYTE-UEFI DUaIBIOS解决](https://www.bilibili.com/read/cv22598111/)
* [技嘉主板进不去bios](https://zhidao.baidu.com/question/1869987118502412667.html)
* [[GUIDE] Forcing backup BIOS on Gigabyte motherboards.](https://www.overclockers.com/forums/threads/guide-forcing-backup-bios-on-gigabyte-motherboards.697533/)
