# Embed a File into a String

## Problem
* A Go Test File(`xx_test.go`)
* Need to Show the All Content of `xx_test.go` Itself as the Usage

## Solution
Use `embed` package to embed the `xx_test.go` file into a string.

```
package xx_test

import (
    "log"
    _  "embed"
)

//go:embed xx_test.go
var exampleCode string

func Example() {

    ......

    log.Printf("example: %v", exampleCode)

    // Output:
}
```
