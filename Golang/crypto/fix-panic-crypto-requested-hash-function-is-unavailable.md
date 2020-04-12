# Fix `panic: crypto: requested hash function is unavailable`

## Problem
* Create [crypto.Hash](https://godoc.org/crypto#Hash) with the value of [crypto.MD5](https://github.com/golang/go/blob/release-branch.go1.14/src/crypto/crypto.go#L25)
  ```
  // Hash identifies a cryptographic hash function that is implemented in another
  // package.
  type Hash uint

  const (
	MD4         Hash = 1 + iota // import golang.org/x/crypto/md4
	MD5                         // import crypto/md5
	SHA1                        // import crypto/sha1
        ......
  )
    
  ```
* Call New() to create a md5 [hash.Hash](https://godoc.org/hash#Hash)
* Got error message:

  ```
  panic: crypto: requested hash function #2 is unavailable
  ```

## Example Code
```
package main

import (
        "crypto"
        "fmt"
)

func main() {
        buf := []byte("Hello World!")

        h := crypto.MD5.New()
        fmt.Printf("MD5 of 'Hello World!' is: %X\n", h.Sum(buf))
}

```

## Root Cause
* [New](https://godoc.org/crypto#Hash.New) panics if hash function is not linked

  ```
  // New returns a new hash.Hash calculating the given hash function. New panics
  // if the hash function is not linked into the binary.
  ```

## Solution
* import [crypto/md5](https://godoc.org/crypto/md5)
* It'll register MD5 at [init](https://github.com/golang/go/blob/release-branch.go1.14/src/crypto/md5/md5.go#L20) function

## Fixed Example Code
```
package main

import (
        "crypto"
        _ "crypto/md5"
        "fmt"
)

func main() {
        buf := []byte("Hello World!")

        h := crypto.MD5.New()
        fmt.Printf("MD5 of 'Hello World!' is: %X\n", h.Sum(buf))
}

```
