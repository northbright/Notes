# Generate HMAC Secret Key for JWT

#### HMAC Secret Key

Since HMAC use [symmetric key algorithm](https://en.wikipedia.org/wiki/Symmetric-key_algorithm), we can just generate random bytes as secret key.

#### Generate Random Bytes in Golang

    func GenSymmetricKey(bits int) (k []byte, err error) {
	    if bits <= 0 || bits%8 != 0 {
		    return nil, errors.New(KeySizeError)
	    }

	    size := bits / 8
	    k = make([]byte, size)
	    if _, err = rand.Read(k); err != nil {
		    return nil, err
	    }

	    return k, nil
    }

#### Go package for generate symmetric key
* <https://github.com/northbright/keygen>

#### References
* [Golang generating a 32 byte key](http://stackoverflow.com/questions/21160258/golang-generating-a-32-byte-key)
* [What are requirements for HMAC secret key?](http://security.stackexchange.com/questions/95972/what-are-requirements-for-hmac-secret-key)
* <https://golang.org/pkg/crypto/rand/#example_Read>
* [github.com/northbright/keygen](https://github.com/northbright/keygen)