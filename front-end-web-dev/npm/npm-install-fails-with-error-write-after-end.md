# `npm install` Fails with Error: write after end

#### Root Cause
* npm 5.7, 5.8.x has this problem

#### Solution(workaround)
* Use npm 5.6.0

          npm i -g npm@5.6.0

#### References
* [npm install fails with "Error: write after end" or "ERR_STREAM_WRITE_AFTER_END" on 5.7.x and 5.8.x](https://github.com/npm/npm/issues/19989)
