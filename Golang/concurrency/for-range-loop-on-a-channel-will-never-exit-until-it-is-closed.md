# `for range` loop on a Channel will Never Exit until it is Closed

## Problem
Following [example code](https://wide.b3log.org/playground/8ebdd8ef8b5915559e07b712cc791ed4.go) got a deadlock error:

> fatal error: all goroutines are asleep - deadlock!

```
package main

import "fmt"

func main() {
	ch := make(chan int, 1)

	for i := 0; i < 10; i++ {
		go Send(ch, i)
	}

	for i := range ch {
		fmt.Printf("i: %v\n", i)
	}
}

func Send(ch chan int, number int) {
	ch <- number
}
```

## Root Cause
* `for range` expression can be used to receive values from a channel until it is **closed**
* In other word, `for range` loop on channel will **NEVER** exit until the channel is closed, and **BLOCK** its goroutine

## How to Fix
Close the channel after use

[Updated example code](https://wide.b3log.org/playground/f9b2d71be6076aaea24eee0614f67fa2.go):

```
package main

import "fmt"

func main() {
	ch := make(chan int, 1)
	go Send(ch)

	for i := range ch {
		fmt.Printf("i: %v\n", i)
	}
}

func Send(ch chan int) {
	for i := 0; i < 10; i++ {
		ch <- i
	}
	// Close the channel after use to make for-range loop exit
	close(ch)
}
```

## References
* [throw: all goroutines are asleep - deadlock](https://stackoverflow.com/questions/12398359/throw-all-goroutines-are-asleep-deadlock)
* [Part 22: Channels](https://golangbot.com/channels/)
* [Golang channels tutorial](http://guzalexander.com/2013/12/06/golang-channels-tutorial.html)
