# `go build` with Wildcard(`...`) Does Not Generate Executable

## Problem
* [A golang repo](https://github.com/northbright/cobra-viper-demo) hosted on Github

  * Source Dir Structure
  
    ```
    main.go
    cmd/root.go
    cmd/goodbye.go
    cmd/goodnight.go
    cmd/hi.go
    ```
  * `main.go` contains the package `main`
  * `cmd/*.go` contain the package `cmd` which imported by `main` package
  * The executable(demo) is a CLI to run root command, sub commands

    ```
    // Root Command
    demo
    // Sub Commands
    demo goodbye Frank
    demo goodnight Frank
    ```

* Use Github Action to Build / Test

[.github/workflows/build.yml](https://github.com/northbright/cobra-viper-demo/actions/runs/1919804188/workflow):

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

    - name: Run Root Command
      run: ./demo

    - name: Run goodbye Sub Command
      run: ./demo goodbye Frank

    - name: Run goodnight Sub Command Without Flags
      run: ./demo goodnight Frank

    - name: Run goodnight Sub Command With Flags
      run: ./demo goodnight Frank --moon --sleepingface

    - name: Run hi Sub Command Without Flags
      run: ./demo hi Frank

    - name: Run hi Sub Command With Flags
      run: ./demo hi Frank --emoji 😼
```

* `Run Root Command for Test` and `Run goodbye Sub Command for Test` failed

   With Error: > ./demo: No such file or directory

## Root Cause
* `go build -v ./...` just check all packages under ./ can be build but does not generate executable
* `go help build`:

   > When compiling a single main package, build writes
     the resulting executable to an output file named after
     the first source file ('go build ed.go rx.go' writes 'ed' or 'ed.exe')
     or the source code directory ('go build unix/sam' writes 'sam' or 'sam.exe').
     The '.exe' suffix is added when writing a Windows executable.

   > When compiling multiple packages or a single non-main package,
     build compiles the packages but discards the resulting object,
     serving only as a check that the packages can be built.
 
* `./...` wildcard make go build to compile all packages under `./`(`/cmd/xx.go` in this case)
  
  Then `go build` check all packages can be built but does not output executable(`demo` in this case)

## Solution
* Method A: Use `go build -v` instead
* Method B: Use `go run main.go`, `go run main.go SUBCOMMAND [ARGS] [FLAGS]` instead

  e.g. `go run main hi Frank --emoji 😼`
 
## References
* [What does go build build? (go build vs. go install)](https://stackoverflow.com/questions/30612611/what-does-go-build-build-go-build-vs-go-install)
* ["go build" does not generate file in golang](https://stackoverflow.com/questions/31144153/go-build-does-not-generate-file-in-golang)
* [Package lists and patterns](https://pkg.go.dev/cmd/go#hdr-Package_lists_and_patterns)
