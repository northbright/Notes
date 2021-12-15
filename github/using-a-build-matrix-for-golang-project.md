# Using a Build Matrix for Golang Project

## Problem
* Want to run test across multiple combinations of operating systems, Golang versions

## Solution
Add os, go matrix of strategy:

```
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
```

## Example
* `.github/workflows/build.yml`

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
      run: go build -v ./...

    - name: Test
      run: go test -v ./...
```

## References
* [Using a build matrix](https://docs.github.com/en/actions/learn-github-actions/managing-complex-workflows#using-a-build-matrix)
