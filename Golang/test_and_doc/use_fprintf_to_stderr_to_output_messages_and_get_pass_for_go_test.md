# Use Fprintf to stderr to Output Messages and Get Pass for `go test`

We'll get FAIL if the output message from fmt.PrintX() not equals to the messages under `// Output:` in test code.

    // go test will FAIL
    func Example() {
        buf := make([]byte, 8)
        rand.Read(buf)
        // We want to output the random data.
        // It will FAIL because we do not know the random data and can't put it under // Output:
        fmt.Printf("%v", buf)
        // Output:
    }

#### Root Cause
* fmt.PrintX() will output messages to `os.Stderr`:

        func Printf(format string, a ...interface{}) (n int, err error) {
            return Fprintf(os.Stdout, format, a...)
        }
* [stdout will be Captured in Example Functions when Run go test](https://github.com/northbright/Notes/blob/master/Golang/test_and_doc/stdout_will_be_captured_in_example_functions_when_run_go_test.md)

#### Solution

Use `fmt.Fprintf(os.Stderr, "xxx")` to output message to `os.Stderr` and keep empty under `// Output:`

    // go test will PASS
    func Example() {
        buf := make([]byte, 8)
        rand.Read(buf)
        // We want to output the random data.
        // Now we can see the random data and also get PASS.
        fmt.Frintf(os.Stderr, "%v", buf)
        // Output:
    }

#### References:
* [stdout will be Captured in Example Functions when Run go test](https://github.com/northbright/Notes/blob/master/Golang/test_and_doc/stdout_will_be_captured_in_example_functions_when_run_go_test.md)
