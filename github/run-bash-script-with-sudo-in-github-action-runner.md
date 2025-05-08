# Run Bash Script with `sudo` in Github Action Runner

## Problem
* Need to run test bash script in Github Action Runner

## Solution
Use `RUNNER_ALLOW_RUNASROOT` environment variable.

```yml
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
        - ubuntu-latest

      fail-fast: false
    steps:
    - name: Checkout source codes
      uses: actions/checkout@v4

    - name: Test
      run: sudo RUNNER_ALLOW_RUNASROOT=true ./test.sh
```

## References
* [Config.sh and Run.sh return "Must not run with sudo" #52343](https://github.com/orgs/community/discussions/52343)
