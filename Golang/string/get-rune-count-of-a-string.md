# Get Rune Count of a String

Use [RuneCount](https://godoc.org/unicode/utf8#RuneCount) to get the rune count of a string.

#### Example

```
package main

import (
        "fmt"
        "unicode/utf8"
)

func main() {
        s := "Hello, 世界"
        fmt.Printf("len(\"%v\"): %v\n", s, len(s))
        fmt.Printf("RuneCount(\"%v\"): %v\n", s, utf8.RuneCount([]byte(s)))
}

// Output:
//len("Hello, 世界"): 13
//RuneCount("Hello, 世界"): 9
```
