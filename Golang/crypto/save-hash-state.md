# Save Hash State

## Problem
* Want to save / restore the state of hash function
* Use the state to pause / resume computing hash checksum.

## Solution
* Hash implementations in the standard library (e.g. hash/crc32 and crypto/sha256) implement the encoding.BinaryMarshaler and encoding.BinaryUnmarshaler interfaces.
* See [hash.Hash](https://godoc.org/hash#Hash) for more information.

## Example Code
* [save-hash-state-example](https://github.com/northbright/save-hash-state-example)

## References
* [hash.Hash](https://godoc.org/hash#Hash)
* [encoding](https://godoc.org/encoding)
* [crypto/md5](https://github.com/golang/go/blob/dev.boringcrypto.go1.14/src/crypto/md5/md5.go#L38)
