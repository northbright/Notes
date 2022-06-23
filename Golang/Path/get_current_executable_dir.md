# Get Current Executable Directory in golang

## os.Getwd() will NOT return current executable dir.
* Getwd returns a rooted path name corresponding to the current directory(See <https://godoc.org/os#Getwd>).
* It's similar to `pwd` command.
* Example Code

        package main

        import (
                "fmt"
                "os"
        )

        func main() {
                dir, _ := os.Getwd()
                fmt.Printf("os.Getwd(): %v\n", dir)
        }

* Test

    * Run the program under project dir
        * `cd /home/xx/projects-go/src/github.com/northbright/getwd-test`
        * `./getwd-test`
        * the result is: `os.Getwd(): /home/xx/projects-go/src/github.com/northbright/getwd-test`

    *  Run the program under user home
        * `cd /home/xx`
        * `./projects-go/src/github.com/northbright/getwd-test/getwd-test`
        * the result is: `os.Getwd(): /home/xx`

## Solution

    import (
        "fmt"
        "os"
        "os/exec"
        "path/filepath"
    )

    func GetCurrentExecDir() (dir string, err error) {
        path, err := exec.LookPath(os.Args[0])
        if err != nil {
            fmt.Printf("exec.LookPath(%s), err: %s\n", os.Args[0], err)
            return "", err
        }

        absPath, err := filepath.Abs(path)
        if err != nil {
            fmt.Printf("filepath.Abs(%s), err: %s\n", path, err)
            return "", err
        }

        dir = filepath.Dir(absPath)

        return dir, nil
    }

## References
* [pathhelper](https://github.com/northbright/pathhelper)
