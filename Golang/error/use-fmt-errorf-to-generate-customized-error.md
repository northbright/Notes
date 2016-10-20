# Use fmt.Errorf() to Generate Customized Error

#### Example

    package main

    import (
            "fmt"
    )

    func main() {
	    i := 1
	    err := fmt.Errorf("Customized error: i = %d", i)
	    fmt.Println(err)
    }
