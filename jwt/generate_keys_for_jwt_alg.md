# Generate Keys for JWT algs


#### `"HS256"`,`"HS384"`, `"HS512"`(HMAC using SHA-256 / 384 / 512 hash alg):
* It's a symmetric key alogrithm.
* Signing key is the same as verifying key.
* Key Generation:
  * It's ok to use random bytes as the secret key.
  * [Generate HMAC Secret Key for JWT](https://github.com/northbright/Notes/blob/master/jwt/generate_hmac_secret_key_for_jwt.md)
* Key size:
  * key size(bits) >= SHA-2 digist bits(SHA-XXX)
  * Ex: 512 bits for SHA-512

#### `"RS256"`, `"RS384"`, `"RS512"`(RSASSA-PKCS-v1_5 using SHA-256 / 384 / 512 hash alg):
* Key Generation:
  * Create Private Key

            openssl genrsa -out "rsa_2048_priv.pem" 2048

  * Extract Public Key

            openssl rsa -in "rsa_2048_priv.pem" -pubout -out "rsa_2048_pub.pem"
* Key Size:
  * 2048 bits

#### `"PS256"`, `"PS384"`, `"PS512"`(RSASSA-PSS using SHA-256 / 384 / 512 hash and and MGF1 mask generation function with SHA-256 / 384 / 512 alg):
* Key Generation:  
  The same as `"RSxxx"`.

#### `"ES256"`, `"ES384"`, `"ES512"`(ECDSA using P-256 / P-384 / P-521 curve and SHA-256 / 384 / 512 hash algorithm):
* Key Generation:
  * List support curves of current openssl
  
            openssl ecparam -list_curves
            secp384r1 : NIST/SECG curve over a 384 bit prime field
            secp521r1 : NIST/SECG curve over a 521 bit prime field
            prime256v1: X9.62/SECG curve over a 256 bit prime field

  * Choose One Curve to Create Private Key in PEM Format

            // -name <curve in the list>
            openssl ecparam -genkey -name prime256v1 -noout -out ecdsa_256_private.pem

  * Extract Public Key in Private Key

            openssl ec -in ecdsa_256_private.pem -pubout -out ecdsa_256_pub.pem

#### References
* [Generate HMAC Secret Key for JWT](https://github.com/northbright/Notes/blob/master/jwt/generate_hmac_secret_key_for_jwt.md)
* [How to Use openssl to Generate ECDSA Keys](https://github.com/northbright/Notes/blob/master/crypto/how_to_use_openssl_to_generate_ecdsa_keys.md)