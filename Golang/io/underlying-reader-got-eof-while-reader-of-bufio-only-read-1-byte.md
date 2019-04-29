# Underlying Reader Got EOF while [Reader](https://godoc.org/bufio#Reader) of [bufio](https://godoc.org/bufio) Only Read 1 Byte

## Problem
* Create a bytes.Reader based on a byte slice(3 bytes)
* Created a bufio.Reader based on the bytes.Reader
* Call ReadByte() of bufio.Reader to read the first byte
* Call ReadByte() of bytes.Reader and got EOF

## Root Cause
* 1st ReadByte() of bufio.Reader read N bytes(buffer size: [4096 by default](https://github.com/golang/go/blob/dev.boringcrypto.go1.12/src/bufio/bufio.go#L18)) from underlying reader(bytes.Reader) which read all underlying bytes(4096 > 3)
* So next ReadByte() of bytes.Reader will return EOF

## Example Code
```
package main

import (
	"bufio"
	"bytes"
	"fmt"
)

func main() {
	buf := []byte{0xFE, 0xFF, 0x48}

	r1 := bytes.NewBuffer(buf)
	r2 := bufio.NewReader(r1)

	b, err := r2.ReadByte()
	fmt.Printf("bufio.Reader ReadByte(): b: %X, err: %v\n", b, err)

	// 1st ReadByte() of bufio.Reader read N bytes(buffer size: 4096) from underlying reader(bytes.Reader),
	// so ReadByte() of bytes.Reader will return EOF
	b, err = r1.ReadByte()
	fmt.Printf("bytes.Reader ReadByte(): b: %X, err: %v\n", b, err)

	// nSize is the size of underlying buffer of bufio.Reader
	nSize := r2.Size()
	// nBuffered is the number of bytes that can be read from the current buffer.
	nBuffered := r2.Buffered()

	fmt.Printf("bufio.Reader Size(): %v, Buffered: %v\n", nSize, nBuffered)

	for i := 0; i < nBuffered; i++ {
		b, err = r2.ReadByte()
		fmt.Printf("i: %v, b: %X\n", i, b)
	}
}

// Output:
// bufio.Reader ReadByte(): b: FE, err: <nil>
// bytes.Reader ReadByte(): b: 0, err: EOF
// bufio.Reader Size(): 4096, Buffered: 2
// i: 0, b: FF
// i: 1, b: 48
```
