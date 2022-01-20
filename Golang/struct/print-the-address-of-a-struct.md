# Print the Address of a Struct

## Solution
* Use `%p` for the pointer type

## Example
```
addr := &struct{}{}
fmt.Printf("address of the struct: %p\n", addr)

// Output:
// address of the struct: 0x57a400
```

## References
* [How to print the address of struct variable in go](https://stackoverflow.com/questions/56112289/how-to-print-the-address-of-struct-variable-in-go)
