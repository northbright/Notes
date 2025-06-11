# Get Integer and Fractional Part of a Float

## Solution
Use [Modf](https://pkg.go.dev/math#Modf).

## Example
```go
package main

import (
	"fmt"
	"math"
)

func main() {
	int, frac := math.Modf(3.14)
	fmt.Printf("%.2f, %.2f\n", int, frac)

	int, frac = math.Modf(-2.71)
	fmt.Printf("%.2f, %.2f\n", int, frac)
}

// Output:
// 3.00, 0.14
/// -2.00, -0.71
```

## References
* [Modf](https://pkg.go.dev/math#Modf)
* [Go – How to get integer and fractional part of floating-point numbers in go](https://techieindoor.com/go-how-to-get-integer-and-fractional-part-of-floating-point-numbers-in-go/)
