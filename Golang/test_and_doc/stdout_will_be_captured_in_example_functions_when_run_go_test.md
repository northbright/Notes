
# stdout will be Captured in Example Functions when Run `go test`

`go/src/testing/example.go:`  

    func runExample(eg InternalExample) (ok bool) {
        ......

        // Capture stdout.
        stdout := os.Stdout
        r, w, err := os.Pipe()
        if err != nil {
            fmt.Fprintln(os.Stderr, err)
            os.Exit(1)
        }
        os.Stdout = w  // os.Stdout is captured
        outC := make(chan string)
        go func() {
            buf := new(bytes.Buffer)
            _, err := io.Copy(buf, r)
            r.Close()
            ......
            outC <- buf.String()  // wait for string copied from stdout
        }()

        ......

        // Clean up in a deferred call so we can recover if the example panics.
        defer func() {
            ......

            // Close pipe, restore stdout, get output.
            w.Close()
            os.Stdout = stdout  // restore stdout
            out := <-outC  // wait and get output

            var fail string
            err := recover()
            // --------------------------------------------------------------------------------------------
            // g = got from captured os.Stdout, e = expected output from // output: at the end of example
            // --------------------------------------------------------------------------------------------
            if g, e := strings.TrimSpace(out), strings.TrimSpace(eg.Output); g != e && err == nil {
                fail = fmt.Sprintf("got:\n%s\nwant:\n%s\n", g, e)
            }
            if fail != "" || err != nil {
                fmt.Printf("--- FAIL: %s (%s)\n%s", eg.Name, dstr, fail)
                ok = false
            } else if *chatty {
                fmt.Printf("--- PASS: %s (%s)\n", eg.Name, dstr)
            }
            ......
        }

        // Run example.
        eg.F()  // all output to os.Stdout will be captured
        return
    }
