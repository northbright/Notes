
# How to Use openssl to Generate ECDSA Keys

#### Steps

* List support curves of current openssl

        // Centos 7.0
        // OpenSSL 1.0.1e-fips 11 Feb 2013

        openssl ecparam -list_curves
        secp384r1 : NIST/SECG curve over a 384 bit prime field
        secp521r1 : NIST/SECG curve over a 521 bit prime field
        prime256v1: X9.62/SECG curve over a 256 bit prime field

* Choose One Curve to Create Private Key in PEM Format

        // -name <curve in the list>
        openssl ecparam -genkey -name prime256v1 -noout -out ecdsa_256_private.pem

* Extract Public Key in Private Key

        // Extract the public key from private key.
        openssl ec -in ecdsa_256_private.pem -pubout -out ecdsa_256_pub.pem

#### References
* [ECDSA asymmetric Key with OpenSSL](http://sundaycoding.blogspot.com/2012/06/ecdsa-asymetric-key-with-openssl.html)
* [ECDSA: The digital signature algorithm of a better internet](https://blog.cloudflare.com/ecdsa-the-digital-signature-algorithm-of-a-better-internet/)