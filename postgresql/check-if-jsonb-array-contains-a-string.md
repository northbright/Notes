# Check if JSONB Array Contains a String

#### Solution
* Use `?` operator

#### Example
* One task may have one or more assignees

```
CREATE TABLE IF NOT EXISTS task (
    data JSONB
);

INSERT INTO task (data) VALUES ('{"title":"task_1", "assigner":"1", "assignees":["2","3"]}');
INSERT INTO task (data) VALUES ('{"title":"task_2", "assigner":"1", "assignees":["2"]}');
```

* Want to get all tasks that which assignees contains "2"  

```
SELECT * FROM task WHERE (data->'assignees')::jsonb ? '2';

```

#### References
* [Check if a Postgres JSON array contains a string](https://stackoverflow.com/questions/19925641/check-if-a-postgres-json-array-contains-a-string)
* [JSON Functions and Operators](https://www.postgresql.org/docs/current/static/functions-json.html)
