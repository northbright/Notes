# Create UUID with go

We can use `crypto/rand` to create pseudo uuid.

    // New() creates pseudo uuid.
    func New() (uuid string, err error) {
        b := make([]byte, 16)

        _, err = rand.Read(b)
        if err != nil {
            fmt.Printf("rand.Read() err: %v", err)
            return "", err
        }
        uuid = fmt.Sprintf("%x-%x-%x-%x-%x", b[0:4], b[4:6], b[6:8], b[8:10], b[10:])
        return uuid, nil
    }

#### Sample Repository
* <https://github.com/northbright/uuid>

#### References
* <http://stackoverflow.com/questions/15130321/is-there-a-method-to-generate-a-uuid-with-go-language>