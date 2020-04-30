# `json` Package Marshals `byte` Slice with Base64 Encoding

## See [func encodeByteSlice](https://github.com/golang/go/blob/release-branch.go1.14/src/encoding/json/encode.go#L819)
```
func encodeByteSlice(e *encodeState, v reflect.Value, _ encOpts) {
        ......
	encodedLen := base64.StdEncoding.EncodedLen(len(s))
        ......

```
