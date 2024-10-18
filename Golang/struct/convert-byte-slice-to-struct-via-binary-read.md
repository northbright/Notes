# Convert Byte Slice to Struct via binary.Read

## Problem
* Store struct A to a byte slice
* Need to read the byte slice and convert the byte slice to struct A back

## Solution
Use [binary.Read](https://pkg.go.dev/encoding/binary#Read).

Caveat:
1. The struct must have fixed size.
2. All fields of the struct must be EXPORTED or it'll panic when call binary.Read.
3. Blank `(_)` field names is skipped when reading binary data into a struct.


## Example
```go
package main

import (
	"bytes"
	"encoding/binary"
	"fmt"
	"log"
)

func main() {
	// The struct has fixed size.
	// All fields are exported or it'll panic when call binary.Read.
	type P struct {
		Checksum uint64
		ID       uint64
		Name     [5]byte
	}

	p1 := &P{
		Checksum: 0,
		ID:       1,
		Name:     [5]byte{'f', 'r', 'a', 'n', 'k'},
	}

	// Create a bytes.Buffer(io.Writer).
	buf := &bytes.Buffer{}

	// Write binary data of p1 to the buffer.
	if err := binary.Write(buf, binary.LittleEndian, p1); err != nil {
		log.Printf("binary.Write() error: %v", err)
		return
	}
	log.Printf("binary.Write() OK")

	p2 := &P{}
	// Read binary data from the buffer into p2.
	if err := binary.Read(buf, binary.LittleEndian, p2); err != nil {
		log.Printf("binary.Read() error: %v", err)
		return
	}
	log.Printf("binary.Read() OK")

	fmt.Printf("p2: %v\n", p2)

	// Output:
	// p2: &{0 1 [102 114 97 110 107]}
}
```

## References
* [binary.Read](https://pkg.go.dev/encoding/binary#Read)
* [go中struct和[]byte互相转换](https://cloud.tencent.com/developer/article/1468933)
