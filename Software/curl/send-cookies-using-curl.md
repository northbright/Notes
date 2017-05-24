# Send Cookies in CURL

#### Solution
* Use `--cookie "key=value` option.

#### Example

    // Send one cookie key-value pair.
    curl -v -X GET http://xx.com --cookie "SESSION_ID=xx"

    // Send multiple cookies key-values pairs.
    curl -v -X GET http://xx.com --cookie "k1=v1;k2=v2"

#### References
* [Curl with Cookies and Headers](http://joelpm.com/curl/tools/2010/06/17/curl-with-cookies-and-headers.html)
* [curl: how to send cookies via command line?](https://stackoverflow.com/questions/15995919/curl-how-to-send-cookies-via-command-line)
