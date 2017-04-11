# Customize [gin](https://github.com/gin-gonic/gin) `LoggerWithWriter` to add Host Info

#### Probem

* Our HTTP server is built on [gin](https://github.com/gin-gonic/gin) 
* After it's online only 1 minute, there're **lots** of HTTP requests(**NOT** in our router) came in:

        Apr 11 13:04:55  xx gb: [GIN] 2017/04/11 - 13:04:55 | 404 #033[0m|       1.598µs |     40.77.167.137 |  GET #033[0m    /index.php/project/list-4-1.html
        Apr 11 13:04:56  xx gb: [GIN] 2017/04/11 - 13:04:56 | 404 #033[0m|       1.503µs | 40.77.167.137 |  GET #033[0m    /index.php/project/index.html
        Apr 11 13:04:57  xx gb: [GIN] 2017/04/11 - 13:04:57 | 404 #033[0m|        1.76µs | 122.240.204.103 |  GET #033[0m    /m/mquser/getloginvalidateCode
        Apr 11 13:05:01  xx gb: [GIN] 2017/04/11 - 13:05:01 | 404 #033[0m|       1.616µs | 121.35.201.131 |  GET #033[0m    /m/mquser/getloginvalidateCode

* We want to get the Host of these HTTP request to find out the problem but gin only show us the relative URL path.

#### Solution
* We need to use `Host` of [http.Request](https://godoc.org/net/http#Request) to get host info.
* Modify [logger.go](https://github.com/gin-gonic/gin/blob/master/logger.go) and add host info in `LoggerWithWriter`:
    
    * `cd $GOPATH/src/github.com/gin-gonic/gin`

    * `vi logger.go`
    
            func LoggerWithWriter(out io.Writer, notlogged ...string) HandlerFunc {
                ......
                return func(c *Context) {
                    ......
                    path := c.Request.URL.Path
                    // Get host info
                    host := c.Request.Host
                    ......
                    fmt.Fprintf(out, "[GIN] %v |%s %3d %s| %13v | %s |%s  %s %-7s %s%s\n%s",
                        end.Format("2006/01/02 - 15:04:05"),
                        statusColor, statusCode, reset,
                        latency,
                        clientIP,
                        methodColor, method, reset,
                        // Add host Info here
                        host,
                        path,
                        comment,
                    )
                    ......
* Re-build and Re-install [gin](https://github.com/gin-gonic/gin) 
    * go build
    * go install

* Re-build Our App

* Test logger output:

        curl 192.168.1.40/xx
        curl 192.168.1.40/yy

        [GIN-debug] Listening and serving HTTP on :80
        [GIN] 2017/04/11 - 02:58:33 | 401 |       7.524µs | 192.168.1.40 |  GET     192.168.1.40/xx
        [GIN] 2017/04/11 - 02:58:40 | 200 |     537.742µs | 192.168.1.40 |  GET     192.168.1.40/yy
        
#### Root Cause
* The IP of the new server we've bought from [aliyun](aliyun.com) has been used by another custom previously.
* This custom has a DOMAIN(example.com) and its A record still pointer to the IP while they does not own the server(IP) any more.
* This custom deployed some CRM and client apps.
* The client apps are still used by some people and send the HTTP requests to the server(this IP). 

#### References
* [Why are request.URL.Host and Scheme blank in the development server?](http://stackoverflow.com/questions/6899069/why-are-request-url-host-and-scheme-blank-in-the-development-server)
* [Get Host Info of Server-Side HTTP Request in http.Handler](https://github.com/northbright/Notes/blob/master/Golang/http/get-host-info-of-server-side-http-request-in-http-handler.md)


