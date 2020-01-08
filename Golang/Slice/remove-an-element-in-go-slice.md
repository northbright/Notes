# Remove an Element in Go Slice

## Method A(generic)
```
s := append(s[:i], s[i+1:]...)
```

## Method B(fast)
```
func RemoveSliceItem(s []int, i int) []int {
	l := len(s)
	if l <= 0 {
		return s
	}

	if i < 0 || i > l-1 {
		return s
	}

	s[i] = s[l-1]
	return s[:l-1]
}
```

## Examples
```
package main

import "fmt"

func RemoveSliceItem(s []int, i int) []int {
	l := len(s)
	if l <= 0 {
		return s
	}

	if i < 0 || i > l-1 {
		return s
	}

	s[i] = s[l-1]
	return s[:l-1]
}

func main() {
	arr := []int{1, 2, 3}

	for i := len(arr) - 1; i >= 0; i-- {
		arr = RemoveSliceItem(arr, i)
		fmt.Printf("arr: %v\n", arr)
	}
	
	// Output:
	// arr: [1 2]
        // arr: [1]
        // arr: []
}
```
* [Playground](https://wide.b3log.org/playground/f468cc0361ae8d5e2865806ca1f5bc90.go)

## References
* [How to delete an element from a Slice in Golang](https://stackoverflow.com/questions/37334119/how-to-delete-an-element-from-a-slice-in-golang)

