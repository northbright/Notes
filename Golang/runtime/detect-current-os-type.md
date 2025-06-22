# Detect Current OS Type

## Problem
* Need to detect current OS type in Go

## Solution
Use [runtime.GOOS](https://pkg.go.dev/runtime#pkg-constants).

## Example
```bash
func GenCommand(cmdStr string) (*exec.Cmd, error) {
    switch runtime.GOOS {
    case "darwin":
        return exec.Command("zsh", "-c", cmdStr), nil
    case "linux":
        return exec.Command("bash", "-c", cmdStr), nil
    default:
        return nil, fmt.Errorf("not supported OS")
    }
}
```

## References
* [How to detect the current operating system in GO](https://www.slingacademy.com/article/how-to-detect-the-current-operating-system-in-go/)
