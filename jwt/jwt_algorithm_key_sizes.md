# JWT Algorithm Key Sizes

#### HMAC

Key size(bits) should >= the output length(bits).

Ex:   
HS256(HMAC SHA-256):  
Key size: 256 bits(32 bytes)

#### RSA

All "RSXXX" Key size should larger than 2048 bits.

`ssh-keygen -t rsa -b 2048`


#### References
* [HMAC-SHA-256+ Parameter Summary](https://tools.ietf.org/html/rfc4868)
* [Signing a JWT with RSA SHA-256](http://self-issued.info/docs/draft-jones-json-web-token-01.html#DefiningRSA)