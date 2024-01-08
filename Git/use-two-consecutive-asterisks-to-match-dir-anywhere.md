# Use Two Consecutive Asterisks to Match Dir Anywhere

## Problem
* Need to Ignore "output" and "cli/xx/output" dirs in `.gitignore`

## Solution
Use `**/output` to match `output` anywhere. It's the same as `output` pattern.

```
## Method 1: Use "**/output" to match output anywhere
**/output
```

```
## Method 2: Just use "output" to match output anywhere
output
```

## References
* [PATTERN FORMAT](https://git-scm.com/docs/gitignore#_pattern_format)
* [.gitignore文件的配置使用](https://zhuanlan.zhihu.com/p/52885189/)
