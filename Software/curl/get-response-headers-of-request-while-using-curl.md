# Get Response Headers of the Request while Using CURL

#### Solution
* Use `-D -` to output response headers to stdout.

        curl -X POST http://xx.com -H "Content-Type:application/x-www-form-urlencoded" -d "p=1&d=2" -D -

* Use `-D <file>` to write response headers to specified file.

        curl -X POST http://xx.com -H "Content-Type:application/x-www-form-urlencoded" -d "p=1&d=2"
-D ~/headers.txt

#### References
* [Getting only response header from HTTP POST using curl](http://stackoverflow.com/questions/10060098/getting-only-response-header-from-http-post-using-curl)

