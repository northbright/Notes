# JWT Algorithm Key Sizes

#### HMAC using SHA-256/384/512

Key size(bits) should >= SHA-XXX(bits).

Ex:   
HS256(HMAC SHA-256):  
Key size: 256 bits(32 bytes)

#### RSA using SHA-256/384/512

All "RSXXX" Key size should larger than 2048 bits.

`ssh-keygen -t rsa -b 2048`

#### ECDSA using p-256/384/521 curve and SHA-256/384/512

Key size(bits): 256/384/**521**(not 512)

`ssh-keygen -t ecdsa -b 256/384/521`


#### Alg Claim Value - Algorithm Table

| Alg Claim Value | Algorithm |
| --------------- | ---------- |
| HS256	| HMAC using SHA-256 hash algorithm |
| HS384	| HMAC using SHA-384 hash algorithm |
| HS512	| HMAC using SHA-512 hash algorithm |
| RS256	| RSA using SHA-256 hash algorithm |
| RS384	| RSA using SHA-384 hash algorithm |
| RS512	| RSA using SHA-512 hash algorithm |
| ES256	| ECDSA using P-256 curve and SHA-256 hash algorithm |
| ES384	| ECDSA using P-384 curve and SHA-384 hash algorithm |
| ES512	| ECDSA using P-521 curve and SHA-512 hash algorithm |

#### References
* [HMAC-SHA-256+ Parameter Summary](https://tools.ietf.org/html/rfc4868)
* [7. Signing JWTs with Cryptographic Algorithms](http://self-issued.info/docs/draft-goland-json-web-token-00.html)
* [Signing a JWT with RSA SHA-256](http://self-issued.info/docs/draft-jones-json-web-token-01.html#DefiningRSA)