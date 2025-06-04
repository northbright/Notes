# Call Functions with Multiple Arguments in Golang Template

## Example
```go
package main

import (
    "html/template"
    "os"
)

type Data struct {
    A int
    B int
}

func main() {
    funcMap := template.FuncMap{
        "multiply": func(a, b int) int {
            return a * b
        },
    }
    
    tmpl, _ := template.New("").Funcs(funcMap).Parse(text)
    
    d := Data{A: 5, B: 6}

    tmpl.Execute(os.Stdout, d)
    // Output:
    // a * b = 30
}

var text = `a * b = {{ multiply .A .B }}`
```
