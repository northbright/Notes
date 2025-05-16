# Failed to Unmarshal JSON if There's Space and Underscore in Struct Field Name

## Problem
* It failed to unmarshal JSON to struct
  * The struct field name of JSON has unserscore("_") and a space prefix
     
         // Caution: There's a space before between : and "
         UserName: `json: "user_name"` 
  * There's a space before between `:` and `"`
* But it **works** for a struct name of JSON has as space prefix but with **NO** underscore
  
       // Also has a space but it works
       UserName: `json: "UserName"` 
   
## Example Code

```
package main

import (
	"encoding/json"
	"fmt"
)

type Data struct {
	UserName string `json: "user_name"`
}

func main() {
	buf := []byte(`{"user_name":"frank"}`)
	d := Data{}

	err := json.Unmarshal(buf, &d)
	fmt.Printf("d: %v, err: %v\n", d, err)

	// Output:
	//d: {}, err: <nil>
}
```

## Solution
* Remove the space in struct field name

       UserName string `json:"user_name"`

## Workable Example
```
package main

import (
	"encoding/json"
	"fmt"
)

type Data struct {
	UserName string `json:"user_name"`
}

func main() {
	buf := []byte(`{"user_name":"frank"}`)
	d := Data{}

	err := json.Unmarshal(buf, &d)
	fmt.Printf("d: %v, err: %v\n", d, err)

	// Output:
	//d: {frank}, err: <nil>
}
```


## References
* [Unmarshalling Json with fields with underscores in their names](https://grokbase.com/t/gg/golang-nuts/139rdwmrgn/go-nuts-unmarshalling-json-with-fields-with-underscores-in-their-names)
* [encoding/json: Field name tag not respected when encoding if there is a space after ":" #14142](https://github.com/golang/go/issues/14142)
