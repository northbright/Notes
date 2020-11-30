# Initialize Golang Array with Specified Value and Index

* Golang array are fixed size.
* Use `[...]array_type` to let compiler to compute the length of the array
* We can specify the `index: element` in `[...]array_type`
* [Example](https://wide.b3log.org/playground/4e266926a64e1bfeadfcb697c5daf04e.go)

```
package main

import "fmt"

func main() {
        // Create a array(len = 4)
        // Specify 2nd and 4th elements' values.
	s := [...]string{
		1: "a",
		3: "c",
	}

	fmt.Printf("len(s): %v, cap(s): %v, s: %v\n", len(s), cap(s), s)

	for i, v := range s {
		fmt.Printf("%v: %v\n", i, v)
	}
}
```

## References
* [How do I find the size of the array in go](https://stackoverflow.com/questions/35937828/how-do-i-find-the-size-of-the-array-in-go)
