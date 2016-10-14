# Invalid Map Key Type

#### Problem
* We created a map

        m := map[[]string]bool
        m[[]string{"a","b"}] = true

* We encountered an error: "invalid map key type []string"

#### Root Cause
* KeyType may be any type that is [comparable](https://golang.org/ref/spec#Comparison_operators)
* Slices are not camparable.

#### Solution
* `Pointer` is comparable
* `m := map[*[]string]bool`

#### Example

        package main

        import "fmt"

        func main() {
	        m := make(map[*[]string]bool)
	        m[&[]string{"a", "b"}] = true
	        m[&[]string{"c"}] = false

	        for k, v := range m {
		        fmt.Printf("k:\n")
		        for _, s := range *k {
			        fmt.Printf("%v\n", s)
		        }
		        fmt.Printf("v: %v\n", v)
	        }
        }

#### References
* [Golang how to use function as map's key](http://stackoverflow.com/questions/27267042/golang-how-to-use-function-as-maps-key)
* [Map types](https://golang.org/ref/spec#Map_types)
* [Comparison operators](https://golang.org/ref/spec#Comparison_operators)
