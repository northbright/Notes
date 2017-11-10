# url.Values(package [net/url](https://godoc.org/net/url)) Should be Initialized Before Use

[url.Values](https://godoc.org/net/url#Values) is a map:

    type Values map[string][]string

It should be initialized before use or will cause nil map error when access the map:

    v := url.Values{}
    v.Set("name", "Jack")
    v.Set("id", "10")
    
#### References
* [Values](https://godoc.org/net/url#Values)
