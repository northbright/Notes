# Can not Assign Struct Field in Map

#### Problem
We can not assign struct field in map.

    package main

    import (
	    "fmt"
    )

    type student struct {
	    age int
    }

    func main() {
	    m := map[string]student{
		    "Bob":  {age: 16},
		    "Jack": {age: 18},
	    }

	    m["Bob"].age = 17 // Cannot assign struct field in map.
            fmt.Printf("Bob's age: %v\n", m["Bob"].age)
    }

#### Root Cause
* The left side of the assignment **MUST** be ["addressable"](https://golang.org/ref/spec#Address_operators)
* m["Bob"] is a thing called a ["map index expression"](https://golang.org/ref/spec#Index_expressions) in the spec.

#### Solution(Work around)
* Use pointer to a struct as the value of map.

#### Example

    package main

    import (
        	"fmt"
    )

    type student struct {
    	age int
    }

    func main() {
            // Store pointers of student as values of map.
	    m := map[string]*student{
		    "Bob":  {age: 16},  // "Bob": &student{age: 16} are also OK.
		    "Jack": {age: 18},
	    }

	    m["Bob"].age = 17
	    fmt.Printf("Bob's age: %v\n", m["Bob"].age)
    }

#### References
* [Why do I get a “cannot assign” error when setting value to a struct as a value in a map?](http://stackoverflow.com/questions/32751537/why-do-i-get-a-cannot-assign-error-when-setting-value-to-a-struct-as-a-value-i)
