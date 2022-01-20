# The JSON Object Name(string) Will Be Unmarshaled to Int When Unmarshal a JSON Object into a Map Which Key is Int

[json.Unmarshal](https://pkg.go.dev/encoding/json#Unmarshal) converts JSON name(string) to the map key(int)

The [doc](https://pkg.go.dev/encoding/json#Unmarshal) says:

> To unmarshal a JSON object into a map, Unmarshal first establishes a map to use.
> ......The map's key type must either be any string type, an integer, implement json.Unmarshaler, or implement encoding.TextUnmarshaler. 

## Example
```
package main

import (
        "encoding/json"
        "fmt"
)

// Name of the JSON object is the prize No(string)
var s = `
{"2": {"no": 2, "desc": "iPhone 13"},
"1": {"no": 1, "desc": "Macbook Pro"}}`

type Prize struct {
        No   int    `json:no`
        Desc string `json:desc`
}

func main() {
        // Key is the prize No(int)
        // Value is the Prize
        m := map[int]Prize{}

        // json.Unmarshal() will convert JSON name(string) to the map key(int)
        if err := json.Unmarshal([]byte(s), &m); err != nil {
                fmt.Printf("json.Unmarshal() error: %v\n", err)
                return
        }
        fmt.Printf("m: %v\n", m)

        // Output:
        // m: map[1:{1 Macbook Pro} 2:{2 iPhone 13}]
}
```
