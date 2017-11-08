# Control Number of Concurrent Worker Goroutines

#### Pattern
Use a channel of empty structs to control the number of concurrent worker goroutines.

#### Example

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

#### References
* [Limiting Concurrency in Go](http://jmoiron.net/blog/limiting-concurrency-in-go/)
* [Go: Always have x number of goroutines running at any time(see artyom's answer)](https://stackoverflow.com/questions/25306073/go-always-have-x-number-of-goroutines-running-at-any-time)

