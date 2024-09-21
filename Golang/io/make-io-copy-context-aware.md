# Make io.Copy Context Aware

## Problem
* [io.Copy](https://pkg.go.dev/io#Copy) does not have a [context.Context](https://pkg.go.dev/context#Context) parameter
* Need to cancel copy

## Solution
Implement **inline** [io.Reader](https://pkg.go.dev/io#Reader) interface.

```go
package main

import (
	"context"
	"fmt"
	"io"
	"net/http"
	"os"
	"strings"
	"time"
)

type readerFunc func(p []byte) (n int, err error)

func (rf readerFunc) Read(p []byte) (n int, err error) {
	return rf(p)
}

func ctxCopy(ctx context.Context, dst io.Writer, src io.Reader) (written int64, err error) {
	n, err := io.Copy(
		dst,
		// Inline Reader interface.
		// Reader's Read() will be called multiple times during the IO copy.
		readerFunc(func(p []byte) (int, error) {
			select {
			case <-ctx.Done():
				return 0, ctx.Err()
			default:
				return src.Read(p)
			}
		}),
	)
	return n, err
}

func main() {
	ctx := context.Background()

	n, err := ctxCopy(ctx, os.Stdout, strings.NewReader("Hello World!"))
	if err != nil {
		fmt.Printf("\nctxCopy() error: %v\n", err)
		return
	}
	fmt.Printf("\nctxCopy OK. %v bytes copied.\n", n)

	// Download a file and show the content to os.Stdout.
	downloadURL := "https://golang.google.cn/dl/go1.23.1.darwin-amd64.pkg"

	resp, err := http.Get(downloadURL)
	if err != nil {
		fmt.Printf("http.Get() error: %v\n", err)
		return
	}
	defer resp.Body.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 200*time.Millisecond)
	defer cancel()

	n, err = ctxCopy(ctx, os.Stdout, resp.Body)
	if err != nil {
		fmt.Printf("\nctxCopy() error: %v\n", err)
		return
	}
	fmt.Printf("\nctxCopy OK. %v bytes copied.\n", n)
}
```

## References
* [CANCEL COPY OF HUGE FILE IN GO](https://ixday.github.io/post/golang-cancel-copy/)
* <https://www.youtube.com/watch?v=xyDkyFjzFVc>
