# Wrong Implementation of `json.Marshaler` Interface Cause Stackoverflow

## Problem
* Type Task Implements [json.Marshaler](https://pkg.go.dev/encoding/json#Marshaler) Interface

  ```
  type Task struct {
      Dst string `json:"dst"`
      Src string `json:"src"`
      ......
  }

  func (t *Task) MarshalJSON() ([]byte, error) {
      // Just call json.Marshal() on t
      return json.Marshal(t)
  }
  ```

* The Program Encounters a Fatal Error: Stackoverflow at `task.MarshalJSON()`

## Root Cause
[`json.Marshal`](https://pkg.go.dev/encoding/json#Marshal) doc says:
> Marshal traverses the value v recursively. If an encountered value implements Marshaler and is not a nil pointer, Marshal calls [Marshaler.MarshalJSON] to produce JSON.

Use `json.Marshal() on a value to implement `json.Marshaler` interface for value's type will cause an infinite loop.

## Solution
Use `json.Marshal()` on a value to implement [`encoding.BinaryMarshaler`](https://pkg.go.dev/encoding#BinaryMarshaler) is OK.

```
func (t *Task) MarshalBinary() ([]byte, error) {
    return json.Marshal(t)
}
```

## References
* [BinaryMarshaler](https://pkg.go.dev/encoding#BinaryMarshaler)
* [Marshaler](https://pkg.go.dev/encoding/json#Marshaler)
