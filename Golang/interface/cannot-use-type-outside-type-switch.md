# Can't Use of `.(type)` outside type switch 

`.(type)` must be used in [type switches](https://golang.org/ref/spec#Type_switches)

        switch i := x.(type) {
        case nil:
	        printString("x is nil")                // type of i is type of x (interface{})
        case int:
	        printInt(i)                            // type of i is int
        case float64:
	        printFloat64(i)                        // type of i is float64
        case func(int) float64:
        	printFunction(i)                       // type of i is func(int) float64
        case bool, string:
	        printString("type is bool or string")  // type of i is type of x (interface{})
        default:
	        printString("don't know the type")     // type of i is type of x (interface{})
        }

#### References
* [type switches](https://golang.org/ref/spec#Type_switches)
* [How to find a type of a object in Golang?](http://stackoverflow.com/questions/20170275/how-to-find-a-type-of-a-object-in-golang)

