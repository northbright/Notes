# NULL-safety with JSON and PostgreSQL in Golang

#### Background
* Save Tasks in PostgreSQL in JSONB format
* Table Description of Task
   ```
  CREATE TABLE IF NOT EXISTS task (
      id TEXT PRIMARY KEY,
      data JSONB
  );
  CREATE INDEX on task USING GIN (data);
  ```
 
* Golang TaskData / Task Struct
   ```
  type TaskData struct {
      Title string    `json:"title"`
      Comments string `json:"comments"`
  }
 
  type Task struct {
      ID string `json:"id"`
      *TaskData
  } 
  ``` 
 
* Create a new Task **without** comments and save it as JSONB in PostgreSQL
  ```
  func CreateTask(db *sqlx.DB, t *TaskData) (string, error) {
      ID := uuid.New()
      newTask := Task{ID: ID, TaskData: t}
      jsonData, err := json.Marshal(newTask)
      if err != nil {
              return "", err
      }

      stat := `INSERT INTO task (id, data) VALUES ($1, $2)`
       
      if _, err = db.Exec(stat, ID, string(jsonData)); err != nil {
              return "", err
      }
      return ID, nil
  }

  func main() {
      ...
      // TaskData without any comments(nil slice)
      data := TaskData{Title: "Fix PC"}
      CreateTask(db, &data)
      ...
  }
  ```

#### Problem
* Need a new function `CreateComments` to add comments for task
  ```
  func CreateTaskComment(db *sqlx.DB, taskID string, comment string) error {
      // Concatenate new comment and old comments by using `||` operator of PostgreSQL
      stat := `UPDATE task SET data = jsonb_set(
              data, '{comments}', data->'comments' || jsonb_build_array($1::jsonb), true)  
              WHERE id = $2`

      if _, err = db.Exec(stat, comment, taskID); err != nil {
          return err
      }
      return nil
  }

  func main() {
  ...
      CreateTaskComment(db, taskID, "Comment 1")
  ...
  }

  ```
* The comments contains `null` and looks like: `{comments:[null, "Comment 1"]}`

#### Root Cause
* Golang's [`encoding/json`](https://godoc.org/encoding/json) package will encode **nil** slice to **`null`**

   * `TaskData{Title: "Fix PC"}` will be marshaled to `{"title":"Fix PC", "comments": null}`

   * See [`nil` Slice Encodes as `null` JSON Value](https://github.com/northbright/Notes/blob/master/Golang/json/nil-slice-encodes-as-null-json-value.md) for more information.

#### Solution
* Use [`omitempty`](https://godoc.org/encoding/json#Marshal) option in `json` tag

  The field will be omitted from encoding if it's empty.

  ```
  type TaskData struct {
      Title string    `json:"title"`
      // Use omitempty option to avoid nil slice to be encoded as null
      Comments string `json:"comments,omitempty"`
  }
  ```

* Use [`coalesce`](https://www.postgresql.org/docs/10/static/functions-conditional.html#FUNCTIONS-COALESCE-NVL-IFNULL) to check `null` and provide a non-null value.
  
  > The `COALESCE` function returns the first of its arguments that is not null

  ```
  func CreateTaskComment(db *sqlx.DB, taskID string, comment string) error {
      // Concatenate new comment and old comments by using `||` operator of PostgreSQL
      // Use COALESCE() to return a non-null array value.
      stat := `UPDATE task SET data = jsonb_set(
      data, '{comments}', COALESCE(data->'comments', '[]'::jsonb) || jsonb_build_array($1::jsonb), true)
      WHERE id = $2`
      ...
  }
  ```

#### References
* [`nil` Slice Encodes as `null` JSON Value](https://github.com/northbright/Notes/blob/master/Golang/json/nil-slice-encodes-as-null-json-value.md)
* [Null-safety with JSON and PostgreSQL](https://clarkdave.net/2015/03/navigating-null-safety-with-json-and-postgresql/)
