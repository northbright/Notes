# Fix the `*http.Request has no field or method Cancel` Issue

#### Description
* We got the error: `type *http.Request has no field or method Cancel`

#### Root Cause
* `Cancel(channel)` is added in `http.Reqeust` since **Go1.5**
  * Go1.5 -- the new `Cancel(channel)` is added in `http.Request`
    <https://github.com/golang/go/blob/release-branch.go1.5/src/net/http/request.go>

             type Request struct {
                 ......
	          // Cancel is an optional channel whose closure indicates that the client
	          // request should be regarded as canceled. Not all implementations of
	          // RoundTripper may support Cancel.
	          //
	          // For server requests, this field is not applicable.
	          Cancel <-chan struct{}
              }

  * Go1.4.3 -- **NO** such `Cancel` field
    <https://github.com/golang/go/blob/release-branch.go1.4/src/net/http/request.go>

* We used old version Go(less than Go1.5, Ex: Go1.4.3)
* Our code(or 3rd party library) accessed `request.Cancel`

#### Solutuion
* Upgrade to Go1.6 :-)
* Use [Build Constraints](https://godoc.org/go/build#hdr-Build_Constraints) for conditional build.
  We can follow  [ctxhttp](https://github.com/golang/net/tree/master/context/ctxhttp) to access `Request.Cancel` for Go1.5 and keep compatible with Go1.4:
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
* [Use Build Constraints for Conditional Build](https://github.com/northbright/Notes/blob/master/Golang/build/use-build-constraints-for-conditional-build.md)
