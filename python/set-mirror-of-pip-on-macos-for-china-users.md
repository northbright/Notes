# Set Mirror of pip on macOS for China Users

## Problem
* `pip` runs very slow in China

## Solution
Set mirror for `pip`

```shell
// Use tsinghua mirror
pip3 config set global.index-url https://pypi.tuna.tsinghua.edu.cn/simple
```

```shell
// check mirror config
pip3 config list

// output:
global.index-url='https://pypi.tuna.tsinghua.edu.cn/simple'
```

## References
* [Python中pip修改国内镜像源（11个源）](https://www.cnblogs.com/yuerhoo/p/18682885)
