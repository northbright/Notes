# Upgrade setuptools on macOS

## Problem
* Run `python3 -m pip install .` to build [afdko/](https://github.com/adobe-type-tools/afdko/) on macOS
* Got error: `require(setuptools >= xx) conflict`

## Root Cause
`setuptools` is too old.

## Solution
Upgrade `setuptools`

```shell
python3 -m pip install --upgrade pip
python3 -m pip install --upgrade setuptools
```
