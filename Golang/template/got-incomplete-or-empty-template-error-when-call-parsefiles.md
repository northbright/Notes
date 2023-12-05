# Got "incomplete or empty template" Error when Call ParseFiles

## Problem
* Got "incomplete or empty template" when Run Below Code:

  ```
  func ExecuteTemplate(templFile, outputFile string) error {
      t, err := template.New(tmplFile).ParseFiles(tmplFile)
      if err != nil {
          return err
      }
      ......
  }
  ```

## Root Cause
Make sure the arguments you pass to template.New is the **BASE** name of one of the files in the list you pass to ParseFiles.

See [ParseFiles](https://pkg.go.dev/text/template#Template.ParseFiles):
> Since the templates created by ParseFiles are named by the base names of the argument files,
> t should usually have the name of one of the (base) names of the files.

## Solution

```
func ExecuteTemplate(templFile, outputFile string) error {
    t, err := template.New(path.Base(tmplFile)).ParseFiles(tmplFile)
    if err != nil {
        return err
    }
    ......
}
```

## References
* [error: template: "..." is an incomplete or empty template](https://stackoverflow.com/questions/49043292/error-template-is-an-incomplete-or-empty-template)
