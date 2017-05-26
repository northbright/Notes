# Set Multiline Mode for Golang regexp Package

#### Using [Grouping Syntax](https://godoc.org/regexp/syntax) to Set Flags
    (?flags)       set flags within current group; non-capturing
    (?flags:re)    set flags during re; non-capturing

    Flag syntax is xyz (set) or -xyz (clear) or xy-z (set xy, clear z). The flags are:

    i              case-insensitive (default false)
    m              multi-line mode: ^ and $ match begin/end line in addition to begin/end text (default false)
    s              let . match \n (default false)
    U              ungreedy: swap meaning of x* and x*?, x+ and x+?, etc (default false)

#### Example
    package main

    import (
        "fmt"
        "regexp"
    )

    func main() {
        // multi-line mode:
        // ^ and $ match begin/end line in addition to begin/end text (default false)
        p := `(?m)^warning:.*too hot: (\d+)$`
        re := regexp.MustCompile(p)
        matched := re.FindAllStringSubmatch(str, -1)
        for _, m := range matched {
            fmt.Printf("%v\n", m[1])
        }
    }

    var str = `
    warning: CPU is too hot: 89
    error: CPU fan RPM is 0.
    warning: Memory usage: 80%
    warning: CPU is too hot: 97
    `

    // Output:
    89
    97

#### References
* [package syntax](https://godoc.org/regexp/syntax)
* [[go-nuts] How to enable "multi line mode" in go package "regexp"
](http://grokbase.com/t/gg/golang-nuts/1523qx73zm/go-nuts-how-to-enable-multi-line-mode-in-go-package-regexp)

