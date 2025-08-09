# Got "wrong number of fields" Error when using csv.Reader

## Problem
* Convert an XLS to CSV using [xls2csv-go](github.com/northbright/xls2csv-go)
* Got "wrong number of fields" error

## Root Cause
* [FieldsPerRecord](https://pkg.go.dev/encoding/csv#Reader) is not set and it's 0 by default.

  > If FieldsPerRecord is 0, Read sets it to the number of fields in the first record, so that future records must have the same field count.

## Solution
If you want to ignore the check of the number of fields in the records, set [FieldsPerRecord](https://pkg.go.dev/encoding/csv#Reader) to `-1`.

```go
// Create a new CSV reader.
r = csv.NewReader(strings.NewReader(str))

// Use ',' as separator.
r.Comma = ','

// Do not check if records have the same fields count.
r.FieldsPerRecord = -1

// Read CSV records.
records, err = r.ReadAll()
```

## References
* [golang csv wrong number of fields](https://zhuanlan.zhihu.com/p/69868265)
* [csv.Reader](https://pkg.go.dev/encoding/csv#Reader)
