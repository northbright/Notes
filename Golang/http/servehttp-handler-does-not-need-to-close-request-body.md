# ServeHTTP Handler does NOT need to Close Request Body

#### See document of [Request](https://godoc.org/net/http#Request)
        type Request {
            ....
      
            // Body is the request's body.
            //
            // For client requests a nil body means the request has no
            // body, such as a GET request. The HTTP Client's Transport
            // is responsible for calling the Close method.
            //
            // For server requests the Request Body is always non-nil
            // but will return EOF immediately when no body is present.
            // The Server will close the request body. The ServeHTTP
            // Handler does not need to.
            Body io.ReadCloser

        }
    
