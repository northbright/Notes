# Mark a Struct Implements an Interface

## Problem
* Need to Mark a Struct Implments an Interface

## Solution
Use assignment to test if a type implements an interface.

```go
type T struct{}

var _ I = T{}  // Verify that T implements I.
var _ I = (*T)(nil)  // Verify that *T implements I.      
```

## References
* [How to mark golang struct as implementing interface?](https://stackoverflow.com/questions/33089523/how-to-mark-golang-struct-as-implementing-interface)
