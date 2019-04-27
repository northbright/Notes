# [Reader.ReadRune](https://godoc.org/bufio#Reader.ReadRune) of [bufio](https://godoc.org/bufio) will Decode UTF-8 BOM bytes to `U+FEFF(0xFEFF)`

## Problem
* A UTF-8 text file was created using Windows's Notepad
* Using Go program to read lines of the text file
* First decoded rune of the file is `0xFEFF`

## Root Cause
* Windows Notepad will add UTF-8 BOM(`0xEF, 0xBB, 0xBF`) bytes at the beginning of the file
* [Reader.ReadRune](https://godoc.org/bufio#Reader.ReadRune) of [bufio](https://godoc.org/bufio) will Decode UTF-8 BOM bytes to the rune(Unicode **codepoint**): `U+FEFF`

## Example Code
```
package main

import (
	"bufio"
	"bytes"
	"fmt"
)

func main() {
	buf := bytes.NewBuffer([]byte{0xef, 0xbb, 0xbf})

	r := bufio.NewReader(buf)
	rune, sizeInBytes, err := r.ReadRune()
	if err != nil {
		fmt.Printf("ReadRune() err: %v\n", err)
		return
	}
	fmt.Printf("rune: 0x%X, sizeInBytes: %v\n", rune, sizeInBytes)
}

// Output:
// rune: 0xFEFF, sizeInBytes: 3
```

* [Run the code on playground](https://wide.b3log.org/playground/cdc4d5c0f0580fe1bfb834648beba17e.go)

## References
* [Byte Order Mark (BOM) FAQ](http://www.unicode.org/faq/utf_bom.html#bom1)
* [Why BOM is U+FE FF, rather than U+FF FE?](https://stackoverflow.com/questions/36360792/why-bom-is-ufe-ff-rather-than-uff-fe)
