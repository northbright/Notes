# twemproxy redis_auth setting

* All redis nodes should use the **SAME** password
* twemproxy also use the **SAME** password(`redis_auth` in `nutcracker.yml`)
* Password length should less than `256`

#### References
* [redis-auth feature](https://github.com/twitter/twemproxy/blob/master/notes/redis.md#redis-auth-feature)
