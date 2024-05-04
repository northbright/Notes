# Wrong Implementation of `json.Marshaler` Interface Cause Stackoverflow

## Problem
* Type Task Implements [json.Marshaler](https://pkg.go.dev/encoding/json#Marshaler) Interface

  ```go
  type Task struct {
      Dst string `json:"dst"`
      Src string `json:"src"`
      ......
  }

  func (t *Task) MarshalJSON() ([]byte, error) {
      // Just call json.Marshal() on t
      return json.Marshal(t)
  }

  func (t *Task) UnmarshalJSON(data []byte) error {
      // Just call json.Unmarshal() on t
      json.Unmarshal(data, t)
      // Do some customization.
      ......
  }
  ```

* The Program Encounters a Fatal Error: Stackoverflow at `task.MarshalJSON()` or `task.UnmarshalJSON()`

## Root Cause
[`json.Marshal`](https://pkg.go.dev/encoding/json#Marshal) doc says:
> Marshal traverses the value v recursively. If an encountered value implements Marshaler and is not a nil pointer, Marshal calls [Marshaler.MarshalJSON] to produce JSON.

Use `json.Marshal() on a value to implement `json.Marshaler` interface for value's type will cause an infinite loop.

The same as `json.Unmarshal`.

## Solution
Using a local type(alias) for the type.

```go
func (t *Task) MarshalJSON() ([]byte, error) {
        // Use a local type(alias) to avoid infinite loop when call json.Marshal() in MarshalJSO
N().
        type localTask Task

        a := (*localTask)(t)
        return json.Marshal(a)
}

func (t *Task) UnmarshalJSON(data []byte) error) {
        // Use a local type(alias) to avoid infinite loop when call json.Marshal() in MarshalJSO
N().
        type localTask Task

        a := (*localTask)(t)

        json.Unmarshal(data, lt)
        // Do some customization.
        ......
}
```

## References
* [BinaryMarshaler](https://pkg.go.dev/encoding#BinaryMarshaler)
* [Marshaler](https://pkg.go.dev/encoding/json#Marshaler)
* [Custom JSON Marshalling in Go](https://choly.ca/post/go-json-marshalling/)
* [JSON Tricks: "Slightly" Custom Marshaling](https://boldlygo.tech/posts/2019-12-09-slightly-custom-marshaler/)
* [JSON Tricks: Extending an Embedded Marshaler](https://boldlygo.tech/posts/2020-06-26-go-json-tricks-embedded-marshaler/)
