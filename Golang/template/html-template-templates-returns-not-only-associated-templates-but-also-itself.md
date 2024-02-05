# text/template func `(*template).Templates` Returns NOT Only Associated Templates BUT ALSO Itself

* func `(*template).Templates` of `text/template` Returns Associated Templates
* func `(*template).Templates` of `html/template` Returns Associated Templates and **ITSELF**

## Example Code

#### `text/template`
```
package main

import (
        "fmt"
        "text/template"
)

func main() {
        t := template.New("test")
        
        tmpls := t.Templates()
        fmt.Printf("len of t.Templates(): %v\n", len(tmpls))
        
        for i, tmpl := range tmpls {
                fmt.Printf("id: %v, name: %v\n", i, tmpl.Name())
        }
        
        // Output:
        //len of t.Templates(): 0
}
```

#### `html/template`
```
package main

import (
        "fmt"
        "html/template"
)

func main() {
        t := template.New("test")
        
        tmpls := t.Templates()
        fmt.Printf("len of t.Templates(): %v\n", len(tmpls))

        for i, tmpl := range tmpls {
                fmt.Printf("id: %v, name: %v\n", i, tmpl.Name())
        }

        // Output:
        //len of t.Templates(): 1
        //id: 0, name: test
}
```
