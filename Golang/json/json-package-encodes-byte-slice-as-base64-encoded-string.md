# `json` Package encodes `byte` Slice as Base64-Encoded String

## See [Marshal on godoc](https://godoc.org/encoding/json#Marshal)

> Array and slice values encode as JSON arrays, except that []byte encodes as a base64-encoded string, and a nil slice encodes as the null JSON value.

## Check [func encodeByteSlice](https://github.com/golang/go/blob/release-branch.go1.14/src/encoding/json/encode.go#L819)
```
func encodeByteSlice(e *encodeState, v reflect.Value, _ encOpts) {
        ......
	encodedLen := base64.StdEncoding.EncodedLen(len(s))
        ......

```

## References
* [How to marshal a byte/uint8 array as json array in Go?](https://stackoverflow.com/questions/14177862/how-to-marshal-a-byte-uint8-array-as-json-array-in-go)
