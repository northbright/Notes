# byte is an alias for uint8

#### byte type

byte is an alias for uint8 and is equivalent to uint8 in all ways. It is used, by convention, to distinguish byte values from 8-bit unsigned integer values.

#### Code
    
    package main

    import "fmt"

    func main() {
	    buf := []byte{'a', '1'}
	    fmt.Printf("buf type:%T value:%v\n", buf, buf)
	    // Output:
	    //buf type:[]uint8 value:[97 49]
    }

#### Reference
* [type byte](https://golang.org/pkg/builtin/#byte) 
