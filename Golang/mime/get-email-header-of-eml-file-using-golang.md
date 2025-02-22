# Get Email Header of eml File using Golang

## Problem
* Get "from", "to", "subject" of email header in an .eml file using Golang
* Characters in headers may be UTF-8 and encoded using RFC 2047

## Solution
Using [mime](https://pkg.go.dev/mime), [net/mail](https://pkg.go.dev/net/mail) to parse MIME email.

## Example
```go
package main

import (
	"fmt"
	"mime"
	"net/mail"
	"os"
)

func main() {
	f, err := os.Open(os.Args[1])
	if err != nil {
		fmt.Printf("failed to open eml file: %v\n", err)
		return
	}

	m, err := mail.ReadMessage(f)
	if err != nil {
		fmt.Printf("ReadMessage() error: %v\n", err)
		return
	}

	dec := new(mime.WordDecoder)
	date, _ := dec.DecodeHeader(m.Header.Get("Date"))
	from, _ := dec.DecodeHeader(m.Header.Get("From"))
	to, _ := dec.DecodeHeader(m.Header.Get("To"))
	subject, _ := dec.DecodeHeader(m.Header.Get("Subject"))

	fmt.Println("Date:", date)
	fmt.Println("From:", from)
	fmt.Println("To:", to)
	fmt.Println("Subject:", subject)

	mediaType, params, err := mime.ParseMediaType(m.Header.Get("Content-Type"))
	if err != nil {
		fmt.Printf("ParseMediaType() error: %v", err)
		return
	}
	fmt.Printf("mediaType: %v, params: %v\n", mediaType, params)
}
```

## References
* [How to parse a MIME email in Golang](https://github.com/kirabou/parseMIMEemail.go)
