# Fix Warning: Remote Host Identification has Changed

#### Problem
* We got "Warning: Remote Host Identifaction has Changed" and failed to connect the server after run `ssh xx@xx.com`.

#### Root Cause
* The IP of server(xx.com) has changed.
* We already add the ECDSA/RSA key in `~/.ssh/known_hosts`

#### Solution
* Just remove the line contains old key of `xx.com` in `~/.ssh/known_hosts`.

        // Remove the line contains old key and ssh will ask user to add a new one.
        xx.com,xx.xx.xx ecdsa-sha2-nistp256 XXXXXX

