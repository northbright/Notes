# Use Type Assertion to Convert an Interface to Other Interfaces

## Problem
* `crypto/md5`'s [digest](https://github.com/golang/go/blob/dev.boringcrypto.go1.14/src/crypto/md5/md5.go#L38) implements both [hash.Hash](https://godoc.org/hash#Hash) interface and [encoding.BinaryMarshaler](https://godoc.org/encoding#BinaryMarshaler) / [encoding.BinaryUnmarshaler](https://godoc.org/encoding#BinaryUnmarshaler)

  > Hash implementations in the standard library (e.g. hash/crc32 and crypto/sha256) implement the encoding.BinaryMarshaler and encoding.BinaryUnmarshaler interfaces.

* Created a `hash.Hash` from `crypto.MD5`([crypto.Hash](https://godoc.org/crypto#Hash))

  ```
  import (
      "crypto"
      _ "crypto/md5"
  )

  ......
  // New() creates a hash.Hash
  hash := crypto.MD5.New()
  ```

* Call `Hash.Write` to write data

  ```
  hash.Write(buf)
  ```

* Want to pause the hash and save the state using `MarshalBinary`(`encoding.BinaryMarshaler`) and got error:

  ```
  // error: not implement encoding.BinaryMarshaler interface
  buf, err := hash.MarshalBinary()
  ```

## Root Cause
* `hash.Hash` interface is NOT `encoding.BinaryMarshaler` interface

## Solution
* Use type assetion to convert `hash.Hash` interface to `encoding.BinaryMarshaler` interface
  
  ```
  m := hash.(encoding.BinaryMarshaler)
  buf, err := m.MarshalBinary()
  ```
## Example
* [save-hash-state-example](https://github.com/northbright/save-hash-state-example)
