# Counting Numbers in Goroutines

#### Problem
* Need to count the success / failure number in concurrent goroutines.

#### Solution
* Use [AddUint64](https://godoc.org/sync/atomic#AddUint64), [LoadUint64](https://godoc.org/sync/atomic#LoadUint64) provided by [sync/atomic] package.

#### Example

```
package main

import (
	"fmt"
	"sync/atomic"
)

func main() {
	var (
		total   uint64
		success uint64
		failure uint64
	)

	concurrency := 10
	sem := make(chan struct{}, concurrency)

	for i := 0; i < 100; i++ {
		sem <- struct{}{}

		go func(i int) {
			defer func() { <-sem }()

			atomic.AddUint64(&total, 1)

			fmt.Printf("i: %v\n", i)
			if i%2 == 0 {
				atomic.AddUint64(&success, 1)
			} else {
				atomic.AddUint64(&failure, 1)
			}
		}(i)
	}

	for j := 0; j < cap(sem); j++ {
		sem <- struct{}{}
		fmt.Printf("----- j: %v\n", j)
	}

	total = atomic.LoadUint64(&total)
	success = atomic.LoadUint64(&success)
	failure = atomic.LoadUint64(&failure)
	fmt.Printf("total: %v, success: %v, failure: %v\n", total, success, failure)

        // Output:
        // total: 100, success: 50, failure: 50
}
```

[Playground](https://wide.b3log.org/playground/c1b1b80abc8c202bb56854f18e38685a.go)

#### References
* [Go by Example: Stateful Goroutines](https://gobyexample.com/stateful-goroutines)
