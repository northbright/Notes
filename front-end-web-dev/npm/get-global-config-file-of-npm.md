# Get Global Config File of npm

## Problem
* Need to know which file is the Global Config File of npm

## Solution
Run `npm config list | grep global` to find the global config file

```
npm config list | grep global

// Output:
; "global" config from /usr/local/etc/npmrc
```

## References
* [The npm config files](https://doc.codingdict.com/npm-ref/files/npmrc.html)
