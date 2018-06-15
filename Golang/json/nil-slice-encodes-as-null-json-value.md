# `nil` Slice Encodes as `null` JSON Value

#### Details
* `nil` slice encodes as `null` JSON value
* empty slice encodes as empty JSON value: `[]`

#### Example
```
package main

import (
	"encoding/json"
	"fmt"
)

type Post struct {
	Title      string   `json:"title"`
	Comments   []string `json:"comments"`
	Tags       []string `json:"tags"`
	Categories []string `json:""categories`
}

func main() {
	p := Post{
		Title: "How to use Golang json package?",
		// Use default zero value(nil) to initialize "Comments"
		// Use explicit "nil" to initialize "Tags"
		Tags: nil,
		// Use empty slice to initialize "Categories"
		Categories: []string{},
	}

	fmt.Printf("p: %v\n", p)

	buf, _ := json.MarshalIndent(p, "", "    ")
	fmt.Printf("JSON: %v\n", string(buf))

	// p: {How to use Golang json package? [] [] []}
	// JSON: {
	// "title": "How to use Golang json package?",
	// "comments": null,
	// "tags": null,
	// "Categories": []
	// }
}
```

* [Playground](https://wide.b3log.org/playground/bb359f60bba73af94307ee86f0afa781.go)

#### References
* <https://godoc.org/encoding/json#Marshal>
