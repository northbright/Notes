# `json` Package encodes `byte` Slice as Base64-Encoded String

## Details
* `[]byte` is encoded to a base64-encoded string
* The base64-encoded string will be decoded to `[]byte` successfully if pass a `*[]byte` as parameter to `json.Unmarshal()`

## See [Marshal on godoc](https://godoc.org/encoding/json#Marshal)

> Array and slice values encode as JSON arrays, except that []byte encodes as a base64-encoded string, and a nil slice encodes as the null JSON value.

## Check Golang Source:
* [func encodeByteSlice](https://github.com/golang/go/blob/release-branch.go1.14/src/encoding/json/encode.go#L819)
```
func encodeByteSlice(e *encodeState, v reflect.Value, _ encOpts) {
        ......
	encodedLen := base64.StdEncoding.EncodedLen(len(s))
        ......

```
* [literalStore()](https://github.com/golang/go/blob/release-branch.go1.14/src/encoding/json/decode.go#L956)

```
func (d *decodeState) literalStore(item []byte, v reflect.Value, fromQuoted bool) error {
......
	case '"': // string
        ......
		case reflect.Slice:
			if v.Type().Elem().Kind() != reflect.Uint8 {
				d.saveError(&UnmarshalTypeError{Value: "string", Type: v.Type(), Offset: int64(d.readIndex())})
				break
			}
			b := make([]byte, base64.StdEncoding.DecodedLen(len(s)))
			n, err := base64.StdEncoding.Decode(b, s)
			if err != nil {
				d.saveError(err)
				break
			}
			v.SetBytes(b[:n])
......
}

```

## Example Code
```
package main

import (
        "encoding/json"
        "fmt"
)

func main() {
        data := []byte("Hello World!")
        fmt.Printf("original []byte: %X = %s\n", data, data)

        buf, _ := json.Marshal(data)
        fmt.Printf("encode []byte to JSON: %X = %s\n", buf, string(buf))

        data = []byte{}
        json.Unmarshal(buf, &data)
        fmt.Printf("decoded JSON to []byte: %X = %s\n", data, string(data))

        // Test []byte in struct
        s := struct {
                Data []byte `json:"data"`
        }{
                []byte("Hello Golang!"),
        }

        fmt.Printf("original struct: %v\n", s)
        fmt.Printf("original []byte in struct: %X = %s\n", s.Data, s.Data)

        buf, _ = json.Marshal(s)
        fmt.Printf("encode struct to JSON: %s\n", string(buf))

        json.Unmarshal(buf, &s)
        fmt.Printf("decode JSON. struct: %v\n", s)
        fmt.Printf("decoded []byte in struct: %X = %s\n", s.Data, s.Data)
}
```

## References
* [How to marshal a byte/uint8 array as json array in Go?](https://stackoverflow.com/questions/14177862/how-to-marshal-a-byte-uint8-array-as-json-array-in-go)
