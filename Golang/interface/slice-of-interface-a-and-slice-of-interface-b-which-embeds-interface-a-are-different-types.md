# Slice of Interface A and Slice of Interface B Which Embeds Interface A are Different Types

## Problem
* Hava a slice of [hash.Hash](https://pkg.go.dev/hash#Hash)
* Want to pass the slice as parameter to [io.MultiWriter](https://pkg.go.dev/io#MultiWriter) which accepts [[]io.Writer](https://pkg.go.dev/io#Writer)
* Example Code

  ```
  // package main

  // import (
  //     "hash"
  //     "io"
  // )

  // func Sum(hashes ...hash.Hash) ([][]byte, error) {
  //     io.MultiWriter(hashes...)
  //     return nil, nil
  // }

  // func main() {

  // }
  ```

* Got error when build the code

  > cannot use hashes (type []hash.Hash) as type []io.Writer in argument to io.MultiWriter

## Root Cause
* A slice of hash.Hash and a slice of io.Writer are different types even hash.Hash embeds io.Writer

## Solution
Convert []hash.Hash to []io.Writer
```
func Sum(hashes ...hash.Hash) ([][]byte, error) {
	// Convert []hash.Hash to []io.Writer
	var writers []io.Writer
	for _, h := range hashes {
		writers = append(writers, h)
	}
	io.MultiWriter(writers...)
	return nil, nil
}
```

## References
* [How to call method which accepts slice of interface as parameters in golang?](https://stackoverflow.com/questions/44313364/how-to-call-method-which-accepts-slice-of-interface-as-parameters-in-golang)
* [Can I convert a []T to an []interface{}?](https://golang.google.cn/doc/faq#convert_slice_of_interface)
