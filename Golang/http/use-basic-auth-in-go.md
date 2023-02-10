# Use Basic Auth in Go


## Example
```
package main

import (
	"log"
	"net/http"
)

func authFailed(w http.ResponseWriter, errMsg string) {
	w.Header().Set("WWW-Authenticate", `Basic realm="restricted", charset="UTF-8"`)
	http.Error(w, errMsg, http.StatusUnauthorized)
}

func basicAuthMiddleware(h func(w http.ResponseWriter, r *http.Request)) func(w http.ResponseWriter, r *http.Request) {
	return func(w http.ResponseWriter, r *http.Request) {
		user, password, ok := r.BasicAuth()
		if !ok {
			authFailed(w, "401 Unauthorized")
			return
		}

		if user != "MY_USER" || password != "MY_PASSWORD" {
			authFailed(w, "Incorrect username or password")
			return
		}

		h(w, r)
	}
}

func helloHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello Wolrd!"))
}

func main() {
	http.HandleFunc("/", basicAuthMiddleware(helloHandler))
	log.Fatal(http.ListenAndServe(":8080", nil))
}
```


## References
* [Go语言HTTP Basic Authorization 实现例子](https://www.jianshu.com/p/a09f1402c285)
* [How to correctly use Basic Authentication in Go](https://www.alexedwards.net/blog/basic-authentication-in-go)
