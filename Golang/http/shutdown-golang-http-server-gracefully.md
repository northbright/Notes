# Shutdown Golang HTTP Server Gracefully

After Go 1.8, we can call [Shutdown](https://godoc.org/net/http#Server.Shutdown) on [http.Server](https://godoc.org/net/http#Server).

#### Example of Wait for Interrupt Signal to Gracefully Shutdown the Server
``` 
package main

import (
        "context"
        "fmt"
        "log"
        "net/http"
        "os"
        "os/signal"
        "time"
)

func main() {
        mux := http.NewServeMux()
        mux.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
                fmt.Fprintf(w, "Hello World!")
        })

        srv := &http.Server{
                Addr:    ":8080",
                Handler: mux,
        }

        go func() {
                log.Printf("starting server...")
                if err := srv.ListenAndServe(); err != nil {
                        log.Printf("ListenAndServe() error: %v", err)
                }
        }()

        // Wait for interrupt signal to gracefully shutdown the server with
        // a timeout of 5 seconds.
        quit := make(chan os.Signal)
        signal.Notify(quit, os.Interrupt)
        <-quit
        ShutdownServer(srv)
}

func ShutdownServer(srv *http.Server) {
        log.Printf("shutdown server...")
        ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
        defer cancel()
        if err := srv.Shutdown(ctx); err != nil {
                log.Printf("shutdown server error", err)
        }
        log.Println("shutdown server successfully")
}

// Output:
// starting server...
// ^C shutdown server...
// shutdown server successfully
```

#### Example of Shutdown HTTP Server after Do a Request
To test HTTP handlers or client request functions, we need to start a server, do a request and then shutdown the server in a single test function.

```
package main

import (
        "context"
        "fmt"
        "io/ioutil"
        "log"
        "net/http"
        "time"
)

func main() {
        mux := http.NewServeMux()
        mux.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
                fmt.Fprintf(w, "Hello World!")
        })

        srv := &http.Server{
                Addr:    ":8080",
                Handler: mux,
        }

        go func() {
                time.Sleep(time.Second)
                doRequest()
                ShutdownServer(srv)
        }()

        log.Printf("starting server...")

        err := srv.ListenAndServe()
        switch err {
        case http.ErrServerClosed:
                log.Printf("server has been closed")
        default:
                log.Printf("ListenAndServe() error: %v", err)
        }
}

func doRequest() {
        req, err := http.NewRequest("GET", "http://localhost:8080", nil)
        if err != nil {
                log.Printf("NewRequest error: %v", err)
                return
        }

        c := &http.Client{}
        resp, err := c.Do(req)
        if err != nil {
                log.Printf("Do() error: %v", err)
                return
        }
        defer resp.Body.Close()

        buf, err := ioutil.ReadAll(resp.Body)
        if err != nil {
                log.Printf("ReadAll() error: %v", err)
                return
        }
        log.Printf("Response: %v", string(buf))
}

func ShutdownServer(srv *http.Server) {
        log.Printf("shutdown server...")
        ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
        defer cancel()
        if err := srv.Shutdown(ctx); err != nil {
                log.Printf("shutdown server error", err)
        }
        log.Println("shutdown server successfully")
}

// Output:

// starting server...
// Response: Hello World!
// shutdown server...
// shutdown server successfully
// server has been closed
```

#### References
* [Graceful restart or stop](https://github.com/gin-gonic/gin#graceful-restart-or-stop)
