# It displays Chinese Characters Incorrectly on CentOS

## Background
* Clean installed CentOS 8
* Set timezone to `Asia/Shanghai`

## Problem
* It displays Chinese characters incorrectly in `vim`, `git`...
* It reports errors when run `locale` command:
   > locale: Cannot set LC_CTYPE to default locale: No such file or directory
locale: Cannot set LC_MESSAGES to default locale: No such file or directory
locale: Cannot set LC_ALL to default locale: No such file or directory

## Root Cause
The package: `langpacks-zh_CN.noarch` is not installed

## Solution
Install `langpacks-zh_CN.noarch` package using `yum`

```
// You may search Chinese related langpacks
yum search Chinese

sudo yum install langpacks-zh_CN.noarch
```

