# Cast `int` to `time.Duration`

## Problem

Multiply time.Duration by an integer will cause build error.

    package main

    import (
        "fmt"
        "time"
    )

    func main() {
        var timeout int = 10
        // Compiler will say: "mismatched types int and time.Duration"
        fmt.Printf("timeout: %v\n", timeout * time.Second)
    }
    
## Solution

Cast `int` to `time.Duration`

    package main

    import (
        "fmt"
        "time"
    )

    func main() {
        var timeout int = 10
        // OK. Output: 10s
        fmt.Printf("timeout: %v\n", time.Duration(timeout) * time.Second)
    }

* <http://play.golang.org/p/iGfnB6JgFG>

## References

* [How multiply time.Duration by an integer?](https://groups.google.com/forum/#!topic/golang-nuts/HWNfZgC8938)