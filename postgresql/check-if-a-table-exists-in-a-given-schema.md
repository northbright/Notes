# Check if a Table Exists in a Given Schema in PostgreSQL

#### Solution

    SELECT EXISTS (
        SELECT 1
        FROM pg_tables
        WHERE schemaname = 'schema_name'
        AND tablename =  'table_name'
    );

#### Example

    SELECT EXISTS (
        SELECT 1
        FROM pg_tables
        WHERE schemaname = 'public'
        AND tablename = 'employees'
    );

    exists 
    --------
    t
    (1 row) 


#### References
* [How to check if a table exists in a given schema](http://stackoverflow.com/questions/20582500/how-to-check-if-a-table-exists-in-a-given-schema)
