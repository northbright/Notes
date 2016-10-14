# Stores JSON Number as int64 while Unmarshal JSON into an interface Value

#### Problem
* By default, Unmarshal stores JSON number as float64 while using encoding/json.

> To unmarshal JSON into an interface value,
  Unmarshal stores one of these in the interface value:
  //
  //    bool, for JSON booleans
  //    float64, for JSON numbers 
  //    string, for JSON strings 
  //    []interface{}, for JSON arrays
  //    map[string]interface{}, for JSON objects 
  //    nil for JSON null

* Example
  We need to unmarshal JSON and store JSON number as int64 but get float64.

        package main

        import (
	        "bytes"
	        "encoding/json"
	        "fmt"
        )

        func main() {
	        data := `{"id":12345678910}`
	        var f interface{}

	        dec := json.NewDecoder(bytes.NewReader([]byte(data)))
	        dec.Decode(&f)

	        m := f.(map[string]interface{})
	        fmt.Printf("id: %v, type: %T\n", m["id"], m["id"])
	        // Output:
	        // id: 1.234567891e+10, type: float64
        }

#### Solutuion
* Use [`func (*Decoder).UseNumber`](https://godoc.org/encoding/json#Decoder.UseNumber)

> UseNumber causes the Decoder to unmarshal a number into an interface{} as a Number instead of as a float64.

* It stores JSON number as [`json.Number(string)`](https://godoc.org/encoding/json#Number) which has [Int64()](https://godoc.org/encoding/json#Number.Int64), [Float64()](https://godoc.org/encoding/json#Number.Float64),[String()](https://godoc.org/encoding/json#Number.String)

* Example

        package main

        import (
	        "bytes"
	        "encoding/json"
	        "fmt"
        )

        func main() {
	        data := `{"id":12345678910}`
	        var f interface{}

	        dec := json.NewDecoder(bytes.NewReader([]byte(data)))
	        dec.UseNumber() // Use json.Number to store JSON number
	        dec.Decode(&f)

	        m := f.(map[string]interface{})
	        fmt.Printf("id: %v, type: %T\n", m["id"], m["id"])
	        // Output:
	        // id: 12345678910, type: json.Number

	        for k, v := range m {
		        switch vv := v.(type) {
		        case json.Number:
			        i, _ := vv.Int64()
			        fmt.Printf("k: %v, v: %d, type: %T\n", k, i, i)
		        }
	        }
	        // Output:
	        // k: id, v: 12345678910, type: int64
        }

#### References
* [encoding/json: support unmarhaling "1.111111e+06" into int64 #5562](https://github.com/golang/go/issues/5562)
* [Depends on issue golang/go#5562, added another Unmarshal mechanism ](https://github.com/OwnLocal/goes/pull/7/commits/310f5bae09e5a8887e204720186b05d5c9cd425b)
* [Unmarshal](https://godoc.org/encoding/json#Unmarshal)

