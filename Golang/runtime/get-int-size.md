# Get Int Size

## Solution A
Use [strconv.IntSize](https://godoc.org/strconv#pkg-constants) constant

[Souce Code](https://github.com/golang/go/blob/release-branch.go1.11/src/strconv/atoi.go#L42):
```
const intSize = 32 << (^uint(0) >> 63)
// IntSize is the size in bits of an int or uint value.
const IntSize = intSize
```

## Solution B
Use [unsafe.Sizeof()](https://godoc.org/unsafe#Sizeof)

```
Size int = int(unsafe.Sizeof(0))
```

## References
* [What is the difference between int and int64 in Go?](https://stackoverflow.com/questions/21491488/what-is-the-difference-between-int-and-int64-in-go)
