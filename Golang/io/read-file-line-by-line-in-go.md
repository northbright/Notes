# Read File Line by Line in Go

#### Example

    package main

    import (
        "fmt"
        "os"
        "bufio"
    )

    func main() {
        f, err := os.Open("~/1.txt")
        if err != nil {
            return
        }
        defer f.Close()

        scanner := bufio.NewScanner(f)
        for scanner.Scan() {
            fmt.Println(scanner.Text())
        }

        if err = scanner.Err(); err != nil {
            fmt.Printf("scanner error: %v\n", err)
        }
    }

#### References
* [Example (Lines)](https://godoc.org/bufio#example-Scanner--Lines)
* [reading file line by line in go](https://stackoverflow.com/questions/8757389/reading-file-line-by-line-in-go)

