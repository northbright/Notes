# Use `string` Option to Marshal `int64` Field of a Struct to a JSON String

## Background
* `int64` field is encoded to a JSON number which max value is dependent on target environment.
* The encoded JSON number from Golang can be out of the range of Javascript's min / max integer.
* It's better to marshal a `int64` to a JSON string but NOT a JSON number.

## Solution
* Use `string` option for the field of a struct to store the number in JSON string.
* See [Marshal](https://godoc.org/encoding/json#Marshal)

  ```
   The "string" option signals that a field is stored as JSON inside a JSON-encoded string. It applies only to fields of string, floating point, integer, or boolean types. This extra level of encoding is sometimes used when communicating with JavaScript programs:

  Int64String int64 `json:",string"`

  ```


## Example Code
```
package main

import (
        "encoding/json"
        "fmt"
)

type Data struct {
        Offset int64 `json:"offset,string"`
}

func main() {
        data := Data{Offset: 10086}
        fmt.Printf("original data: %v\n", data)

        buf, _ := json.Marshal(&data)
        fmt.Printf("encode data to JSON: %s\n", string(buf))

        data = Data{}
        json.Unmarshal(buf, &data)
        fmt.Printf("decode JSON to data: %v\n", data)

        // Output:
        //original data: {10086}
        //encode data to JSON: {"offset":"10086"}
        //decode JSON to data: {10086}
}
```

## References
* [JSON integers: limit on size](https://stackoverflow.com/questions/13502398/json-integers-limit-on-size)
