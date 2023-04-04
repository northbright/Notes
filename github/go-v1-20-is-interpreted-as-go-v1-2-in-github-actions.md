# Go v1.20 is Interpreted as Go v1.2 in Github Actions

## Problem
* Using Github Actions to Build and Test Go Project
* Specify using Go 1.20 in `.github/workflows/build.yml`

  ```
  go:
    - 1.17
    - 1.20
  ```
* Go v1.20 is Interpreted as Go v1.2 when Run Github Actions

## Root Cause
* YAML treats 1.20 as 1.2

## Solution
Add quotes for versions.

```
go:
  - "1.17"
  - "1.20"
```

## References
* [When go version 1.20 is specified, it is interpreted as 1.2 #361](https://github.com/actions/setup-go/issues/361)
* [get go v1.2 instead of v1.20 #355](https://github.com/actions/setup-go/issues/355)

