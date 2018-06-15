# Initialize Golang Struct with Anonymouse Member of Pointer Type

#### Solution
* Just use **type name** as the field

#### Example
```
package main

import (
	"fmt"
)

type Person struct {
	Name string
}

type Employee struct {
	JobTitle string
	// Pointer type
	*Person
}

func main() {
	e := Employee{
		JobTitle: "Software Engineer",
		// Use type 'Person' as the field
		Person: &Person{
			Name: "Frank",
		},
	}

	fmt.Printf("e: %v, e.Persion: %v\n", e, e.Person)
}

// Output:
// e: {Software Engineer 0xc42000e1e0}, e.Persion: &{Frank}
```

* [Playground](https://wide.b3log.org/playground/e6a7c43a05e1ab84f17c092c44ee78a1.go)

#### References
* [How to initialize Go struct with anonymous member of pointer type?](https://stackoverflow.com/questions/35376025/how-to-initialize-go-struct-with-anonymous-member-of-pointer-type)
