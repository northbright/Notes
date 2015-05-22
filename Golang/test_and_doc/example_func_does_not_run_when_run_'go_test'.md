
# Example Function does not Run when Run 'go test'

Make sure `// Output:` is added at the end of `ExampleXX()` EVEN you have nothing to output.  

Ex: `mypkg_test.go`:  
 
    package mypkg_test

    func ExampleMyFunc() {
        ....
        // Output:
    }

#### Reference

<https://godoc.org/testing#hdr-Examples>  

Examples  
The package also runs and verifies example code. Example functions may include a concluding line comment that begins with "Output:" and is compared with the standard output of the function when the tests are run. (The comparison ignores leading and trailing space.) These are examples of an example:

    func ExampleHello() {
        fmt.Println("hello")
        // Output: hello
    }

    func ExampleSalutations() {
        fmt.Println("hello, and")
        fmt.Println("goodbye")
        // Output:
        // hello, and
        // goodbye
    }