# Send Cookies in CURL

## Solution
Use `--cookie` or `-b` option.

## Example

* Do request and save cookies to a file on disk.

```bash
curl -X POST localhost:8080/login -d '{"user":"xx","password":"xx"}' -c ~/my_cookie.txt
```

* Do request with the cookies saved in the file.

```bash
curl -X GET -b ~/my_cookie.txt localhost:8080/is-logged-in
```

* Send one cookie key-value pair.

```bash  
curl -v -X GET http://xx.com --cookie "SESSION_ID=xx"
```

* Send multiple cookies key-values pairs.

```bash
curl -v -X GET http://xx.com --cookie "k1=v1;k2=v2"
```

## References
* [Curl with Cookies and Headers](http://joelpm.com/curl/tools/2010/06/17/curl-with-cookies-and-headers.html)
* [curl: how to send cookies via command line?](https://stackoverflow.com/questions/15995919/curl-how-to-send-cookies-via-command-line)
