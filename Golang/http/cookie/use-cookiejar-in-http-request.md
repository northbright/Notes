# Use cookiejar in HTTP Request

[cookiejar](https://pkg.go.dev/net/http/cookiejar) writes cookies in memory and auto add cookies to a request when do HTTP request.

## Example
```go
package main

import (
	"fmt"
	"net/http"
	"net/http/cookiejar"
)

func main() {
	u := "https://bing.com"

	req, _ := http.NewRequest("GET", u, nil)
	req.Header.Add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36 Edg/118.0.2088.76")

	jar, _ := cookiejar.New(nil)

	c := http.Client{Jar: jar}

	resp, err := c.Do(req)
	if err != nil {
		fmt.Println("c.Do(req) error", err)
		return
	}
	defer resp.Body.Close()
	fmt.Printf("\n------ resp.Header ------\n%v\n", resp.Header)

	cookies := jar.Cookies(resp.Request.URL)

	fmt.Printf("\n------ Cookies ------\n")
	for _, cookie := range cookies {
		fmt.Printf("Cookie: %s=%s\n", cookie.Name, cookie.Value)
	}

    // Output:
    // ------ resp.Header ------
    // map[Accept-Ch:[Sec-CH-UA-Arch, Sec-CH-UA-Bitness, Sec-CH-UA-Full-Version, Sec-CH-UA-Full-Version-List, Sec-CH-UA-Mobile, Sec-CH-UA-Model, Sec-CH-UA-Platform, Sec-CH-UA-Platform-Version]
    // ......
    ------ Cookies ------
    // Cookie: MUID=XXXX
    // Cookie: MUIDB=XXXX
    // Cookie: _EDGE_V=1
    // ......
}
```

## References
* [golang关于cookiejar用法的疑问](https://segmentfault.com/q/1010000010339661)
* [纯golang爬虫实战－（六）－关于cookiejar的理解 (2020-02-14 13:50)](https://www.cnblogs.com/pu369/p/12318490.html)
