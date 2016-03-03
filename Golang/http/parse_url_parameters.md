# Parse URL parameters

## Problem
* How can we get the value of named component of the query without using 3rd party libraries / packages?
* Ex: `http://mydomain.com/?name1=value1&name2=value2`

## Solution
* Use [Request.FormValue()](https://godoc.org/net/http#Request.FormValue)
* Example:

        // URL query: "http://mydomain.com/?id=xx&data=xx"
        func myHandler(w http.ResponseWriter, r *http.Request) {
            id := r.FormValue("id")
            data := r.FormValue("data")
            ......
        }

## References
* [golang如何获取url参数](http://www.golangtc.com/t/51ee76fe320b5279cb000005)