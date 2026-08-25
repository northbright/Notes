# Control Number of Concurrent Worker Goroutines

## Update(2026/08/25)
* See [四、并发：用 channel 编排，而不是用 mutex 加锁](https://tonybai.com/2026/07/13/spf13-idiomatic-go/#%E5%9B%9B%E5%B9%B6%E5%8F%91%E7%94%A8-channel-%E7%BC%96%E6%8E%92%E8%80%8C%E4%B8%8D%E6%98%AF%E7%94%A8-mutex-%E5%8A%A0%E9%94%81)

## Pattern
Use a channel of empty structs to control the number of concurrent worker goroutines.

## Example

<https://wide.b3log.org/playground/7ca38a580cda9f3b3926da1e6b8a1e96.go>:

    package main

    import (
        "fmt"
    )

    func main() {
        concurrency := 10
        sem := make(chan struct{}, concurrency)

        for i := 0; i < 100; i++ {
                // After first "concurrency" amount of goroutines started,
                // It'll block starting new goroutines until one running goroutine finishs.
                sem <- struct{}{}

                go func(i int) {
                        defer func() { <-sem }()
                        // Do some work
                        fmt.Printf("i: %v\n", i)
                }(i)
        }

        // After last goroutine is started, 
        // there're still "concurrency" amount of goroutines running.
        // Make sure wait all goroutines to finish.
        for j := 0; j < cap(sem); j++ {
                sem <- struct{}{}
                fmt.Printf("----- j: %v\n", j)
        }
    }

## References
* [Limiting Concurrency in Go](http://jmoiron.net/blog/limiting-concurrency-in-go/)
* [Go: Always have x number of goroutines running at any time(see artyom's answer)](https://stackoverflow.com/questions/25306073/go-always-have-x-number-of-goroutines-running-at-any-time)
* [四、并发：用 channel 编排，而不是用 mutex 加锁](https://tonybai.com/2026/07/13/spf13-idiomatic-go/#%E5%9B%9B%E5%B9%B6%E5%8F%91%E7%94%A8-channel-%E7%BC%96%E6%8E%92%E8%80%8C%E4%B8%8D%E6%98%AF%E7%94%A8-mutex-%E5%8A%A0%E9%94%81)
