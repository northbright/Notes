# Use switch with Multiple Values in Each case

There is no automatic fall through, but cases can be presented in comma-separated lists.

    func shouldEscape(c byte) bool {
        switch c {
        case ' ', '?', '&', '=', '#', '+', '%':
            return true
        }
        return false
    }

#### Example 2
    package main

    import "fmt"

    func f(i int) {
        switch i {
        case 0, 2, 4:
            fmt.Printf("%v is even.\n", i)
        case 1, 3, 5:
            fmt.Printf("%v is odd.\n", i)
        default:
            fmt.Printf("%v is not in [0 - 5]\n", i)
        }
    }

    func main() {
        arr := []int{0, 1, 2, 3, 4, 5, -1, 6}
        for _, v := range arr {
            f(v)
        }
    }

#### References
* <https://golang.org/doc/effective_go.html#switch>
* <http://www.dotnetperls.com/switch-go>
* [switch](https://github.com/golang/go/wiki/Switch#multiple-cases)
