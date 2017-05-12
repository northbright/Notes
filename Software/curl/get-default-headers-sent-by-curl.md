# Get Default Headers Sent by CURL

#### Problem
* We want to see default headers sent by CURL


#### Solution
* Use `-v` to show more information.

        curl -v -X POST http://xx.com -d "p=1&d=2" -D -

        // Default Headers added by CURL
        // "User-Agent: curl/7.29.0"
        // "Host: xx"
        // "Accept: */*"
        // "Content-Type:application/x-www-form-urlencoded"
        // "Content-Length: 161"

#### References
* [How can I see the request headers made by curl when sending a request to the server?](http://stackoverflow.com/questions/866946/how-can-i-see-the-request-headers-made-by-curl-when-sending-a-request-to-the-ser)
