# Check if Command Exists in Go

## Solution
* Use [exec.LookPath](https://pkg.go.dev/os/exec#LookPath)

## [Example](https://pkg.go.dev/os/exec#example-LookPath)
```
package main

import (
	"log"
	"os/exec"
)

func main() {
	path, err := exec.LookPath("ls")
	if err != nil {
		log.Fatal(err)
	}
	
	log.Println(path) // bin/ls
}

// as util
func commandExists(cmd string) bool {
	_, err := exec.LookPath(cmd)
	return err == nil
}
```

## References
* [miguelmota/command_exists.go](https://gist.github.com/miguelmota/ed4ec562b8cd1781e7b20151b37de8a0)
