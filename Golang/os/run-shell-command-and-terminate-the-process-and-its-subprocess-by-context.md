# Run Shell Command and Terminate the Process and Subprocesses by Context

## Problem
* Run a shell command in golang

  ```go
  cmd := exec.CommandContext(ctx, "bash", "-c", "ping bing.com")
  ```

* It'll create a process for "bash" and a subprocess for "ping".
* [cmd.Cancel](https://pkg.go.dev/os/exec#Cmd) will be called when context is done.
* By default(`cmd.Cancel == nil`), CommandContext sets Cancel to call the Kill method on the command's Process only("bash"). It means that the subprocess("ping") will NOT be killed.

## Solution
* Request that the process group id be set (Setpgid: true) to the PID for the command

  ```go
  cmd.SysProcAttr = &syscall.SysProcAttr{
      Setpgid: true,
  }
  ```

* Customize the cancel function to kill all processes in the group

  ```go
  cmd.Cancel = func() error {
      // Kill all processes in the group via `kill -9 -$PGID`.
      // Note the "-" to signal the group.
      return syscall.Kill(-cmd.Process.Pid, syscall.SIGKILL)
  }
  ```

## Example

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

	cmd := exec.CommandContext(ctx, "bash", "-c", "ping bing.com")

	// To stop the process and its subprocesses,
	// request that the process group id be set (Setpgid: true) to the PID of the newly spawned process (Pgid: 0).
	cmd.SysProcAttr = &syscall.SysProcAttr{
		Setpgid: true,
	}

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
    // ...
    // ctx is done
    // cmd.Run() error: signal: killed
}
``` 

## References
* [Killing a process and all of its descendants in Go](https://sigmoid.at/post/2023/08/kill_process_descendants_golang/)
* [Go exec.CommandContext is not being terminated after context timeout](https://stackoverflow.com/questions/71714228/go-exec-commandcontext-is-not-being-terminated-after-context-timeout)
* [exec#Cmd](https://pkg.go.dev/os/exec#Cmd)
* [Go exec 包执行命令超时失效问题分析及解决方案](https://www.lixueduan.com/posts/go/exex-cmd-timeout/)
  * [Go exec 包执行命令超时失效问题分析及解决方案](https://blog.csdn.net/java_1996/article/details/125692827)
* [Everything You Need To Know About Managing Go Processes](https://hackernoon.com/everything-you-need-to-know-about-managing-go-processes)
  * [golang-cmd-exit-demo](https://github.com/gouravkrosx/golang-cmd-exit-demo)
