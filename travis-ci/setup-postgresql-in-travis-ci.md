# Setup PostgreSQl in Travis Ci

#### Problem
* Want to run test case with JSONB type of PostgreSQL

#### Solution

```
services:
  - postgresql

addons:
  postgresql: "9.6"

before_script:
 - psql -c 'CREATE DATABASE test;' -U postgres
```

#### References
* [Setting up Databases](https://docs.travis-ci.com/user/database-setup/)
* [Please add PostgreSQL 10.0 #8537](https://github.com/travis-ci/travis-ci/issues/8537)
