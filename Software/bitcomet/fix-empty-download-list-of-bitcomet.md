# Fix Empty Download List of Bitcomet

## Problem
* Bitcomet exited abnormally
* Got empty download list when run Bitcomet next time

## Solution
* Close Bitcomet
* Go to `Users/xx/AppData/Roaming/Bitcomet/`
* Delete `Download.xml`
* Rename `Download.xml.xx.bak` to `Download.xml`
* Run Bitcomet and it's OK

## References
* [比特彗星常见问题-意外退出程序后下载列表清空的解决方法](https://www.bilibili.com/read/cv31256529/)
