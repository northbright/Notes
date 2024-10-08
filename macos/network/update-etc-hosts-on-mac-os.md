# Update `/etc/hosts` on macOS

## Problem
[cnBeta](https://www.cnbeta.com) can NOT be accessed from China suddenly.

## Solution
Resolve [cnBeta](https://www.cnbeta.com) to the IP provided by Cloudflare.

#### Get the IP
* Go to [ChinaZ Ping Tool](https://ping.chinaz.com)
* Input `www.cnbeta.com` and click "Ping Test"
* Find it failed to ping `www.cnbeta.com` and from the test sites in China
* It succeeded to ping `www.cnbeta.com` from the test sites out of China(Hongkong, Japan, US...) because of resolving `www.cnbeta.com` to Cloudflare's IP
* Record the IP(e.g. `104.26.7.xx`)
* Update: many posts of cnBeta are redirected to `hot.cnbeta.com`

  We need to get the Cloudflare's IP for `hot.cnbeta.com` too

#### Update `/etc/hosts`
* `sudo vi /etc/hosts`

* Append the record for `www.cnbeta.com` and `hot.cnbeta.com`

  ```
  104.26.7.xx    www.cnbeta.com
  172.67.73.xx   hot.cnbeta.com
  ```

* Flush DNS Cache

  ```
  sudo killall -HUP mDNSResponder
  ```

* Test

  ```
  ping www.cnbeta.com
  ```

## Workaround
* [Visit cnBeta via Jinritoutiao](https://github.com/northbright/Notes/blob/master/websites/cnbeta/visit-cnbeta-via-jin-ri-tou-tiao.md)

## References
* [Flush DNS Cache on Mac OS](https://github.com/northbright/Notes/blob/master/macos/network/flush-dns-cache-on-mac-os.md)
