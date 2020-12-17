# http.ResponseWriter will Call WriteHeader(http.StatusOK) Automatically after First Call of Write()

## See [ResponseWriter](https://godoc.org/net/http#ResponseWriter)

```
    // WriteHeader sends an HTTP response header with the provided
    // status code.
    //
    // If WriteHeader is not called explicitly, the first call to Write
    // will trigger an implicit WriteHeader(http.StatusOK).
```
