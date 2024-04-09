# Check if String Variable is Not Empty in Golang Templates

## Example
```golang
package main

import (
	"html/template"
	"log"
	"os"
)

func main() {
	type Student struct {
		Name string
		Age  int
	}

	tmpl := `
{{- if not .Name }}
Name: Unkown
{{- else -}}
Name: {{ .Name }}, Age: {{ .Age }}
{{- end }}
`

	students := []Student{
		Student{Name: "", Age: 20},
		Student{Name: "Jacky", Age: 21},
	}

	// Create a new template and parse the letter into it.
	t := template.Must(template.New("").Parse(tmpl))

	// Execute the template for each student.
	for _, s := range students {
		err := t.Execute(os.Stdout, s)
		if err != nil {
			log.Println("executing template:", err)
		}
	}

	// Output:
	//Name: Unkown
	//Name: Jacky, Age: 21
}
```
