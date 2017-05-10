# Get Default Headers Sent by CURL

#### Solution
* Use `-v` to show more information.

        curl -v -X POST http://xx.com -H "Content-Type:application/x-www-form-urlencoded" -d "p=1&d=2" -D -
