# Hasing 0-Byte File is Allowed

All hash algorithms in Quick Hash(MD5, SHA1, SHA2...) can hash messages of any length include 0.

See [this answer of](https://superuser.com/questions/557925/how-can-zero-byte-files-generate-a-hash-value/557942#557942) [How can zero byte files generate a hash value?](https://superuser.com/questions/557925/how-can-zero-byte-files-generate-a-hash-value) for more information

> All hash algorithms in Quick Hash are Merkle–Damgård constructions. As such, they pad the message to a multiple of the block size.

  Quick Hash's algorithms achieve this by appending a 1 bit, as many 0 bits as needed, and finally the message length.

  This allows hashing messages of arbitrary length, including zero-length messages.

## References
*  [How can zero byte files generate a hash value?](https://superuser.com/questions/557925/how-can-zero-byte-files-generate-a-hash-value)
