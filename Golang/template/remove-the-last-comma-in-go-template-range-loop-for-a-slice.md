# Remove the Last Comma in Go Template Range Loop for A Slice

## Problem
```
package main

import (
        "bytes"
        "fmt"
        "text/template"
)

func main() {
        arr := []string{"a", "b", "c"}
        tmpl, _ := template.New("Test1").Parse("{{ range $el := . }}{{ $el }},{{ end }}")

        buf := bytes.NewBuffer([]byte{})
        tmpl.Execute(buf, arr)
        fmt.Printf("Test1: %v\n", buf)

        // Output:
        // Test1: a,b,c,
```

* Use Go temlate to iterate over a slice
* Want to output "a,b,c" but got "a,b,c,"
* Need to remove the comma after last element

## Solution
Output a comma after the non-first element

```
        // Output a comma only if the element is NOT the first element.
        tmpl, _ = template.New("Test2").Parse("{{ range $i, $el := . }}{{ if $i }},{{ end }}{{ $el }}{{ end }}")
        buf.Reset()
        tmpl.Execute(buf, arr)
        fmt.Printf("Test2: %v\n", buf)

        // Output:
        // Test2: a,b,c
```

## References
* [Go template remove the last comma in range loop](https://stackoverflow.com/questions/42662525/go-template-remove-the-last-comma-in-range-loop)
* [detect last item inside an array using range inside go-templates](https://stackoverflow.com/questions/50085038/detect-last-item-inside-an-array-using-range-inside-go-templates)
