# Delete Wechat Files to Free Disk Space of Parition C on Windows

## Problem
* There's a only little free disk space of partition C

## Root Cause
* Wechat（微信） used a lot of disk space

## Solution
Delete Wechat files.

* Go to `"C:\Users\XX\Documents\WeChat Files"`
* `"wxid_XX"` dir contains files for Wechat ID: XX
* Delete the `"wxid_XX"` dirs if XX is not your Wechat account
* Go to your Wechat account's dir: `"wxid_YOUR_ACCOUNT"`
  * Delete out-of-date videos:
    `"wxid_YOUR_ACCOUNT\FileStorage\Video"`
  * Delete out-of-date files:
    `"wxid_YOUR_ACCOUNT\FileStorage\File"`
  * Delete out-of-date images:
    `"wxid_YOUR_ACCOUNT\FileStorage\Image"`

