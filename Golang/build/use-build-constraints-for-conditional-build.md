# Use Build Constraints for Conditional Build

A build constraint, also known as a build tag, is a line comment that begins

    // +build

#### Conditional Build for Different Go Versions
* We can follow  [ctxhttp](https://github.com/golang/net/tree/master/context/ctxhttp) to access `Request.Cancel` for Go1.5 and keep compatible with Go1.4:
  * [cancelreq.go](https://github.com/golang/net/blob/master/context/ctxhttp/cancelreq.go)(>= Go1.5)

            // +build go1.5

            package ctxhttp

            import "net/http"

            func canceler(client *http.Client, req *http.Request) func() {
	        // TODO(djd): Respect any existing value of req.Cancel.
	            ch := make(chan struct{})
	            req.Cancel = ch

	            return func() {
		            close(ch)
	            }
            }

  * [cancelreq_go14.go](https://github.com/golang/net/blob/master/context/ctxhttp/cancelreq_go14.go)(< Go1.5)

            // +build !go1.5

            package ctxhttp

            import "net/http"

            type requestCanceler interface {
	            CancelRequest(*http.Request)
            }

            func canceler(client *http.Client, req *http.Request) func() {
	            rc, ok := client.Transport.(requestCanceler)
	            if !ok {
		            return func() {}
	            }
	            return func() {
		            rc.CancelRequest(req)
	            }
	        }

#### References
* [Build Constraints](https://godoc.org/go/build#hdr-Build_Constraints)
* <https://github.com/golang/go/blob/master/src/go/build/build.go>



