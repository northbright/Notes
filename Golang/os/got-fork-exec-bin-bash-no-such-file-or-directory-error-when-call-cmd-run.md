# Got "fork/exec /bin/bash: no such file or directory" error when call Cmd.Run 

## Problem
`go run main.go` with folling code and got "fork/exec /bin/bash: no such file or directory" error.

```go
package main

import (
	"context"
	"fmt"
	"os"
	"os/exec"
	"syscall"
	"time"
)

func main() {
	//ctx, cancel := signal.NotifyContext(context.Background(), os.Interrupt)
	ctx, cancel := context.WithTimeout(context.Background(), 2*time.Second)
	defer cancel()

	cmd := exec.CommandContext(ctx, "bash", "-c", "date && ping bing.com")
	// To stop the process and its subprocesses,
	// request that the process group id be set (Setpgid: true) to the PID of the newly spawned process (Pgid: 0).
	cmd.SysProcAttr = &syscall.SysProcAttr{
		Setpgid: true,
	}

	cmd.Dir = "./examples"
	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr
	cmd.Cancel = func() error {
		// Kill all processes in the group via `kill -9 -$PGID`.
		// Note the "-" to signal the group.
		return syscall.Kill(-cmd.Process.Pid, syscall.SIGKILL)
	}

	go func() {
		select {
		case <-ctx.Done():
			fmt.Printf("ctx is done\n")
			return
		}
	}()

	if err := cmd.Run(); err != nil {
		fmt.Printf("cmd.Run() error: %v\n", err)
		return
	}

	// Output:
}
```

## Root Cause
* cmd.SysProcAttr is set("Setpgid: true")
* cmd.Dir doe NOT exists

## Solution
Make sure cmd.Dir exists.
