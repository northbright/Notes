# Got "incomplete or empty template" Error when Call template.Execute

## Problem
* Got "incomplete or empty template" when Run Below Code:

  ```go
  func ExecuteTemplate(templFile, outputFile string) error {
      t, err := template.New(tmplFile).ParseFiles(tmplFile)
      if err != nil {
          return err
      }

      ......
      if err := t.Execute(w, data); err != nil {
          return err
      }
      ......
  }
  ```

## Root Cause
Template created by [func New](https://pkg.go.dev/text/template#New) without calling [func (*Template) Parse](https://pkg.go.dev/text/template#Template.Parse) will have en empty template body.
Calling [func (*Template) ParseFiles](https://pkg.go.dev/text/template#Template.ParseFiles) just associates new parsed templates to t(append to it) but t's template is still empty.

Call [func (*Template) Execute](https://pkg.go.dev/text/template#Template.Execute) on t with empty template will fail. 

See docs of [func (*Template) ParseFiles](https://pkg.go.dev/text/template#Template.ParseFiles):

> Since the templates created by ParseFiles are named by the base names of the argument files, t should usually have the name of one of the (base) names of the files. If it does not, depending on t's contents before calling ParseFiles, t.Execute may fail. In that case use t.ExecuteTemplate to execute a valid template.

## Solution
#### Method A: Just use [func ParseFiles](https://pkg.go.dev/text/template#ParseFiles) instead(recommended)

```go
func ExecuteTemplate(templFile, outputFile string) error {
    // The returned template's name will have the base name and parsed contents of the first file(only one file in this case).
    t, err := template.ParseFiles(tmplFile)
    if err != nil {
        return err
    }
    ......
    if err := t.Execute(w, data); err != nil {
        return err
    }
    ......
}
```


#### Method B: Use t.ExecuteTemplate() with name(file's name) instead
```go
func ExecuteTemplate(templFile, outputFile string) error {
    t, err := template.New("").ParseFiles(tmplFile)
    if err != nil {
        return err
    }
    ......
    // Use base name which is the same as template's name.
    name := filepath.Base(templFile)
    if err := t.ExecuteTemplate(w, name, data); err != nil {
        return err
    }
    ......
}
```

## References
* [error: template: "..." is an incomplete or empty template](https://stackoverflow.com/questions/49043292/error-template-is-an-incomplete-or-empty-template)
* [text/template func (*template).Templates Returns NOT Only Associated Templates BUT ALSO Itself](https://github.com/northbright/Notes/blob/master/Golang/template/html-template-templates-returns-not-only-associated-templates-but-also-itself.md)
