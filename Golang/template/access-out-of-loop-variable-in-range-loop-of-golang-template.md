# Access Out of Loop Variable in `range` Loop of Golang Template

## Problem
* When passing . to range in this template, the dot refers to the whole slice, but within each iteration of the range loop, the dot refers to the current item in the slice.
* Need to access out of loop variable

## Solution
Use `$.XX` to access out of loop variable.

## Example
```go
package main

import (
	"os"
	"text/template"
)

type Student struct {
	Name string
	Age  int
}

type Class struct {
	Teacher  string
	Students []Student
}

func main() {
	c := Class{
		Teacher: "Miss Su",
		Students: []Student{
			Student{Name: "Jacky", Age: 19},
			Student{Name: "Andy", Age: 18},
		},
	}

	t, err := template.New("").Parse(tmpl)
	if err != nil {
		return
	}
	if err := t.Execute(os.Stdout, c); err != nil {
		return
	}
}

var tmpl = `
{{- range .Students -}}
  Hello, I'm {{ .Name }}, my teacher is {{ $.Teacher }}
{{ end -}}
`
```

## References
* [golang模板语法简明教程](https://studygolang.com/articles/3071)
* [golang template(数组循环、在循环内使用外部变量、索引从1开始)](https://blog.csdn.net/u010918487/article/details/113555891)
* [How To Use Templates in Go](https://www.digitalocean.com/community/tutorials/how-to-use-templates-in-go)
