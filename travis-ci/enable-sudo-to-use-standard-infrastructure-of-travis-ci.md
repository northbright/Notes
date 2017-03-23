# Enable `sudo` to Use Standard Infrastructue of travis-ci.org

#### Problem
* Get `sudo: must be setuid root` error while building

#### Solution
* Add`sudo: required` in `.travis.yml` to make travis-ci use standard infrastructure.

#### References
* [Travis sudo is disabled](http://stackoverflow.com/questions/26299552/travis-sudo-is-disabled)
* [The Build Environment](https://docs.travis-ci.com/user/ci-environment/)
