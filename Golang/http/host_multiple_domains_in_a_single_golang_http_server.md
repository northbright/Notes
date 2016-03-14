# Host Multiple Domains in a Single Golang HTTP Server

To host multiple domains in a single Golang HTTP server, we need to use Host-specific pattern for [ServeMux](https://godoc.org/net/http#ServeMux):

>Patterns may optionally begin with a host name, restricting matches to URLs on that host only. Host-specific patterns take precedence over general patterns, so that a handler might register for the two patterns "/codesearch" and "codesearch.google.com/" without also taking over requests for "http://www.google.com/".

    // For Example:
    func main() {
        http.HandleFunc("a.com/", helloA)
        http.HandleFunc("sub.a.com/", helloSubA)
        http.HandleFunc("b.com/", helloB)

        if err := http.ListenAndServe(":80", nil); err != nil {
            log.Fatal(err)
        }
    }

#### Example
* [go-host-multi-domains-example](https://github.com/northbright/go-host-multi-domains-example)

#### References
* [Go开发网站， 多域名部署问题](https://segmentfault.com/q/1010000000146140)