
# Concatenate String in Go

Use `bytes.Buffer.WriteString()` can be more faster than `+=`

    package main

    import (
        "fmt"
        "bytes"
        "io/ioutil"
    )

    func main () {
        var buffer bytes.Buffer
        for i := 0; i < 1000; i++ {
            buffer.WriteString("a\n")
        }

        fmt.Printf("%s\n", buffer.String())

        // or write to file
        err := ioutil.WriteFile("xx.txt", buffer.Bytes(), 0777)
    }
References:  

1. <http://stackoverflow.com/questions/1760757/how-to-efficiently-concatenate-strings-in-go>
2. <http://golang-examples.tumblr.com/post/86169510884/fastest-string-contatenation>
