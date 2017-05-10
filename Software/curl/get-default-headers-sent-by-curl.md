# Get Default Headers Sent by CURL

#### Solution
* Use `-v` to show more information.

        curl -v -X POST http://xx.com -H "Content-Type:application/x-www-form-urlencoded" -d "p=1&d=2" -D -

#### References
* [How can I see the request headers made by curl when sending a request to the server?](http://stackoverflow.com/questions/866946/how-can-i-see-the-request-headers-made-by-curl-when-sending-a-request-to-the-ser)
