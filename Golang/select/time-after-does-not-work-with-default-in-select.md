# [time.After](https://godoc.org/time#After) Does Not Work with `default` in `select`

## Problem
* [time.After](https://godoc.org/time#After) does not work with `default` in `select`
* Example code:

      package main
  
      import (
              "fmt"
              "time"
      )

      func main() {
              for {
                      select {
                      case <-time.After(time.Second * 2):
                              fmt.Printf("Timeout\n")
                              return

                      default: // non-block select in for()
                      }

                      fmt.Printf("Hello World\n")
                      time.Sleep(time.Second * 1)
              }
      }

* The function will do the for loop forever and never print "Timeout"

## Root Cause
* [time.After](https://godoc.org/time#After) will create a **NEW** channel of Time after it's called* `default` will make for loop goto next iteration and call [time.After](https://godoc.org/time#After)

## Solution
* Create the channel of Time out of the for loop
* Example:

      package main
  
      import (
              "fmt"
              "time"
      )

      func main() {

              // Create the channel out of 
              ch := time.After(time.Second * 2)

              for {
                      select {
                      case <-ch:
                              fmt.Printf("Timeout\n")
                              return

                      default: // non-block select in for()
                      }

                      fmt.Printf("Hello World\n")
                      time.Sleep(time.Second * 1)
              }
      }

## References
* [How can I use 'time.After' and 'default' in Golang?](https://stackoverflow.com/questions/39212333/how-can-i-use-time-after-and-default-in-golang)
