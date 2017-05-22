# Non Capturing Groups

#### Syntax
* `(?:regex)`
    
    Use `?:` in `()` for a Non-Capturing Group.

#### Example Written in [Golang](https://golang.org)

    package main

    import (
        "fmt"
        "regexp"
    )

    func main() {
        strs := []string{
            `aaa_c=2`,
            `bbb_c=1`,
        }

        p := `(?:a|b){3}_c=(\d)`

        for _, v := range strs {
            re := regexp.MustCompile(p)
            matched := re.FindStringSubmatch(v)

            for i, m := range matched {
                fmt.Printf("%v: %v\n", i, m)
            }
        }
        
        // Output:
        0: aaa_c=2
        1: 2
        0: bbb_c=1
        1: 1
    }

#### References
* [Regular Expression Reference: Capturing Groups and Backreferences](http://www.regular-expressions.info/refcapture.html)


