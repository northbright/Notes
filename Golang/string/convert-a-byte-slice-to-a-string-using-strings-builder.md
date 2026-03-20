# Convert a Byte Slice to a String using strings.Builder

## Example

```go

func main() {
    b1 := []byte{'h', 'e', 'l', 'l', 'o'}
    b2 := []byte{',', 'w', 'o', 'r', 'l', 'd', '!'}

    var builder strings.Builder
    builder.Write(b1)
    builder.Write(b2)

    s := builder.String()
    fmt.Printf("%s\n", s)
    
    // Output:
    // hello,world!
}
```

## References
* [GO Bytes to String Conversion Best Practices [5 Methods]](https://www.golinuxcloud.com/go-bytes-to-string/)
* [Builder](https://pkg.go.dev/strings#Builder)
