# `os/exec` Will Not Expand Variables when Run Shell Command

## Problem
```go
package main

import (
    "fmt"
    "os/exec"
)

func main() {
    str := "v=value; echo $v"

    cmd := exec.Command("bash", "-c", str)
    fmt.Printf("cmd.String(): %s\n", cmd.String())
    buf, _ := cmd.CombinedOutput()
    fmt.Printf("output: %s\n", buf)
}
```

Output:
```bash
cmd.String(): /bin/bash -c v=value; echo $v
output: value
```

* Output is `value` when run `go run main.go`
* But when run script: `/bin/bash -c v=value; echo $v` in shell, it ouput nothing.

## Root Cause
`os/exec` will not expand variables.

> Unlike the "system" library call from C and other languages, the os/exec package intentionally does not invoke the system shell and does not expand any glob patterns or handle other expansions, pipelines, or redirections typically done by shells.

## References
* [bash -c "v=value; echo $v" displays nothing](https://askubuntu.com/questions/786816/bash-c-v-value-echo-v-displays-nothing)
