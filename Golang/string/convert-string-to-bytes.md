# Convert String to Bytes

## Solution
Just use direct converstion.

```go
package main

import "fmt"

func main() {
	s := "Hello, Wolrd! 123456"
	b := []byte(s)
	fmt.Printf("b: %v", b)

    // Output:
    // b: [72 101 108 108 111 44 32 87 111 108 114 100 33 32 49 50 51 52 53 54]
}
```

## References
* [golang utf-8 string to bytes](https://cn.bing.com/search?q=golang+utf-8+string+to+bytes&form=QBLHCN&sp=-1&lq=0&pq=golang+utf-8+string+to+bytes&sc=12-28&qs=n&sk=&cvid=48B4F783F8334926B4386D967CC86A4F)
