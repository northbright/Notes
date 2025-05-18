# Can not Change Entries in `range` Loop

## Problem
* Update item in `for _, item := range items` loop and take no effect

## Root Cause
* `item` is just a local variable copy from items

## Solution
Use `items[i] = xx` to update the slice / map.

## Example
```go
package main

import "fmt"

func main() {
	items := []int{1, 2, 3}

	for _, item := range items {
		// item is just a local variable copy
		// Update item won't affect items slice.
		item += 1
	}

	fmt.Printf("%v\n", items)
	// Output:
	// [1 2 3]

	for i := range items {
		// This will work.
		items[i] += 1
	}

	fmt.Printf("%v\n", items)
	// Output:
	// [2 3 4]
}
```

## References
* [Can’t change entries in range loop](https://yourbasic.org/golang/gotcha-change-value-range/)
* [Go Wiki: Range Clauses](https://go.dev/wiki/Range)
