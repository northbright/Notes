# Read CSV File in Go

## Solution
Use [encoding/csv](https://pkg.go.dev/encoding/csv) package

## Example

```
import (
        "encoding/csv"
        "os"
)

// ReadFile reads CSV file and return CSV records.
func ReadFile(f string) ([][]string, error) {
        reader, err := os.Open(f)
        if err != nil {
                return [][]string{}, err
        }
        defer reader.Close()

        // Create a new CSV reader.
        r := csv.NewReader(reader)
        return r.ReadAll()
}
```
