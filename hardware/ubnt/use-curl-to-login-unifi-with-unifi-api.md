# Use CURL to Login Unifi with Unifi API

#### Solution
* Login API need to POST `json` data which contains `username` and `password`.

#### Example

    export username=MY_USER_NAME
    export password=MY_PASSWORD

    curl -v --insecure -X POST https://xx.xx.xx:8443 -d "{\"username\":\"$username\",\"password\":\"$password\"}"

#### References
* [api.err.Invalid Error When Logging In To Unifi API Via curl](https://community.ubnt.com/t5/UniFi-Wireless/api-err-Invalid-Error-When-Logging-In-To-Unifi-API-Via-curl/td-p/1676063)
