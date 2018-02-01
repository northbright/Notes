# Get the Type at Runtime in Golang

#### Methods
There're 3 methods to get the type at runtime:  

* Using `fmt.Sprintf("%T", v)`  
  * Short and good for log messages.

* Using refect package:  
  * `reflect.TypeOf(v).String()`  
  * More details

* Using type assertions:

  vv will be the value for converted type.

```
package main

import "fmt"

type User struct {
	Name  string
	Email string
}

func typeof(v interface{}) {
	switch vv := v.(type) {
	case int:
		fmt.Printf("type: int, value: %d\n", vv)
	case int64:
		fmt.Printf("type: int64, value: %d\n", vv)
	case string:
		fmt.Printf("type: string, value: %s\n", vv)
	case User:
		fmt.Printf("type: User, value: %v\n", vv)
	default:
		fmt.Printf("other type: %T, value: %v\n", vv, vv)
	}
}

func main() {
	arr := make([]interface{}, 5)

	arr[0] = 1                          // int
	arr[1] = int64(2)                   // int64
	arr[2] = "hello"                    // string
	arr[3] = User{"Frank", "xx@xx.com"} // User type
	arr[4] = float64(1.0)               // float64

	for _, v := range arr {
		typeof(v)
	}

	// Output:
	//type: int, value: 1
	//type: int64, value: 2
	//type: string, value: hello
	//type: User, value: {Frank xx@xx.com}
	//other type: float64, value: 1
}

```
#### References
* [How to find a type of a object in golang?(see Grzegorz Luczywo's answer)](http://stackoverflow.com/questions/20170275/how-to-find-a-type-of-a-object-in-golang)
