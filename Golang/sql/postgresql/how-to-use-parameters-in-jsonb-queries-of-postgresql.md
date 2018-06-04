# How to Use Parameters in JSONB Queries of PostgreSQL

#### Problem
* Building [Golang](https://golang.org) app with PostgreSQL's Golang Driver: [pq](https://github.com/lib/pq)
* Using [parameter markers](https://godoc.org/github.com/lib/pq#hdr-Queries)(`$1`) in JSONB query
* Got  `error: pq: got 1 parameters but the statement requires 0` after executed the query:
   
       // Select data which employee's mobile phone num == $1
       SELECT data FROM employee WHERE data @> '{"mobile_phone_num":$1}'

* Table schema
   ```
       var schema = `
       CREATE TABLE employee {
           id SERIAL PRIMARY KEY,
           data JSONB
       };
       CREATE INDEX on employee USING GIN (data);
       `
  ```

#### Root Cause
$1 is **NOT** parameter placeholder in this case, since they're inside a string literal

#### Solution
* Use [`jsonb_build_object()`](https://www.postgresql.org/docs/current/static/functions-json.html)

       SELECT data FROM employee WHERE data @> jsonb_build_object('mobile_phone_num',$1::text)

* `$1::text` indicates that `$1` parameter type is TEXT
   You'll get `error: pq: could not determine data type of parameter $1`if there's no `::text` specified

#### References
* [How do I use parameters in JSON queries](https://github.com/lib/pq/issues/368)
