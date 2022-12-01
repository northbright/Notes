# Find if Range is Supported by the Server

## Solution
* Do HTTP request with `HEAD` method
* Check if `Accept-Ranges` of response header equals to `bytes`

## Example
* See [ContentLength](https://pkg.go.dev/github.com/northbright/httputil#ContentLength)

```
const (
        keyAcceptRanges  = "Accept-Ranges"
        keyContentLength = "Content-Length"
)

var (
        // ErrNot200or206 represents the error that the status code is not 200 or 206.
        ErrNot200or206 = errors.New("status code is not 200 or 206")
)

// ContentLength returns the length of content and if range is supported by the server on the URL.
func ContentLength(url string) (int64, bool, error) {
        // Do HTTP request with HEAD method(without body)
        resp, err := http.Head(url)
        if err != nil {
                return 0, false, err
        }
        defer resp.Body.Close()

        // Check if status code is 200 or 206.
        if resp.StatusCode != 200 && resp.StatusCode != 206 {
                return 0, false, ErrNot200or206
        }

        supported := false
        if resp.Header.Get(keyAcceptRanges) == "bytes" {
                supported = true
        }

        lenth, _ := strconv.ParseInt(resp.Header.Get(keyContentLength), 10, 64)

        return lenth, supported, nil
}
```
