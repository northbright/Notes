# Calling Round Trip to Ignore Redirects when Do HTTP Request in Golang

#### Problem
* Default [http.Client](https://godoc.org/net/http#Client) is is higher-level than a RoundTripper (such as Transport) and additionally handles HTTP details such as cookies and **redirects**.
* We need to ignore redirects and get the first response headers.

#### Solution
* Use [http.DefaultTransport](https://github.com/golang/go/blob/bdf746caaa23ccf2bc7b7e2e123349133ce001a6/src/net/http/transport.go#L40)'s `RoundTrip`:

        var DefaultTransport RoundTripper = &Transport{
                Proxy: ProxyFromEnvironment,
                DialContext: (&net.Dialer{
                        Timeout:   30 * time.Second,
                        KeepAlive: 30 * time.Second,
                        DualStack: true,
                }).DialContext,
                MaxIdleConns:          100,
                IdleConnTimeout:       90 * time.Second,
                TLSHandshakeTimeout:   10 * time.Second,
                ExpectContinueTimeout: 1 * time.Second,
        }

#### Example

        resp, err := http.DefaultTransport.RoundTrip(req)
        fmt.Printf("resp.Header: %v\n", resp.Header)

#### References
* [Not getting Location header from Golang http request](http://stackoverflow.com/questions/38602740/not-getting-location-header-from-golang-http-request)
