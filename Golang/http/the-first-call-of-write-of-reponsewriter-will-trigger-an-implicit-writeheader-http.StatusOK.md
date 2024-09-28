# The First Call of Write of ReponseWriter will Trigger an Implicit WriteHeader(http.StatusOK)

In the comments of [ResponseWriter](https://pkg.go.dev/net/http#ResponseWriter):

> If WriteHeader is not called explicitly, the first call to Write
> will trigger an implicit WriteHeader(http.StatusOK).

You may find the source code in [write](https://github.com/golang/go/blob/go1.23.1/src/net/http/server.go#L1673):

```go
func (w *response) write(lenData int, dataB []byte, dataS string) (n int, err error) {

    ......

	if !w.wroteHeader {
		w.WriteHeader(StatusOK)
	}
```

w.WriteHeader calls [writeStatusLine](https://github.com/golang/go/blob/go1.23.1/src/net/http/server.go#L1604C1-L1619C2) to write the status header:

```go
func writeStatusLine(bw *bufio.Writer, is11 bool, code int, scratch []byte) {
	if is11 {
		bw.WriteString("HTTP/1.1 ")
	} else {
		bw.WriteString("HTTP/1.0 ")
	}
	if text := StatusText(code); text != "" {
		bw.Write(strconv.AppendInt(scratch[:0], int64(code), 10))
		bw.WriteByte(' ')
		bw.WriteString(text)
		bw.WriteString("\r\n")
	} else {
		// don't worry about performance
		fmt.Fprintf(bw, "%03d status code %d\r\n", code, code)
	}
}
```

## References
* <https://pkg.go.dev/net/http#ResponseWriter>
* [write](https://github.com/golang/go/blob/go1.23.1/src/net/http/server.go#L1673)
* [writeStatusLine](https://github.com/golang/go/blob/go1.23.1/src/net/http/server.go#L1604C1-L1619C2)
