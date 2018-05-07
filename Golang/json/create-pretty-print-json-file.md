# Create Pretty Print JSON File

Use these functions of [encoding/json](https://godoc.org/encoding/json) to set indent:
* [Indent](https://godoc.org/encoding/json#Indent)
* [MarshalIndent](https://godoc.org/encoding/json#MarshalIndent)
* [Encoder.SetIndent](https://godoc.org/encoding/json#Encoder.SetIndent)

#### Example
```
package main
  
import (
        "encoding/json"
        "os"
)

type Config struct {
        RedisServer   string `json:"redis_server"`
        RedisPassword string `json:"redis_password"`
}

func main() {
        config := Config{
                RedisServer:   ":6379",
                RedisPassword: "",
        }

        f, err := os.Create("config.json")
        if err != nil {
                return
        }

        encoder := json.NewEncoder(f)
        // Pretty print JSON: set ident to 4 spaces.
        encoder.SetIndent("", "    ")
        if err = encoder.Encode(config); err != nil {
                return
        }
}
```

#### References
* [How can I pretty-print JSON using Go?](https://stackoverflow.com/questions/19038598/how-can-i-pretty-print-json-using-go)
