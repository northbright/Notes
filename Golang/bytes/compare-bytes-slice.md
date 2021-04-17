# Compare Byte Slice

## Solution
* Use [bytes.Equal](https://pkg.go.dev/bytes#Equal)

## Implementation

[Equal](<https://github.com/golang/go/blob/release-branch.go1.16/src/bytes/bytes.go#L18>) converts the byte slices to strings and compare strings

```
// Equal reports whether a and b
// are the same length and contain the same bytes.
// A nil argument is equivalent to an empty slice.
func Equal(a, b []byte) bool {
	// Neither cmd/compile nor gccgo allocates for these string conversions.
	return string(a) == string(b)
}
```

## References
* [Golang String Compare Internals(Go 1.9)](https://github.com/northbright/Notes/blob/master/Golang/string/golang-string-compare-internals.md)

