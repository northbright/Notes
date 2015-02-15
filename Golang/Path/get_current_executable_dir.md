
# Get Current Executable Directory in golang

<pre><code>
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
</code></pre>

<https://github.com/northbright/goutil/blob/master/path.go>