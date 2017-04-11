# Get Host Info of Server-Side HTTP Request in http.Handler

#### Problem
* `Host` of [http.Request](https://godoc.org/net/http#Request).`URL` is empty for Server Side Requests.

#### Root Cause
* For most server requests, fields other than `Path` and `RawQuery` of URL is **EMPTY**.

    type Request struct {
        ...
 
        // URL specifies either the URI being requested (for server
        // requests) or the URL to access (for client requests).
        //
        // For server requests the URL is parsed from the URI
        // supplied on the Request-Line as stored in RequestURI.  For
        // most requests, fields other than Path and RawQuery will be
        // empty. (See RFC 2616, Section 5.1.2)
        //
        URL *url.URL
        ...
    }

#### Solution
* Use `Host` of [http.Request](https://godoc.org/net/http#Request).

    type Request struct {
        ...

        // For server requests Host specifies the host on which the
        // URL is sought. Per RFC 2616, this is either the value of
        // the "Host" header or the host name given in the URL itself.
        // It may be of the form "host:port". For international domain
        // names, Host may be in Punycode or Unicode form. Use
        // golang.org/x/net/idna to convert it to either format if
        // needed.
        //
        Host string 
        ...
    }

#### References
* [Why are request.URL.Host and Scheme blank in the development server?](http://stackoverflow.com/questions/6899069/why-are-request-url-host-and-scheme-blank-in-the-development-server)
