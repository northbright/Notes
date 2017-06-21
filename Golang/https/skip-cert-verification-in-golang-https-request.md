# Skip Cert Verification in Golang HTTPS Request

#### Solution
* Set `InsecureSkipVerify` to `true` in [tls.Config](https://godoc.org/crypto/tls#Config)

#### Example

        tr := &http.Transport{
                TLSClientConfig: &tls.Config{InsecureSkipVerify: true},
        }
        client := &http.Client{Transport: tr}

        resp, err := client.Do(req)

#### References
* [golang: How to do a https request with bad certificate?](https://stackoverflow.com/questions/12122159/golang-how-to-do-a-https-request-with-bad-certificate)
