# How to Search a Column Name Within all Tables

#### Solution

    select table_name,column_name from information_schema.columns where column_name like '%YOUR_COLUMN_NAME%';

#### References
* [How to search a column name within all tables of a database and how to search stored procedures containing a particular text](http://www.codeproject.com/Tips/136463/How-to-search-a-column-name-within-all-tables-of-a)
* [Find all tables containing column with specified name](http://stackoverflow.com/questions/4849652/find-all-tables-containing-column-with-specified-name)
