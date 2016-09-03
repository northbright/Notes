# len() Gets the Number of Bytes in the String

The builtin len() function gets the number of bytes in the given string. 

#### Example

* It'll start an HTTP server.

* This HTTP server accepts user input(UTF-8 string) and output the length in bytes of the UTF-8 string.

<pre><code>

package main

import (
        "fmt"
        "log"
        "net/http"
)

// hello() is home handler.
func hello(w http.ResponseWriter, r *http.Request) {
        if r.URL.Path != "/" {
                http.Error(w, "404 not found.", http.StatusNotFound)
                return
        }

        switch r.Method {
        case "GET":
                fmt.Fprintf(w, htmlStr)
        case "POST":
                // Get UTF-8 string from client
                s := r.FormValue("key")
                // len() gets the number of bytes in the UTF-8 string. Each Chinese UTF-8 character takes 3 bytes.
                // default: len("Hello, 世界") = 7 + 3 * 2 = 13
                fmt.Fprintf(w, "key = %s, len = %v\n", s, len(s))
        }
}

func main() {
        // Index Handler
        http.HandleFunc("/", hello)

        fmt.Printf("Starting server for testing HTTP POST...\n")
        if err := http.ListenAndServe(":80", nil); err != nil {
                log.Fatal(err)
        }
}

var htmlStr string = `
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
</head>
<body>
  <div>
      <form method="POST" action="/">
          <input name="post_from" type="hidden" value="web" >
          <input name="key" type="text" value="Hello, 世界">
          <input type="submit" value="submit" />
      </form>
  </div>
</body>
</html>

</code></pre>
