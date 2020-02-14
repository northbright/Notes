# defer Functions are Executed in Last In First Out Order

## Example
```
package main

import "fmt"

func f() {
	defer fmt.Println("defer A")
	defer fmt.Println("defer B")
	defer func() {
		fmt.Println("defer C")
	}()


	fmt.Print("f() started\n")
}

func main() {
	f()

	// Output:
	//f() started
	//defer C
	//defer B
	//defer A
}
```

## References
* [Golang defer behavior](https://stackoverflow.com/questions/24720097/golang-defer-behavior)
