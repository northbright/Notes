# Exit Go Program Gracefully when SIGINT is Received

## Example
* Use signal.NotifyContext() to create a context which is done when SIGINT received.
* Use a select statement to do the work on default and exit the program when context is done.

```go
package main

import (
	"context"
	"fmt"
	"os"
	"os/signal"
	"runtime"
	"time"
)

func main() {
	ctx, cancel := signal.NotifyContext(context.Background(), os.Interrupt)
	defer cancel()

	for {
		select {
		case <-ctx.Done():
			fmt.Println("context is done")
			return
		default:
			fmt.Printf("%s\n", time.Now().String())
			runtime.Gosched()
		}
	}
}
```
