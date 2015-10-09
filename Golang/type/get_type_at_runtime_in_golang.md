# Get the Type at Runtime in Golang

#### Methods
There're 3 methods to get the type at runtime:  

* Using `fmt.Sprintf("%T", v)`  
  * Short and good for log messages.

* Using refect package:  
  * `reflect.TypeOf(v).String()`  
  * More details

* Using type assertions:

        func typeof(v interface{}) string {
            switch t := v.(type) {
            case int:
                return "int"
            case int64:
                return "int64"
            case float64:
                return "float64"
            default:
                _ = t
                return "unknown"
            }
        }

#### References
* [How to find a type of a object in golang?(see Grzegorz Luczywo's answer)](http://stackoverflow.com/questions/20170275/how-to-find-a-type-of-a-object-in-golang)