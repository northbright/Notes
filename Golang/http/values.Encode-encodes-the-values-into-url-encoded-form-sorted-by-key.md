# Values.Encode() Encodes the Values into “URL encoded” Form Sorted by Key

#### Example Code

        // Add form data
        v := url.Values{}
        v.Add("o", "omega")
        v.Add("b", "beta")
        v.Add("z", "zeta")
        v.Add("a", "alpha")
        v.Add("g", "gamma")
        v.Add("ch", "chip china cheap")
        v.Add("中", "中文 中国 中心")

        // Values.Encode() encodes the values into "URL encoded" form sorted by key.
        s := v.Encode()
        fmt.Printf("v.Encode(): %v\n", s)

        // Output:
        // v.Encode(): a=alpha&b=beta&ch=chip+china+cheap&g=gamma&o=omega&z=zeta&%E4%B8%AD=%E4%B8%AD%E6%96%87+%E4%B8%AD%E5%9B%BD+%E4%B8%AD%E5%BF%83

#### References
* [go-post-example](https://github.com/northbright/go-post-example)
* [Make a URL-encoded POST request using http.NewRequest()](http://stackoverflow.com/questions/19253469/make-a-url-encoded-post-request-using-http-newrequest)
