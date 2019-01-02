# Use `select` with `default` to Write Context Aware Function

## Problem
* Our function needs a lot of work to do and take a long time
* So we decide to make function [context](https://godoc.org/context) aware
   * Timeout
   * Cancelation
   * Deadline

## Solution
* Use `select` statment with `default` case
  * The `select` statement blocks until one of the send/receive operation is ready
  * The `default` case in a `select` statement is executed when none of the other case is ready. This is generally used to prevent the select statement from blocking

## Example
```
package main

import (
	"context"
	"fmt"
	"time"
)

func PrintString(ctx context.Context) error {
	i := 0
	for {
		select {
		case <-ctx.Done():
			fmt.Printf("%v\n", ctx.Err())
			return ctx.Err()
		default:  // non-block select in for()
		}
                
		fmt.Printf("Hello World: %v\n", i)
		time.Sleep(time.Second * 1)
		i++
	}

	return nil
}

func main() {
	ctx1, cancel1 := context.WithTimeout(context.Background(), time.Second*10)
	defer cancel1()
	// Test deadline exceeded
	PrintString(ctx1)

	// Test cancelation
	ctx2, cancel2 := context.WithTimeout(context.Background(), time.Second*10)
	defer cancel2()
	go PrintString(ctx2)
	select {
	case <-time.After(time.Second * 5):
		fmt.Println("5 seconds passed and do cancelation")
		cancel2()
		// Use Sleep() to block the code,
		// to give it a chance for the goroutine running PrintString() to show
		// ctx.Err() before main() return
		time.Sleep(time.Second * 1)
	}
        // Output:
        // Hello World: 0
        // Hello World: 1
        // Hello World: 2
        // Hello World: 3
        // Hello World: 4
        // Hello World: 5
        // Hello World: 6
        // Hello World: 7
        // Hello World: 8
        // Hello World: 9
        // context deadline exceeded
        // Hello World: 0
        // Hello World: 1
        // Hello World: 2
        // Hello World: 3
        // Hello World: 4
        // 5 seconds passed and do cancelation
        // context canceled
}
```
* [Golang Playground](https://wide.b3log.org/playground/531e645c706204aa1fd7606010f57f9e.go)
