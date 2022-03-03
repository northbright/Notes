# Write String to File via `echo` as Github Actions Run Command in YAML

## Problem
* Use Github Action to write a string to config file

`.github/workflows/build.yml`:


```
name: Build

on:
- push

jobs:
  build:
    name: Build
    runs-on: ${{ matrix.os }}
    strategy:
      matrix:
        os:
        - Windows-2019
        - macOS-10.15
        - Ubuntu-18.04
        - Ubuntu-20.04
        go:
        - 1.16
        - 1.17

      fail-fast: false
    steps:
    - name: Checkout source codes
      uses: actions/checkout@v2

    - name: Set up Go
      uses: actions/setup-go@v2
      with:
        go-version: ${{ matrix.go }}

    - name: Build
      run: go build -v

    - name: Create Config File and Check
      run: echo name: Frank > $HOME/.demo.yaml && cat $HOME/.demo.yaml
```

* Report YAML syntax error at `run: echo name: Frank > $HOME/.demo.yaml && cat $HOME/.demo.yaml`

## Root Cause
* `>` is syntax char should be quoted

## Solution
* Use '' or "" for the command string

```
run: "echo name: Frank > $HOME/.demo.yaml && cat $HOME/.demo.yaml"
```
