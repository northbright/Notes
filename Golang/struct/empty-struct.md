# Empty Struct

#### Size
Size of empty struct(`struct{}`) is 0

        package main

        import (
                "fmt"
                "unsafe"
        )

        func main() {
                v := struct{}{}

                fmt.Println(unsafe.Sizeof(v))
                // Output: 0
        }

#### Usage
* It can use `map[T]struct{}` to implement "SET" type.
* <https://github.com/bradfitz/iter>
    * func N returns a slice of n 0-sized elements, suitable for ranging over.
    * It does not cause any allocations.

             For example:

             for i := range iter.N(10) {
                 fmt.Println(i)
             }

             ... will print 0 to 9, inclusive.

#### References
* [The empty struct](http://dave.cheney.net/2014/03/25/the-empty-struct)
* [空结构体struct{}解析](http://www.golangtc.com/t/575442b8b09ecc02f7000057)
* <https://github.com/bradfitz/iter>              
