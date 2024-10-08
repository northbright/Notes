# Clear a Slice

## Method A
Set the slice to nil.

```go
var a = []int{1, 2, 3}

// Set a to a nil slice.
a = nil

fmt.Printf("a = %v, len(a) = %v, cap(a) = %v\n", a, len(a), cap(a))
// Output:
// [], 0, 0
```

## Method B
Re-slice the slice using `[:0]`.

A missing low index defaults to zero and set also high index to zero.

```go
var a = []int{1, 2, 3}

// Re-slice slice a to an empty slice.
a = a[:0]

// The data stored in the underlying slice are still there.
fmt.Printf("a = %v, len(a) = %v, cap(a) = %v\n", a, len(a), cap(a))
fmt.Printf("a[:1] = %v\n", a[:1])

// Output:
// a = [], len(a) = 0, cap(a) = 3
// a[:1] = [1]
```

## References
* [Go: 清空 Slice 的两种方法：[:0]和nil](https://islishude.github.io/blog/2020/09/22/golang/Go-%E6%B8%85%E7%A9%BA-Slice-%E7%9A%84%E4%B8%A4%E7%A7%8D%E6%96%B9%E6%B3%95%EF%BC%9A-0-%E5%92%8Cnil/)
