# Read Multiple Times from the Same io.Reader

## Problem
Need to read(decode) JSON data stream 2 times from the io.Reader
* 1st time: only need to read / decode the category data
* 2nd time: create the data type corresponding to the category and read / decode the JSON data again

## Solution
Use [io.TeeReader](https://pkg.go.dev/io#TeeReader) to duplicate the stream.

## Example
* [decode-json-from-same-reader-2-times](https://github.com/northbright/decode-json-from-same-reader-2-times)

## References
* [How to read multiple times from same io.Reader](https://stackoverflow.com/questions/39791021/how-to-read-multiple-times-from-same-io-reader)
