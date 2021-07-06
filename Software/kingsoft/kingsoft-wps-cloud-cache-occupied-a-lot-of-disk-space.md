# Kingsoft WPS Cloud Cache Occupied a Lot of Disk Space

## Problem
* It reported that free disk space of partition C is only 4 GB(Partition C has 100 GB)

## Root Cause
* Kingsoft WPS Cloud cached files occupied about 34 GB disk space

## Solution
Delete Kingsoft WPS Cloud cache

```
// Delete Kingsoft folder under AppData
C:\Users\my\AppData\Local\Kingsoft
```

-----------------

# 金山 WPS Cloud 缓存占用了大量磁盘空间

## 问题
* 有用户报告 C 盘只有 4 GB 可用空间（ C 盘为 100 GB）

## 原因
* 金山 WPS Cloud 占用了约 34 GB 的磁盘空间

## 解决方法
删除金山 WPS Cloud 的缓存

```
// 删除 AppData 下的 Kingsoft 文件夹
C:\Users\my\AppData\Local\Kingsoft
```
