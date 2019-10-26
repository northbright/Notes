# Get Return Values from Goroutines

## Problem
* Need to get return values from goroutines

## Solution
* Use channel

## [Example](https://wide.b3log.org/playground/291b5a3332e6c39007fd9e4aa5498ac8.go)
```
package main

import (
        "fmt"
)

func Worker(i int) error {
        fmt.Printf("Worker: %v started.\n", i)
        if i%2 == 0 {
                return nil
        }
        return fmt.Errorf("i: %v is not even", i)
}

func main() {
        n := 10
        concurrency := 5
        sem := make(chan struct{}, concurrency)
        // Use a buffered channel to store return values
        // Buffer size should be the same as loop times.
        chError := make(chan error, n)

        for i := 0; i < n; i++ {
                sem <- struct{}{}
                go func(i int) {
                        defer func() { <-sem }()
                        // Do some work
                        err := Worker(i)
                        // Send return value(error) to channel
                        chError <- err
                }(i)
        }

        // Wait all goroutines finish.
        for i := 0; i < cap(sem); i++ {
                sem <- struct{}{}
        }

        // Close the channel after all goroutines done.
        close(chError)

        // Check the return values.
        for e := range chError {
                fmt.Printf("e: %v\n", e)
        }

        // Output:
        //Worker: 1 started.
        //Worker: 4 started.
        //Worker: 2 started.
        //Worker: 3 started.
        //Worker: 7 started.
        //Worker: 9 started.
        //Worker: 8 started.
        //Worker: 6 started.
        //Worker: 0 started.
        //Worker: 5 started.
        //e: i: 1 is not even
        //e: <nil>
        //e: <nil>
        //e: i: 3 is not even
        //e: i: 7 is not even
        //e: i: 9 is not even
        //e: <nil>
        //e: <nil>
        //e: <nil>
        //e: i: 5 is not even
}
```

## References
* [Catching return values from goroutines](https://stackoverflow.com/questions/20945069/catching-return-values-from-goroutines)
* [Control Number of Concurrent Worker Goroutines](https://github.com/northbright/Notes/blob/master/Golang/concurrency/control-number-of-concurrent-worker-goroutines.md)
* [`for range` loop on a Channel will Never Exit until it is Closed](https://github.com/northbright/Notes/blob/master/Golang/concurrency/for-range-loop-on-a-channel-will-never-exit-until-it-is-closed.md)
