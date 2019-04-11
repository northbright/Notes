# Use `find` and `grep` to Search Keywords in Matched Files

## Problems
* Search all .md files to find the lines which contain "git config":
    
      find . -name "*.md" | xargs grep -i "git config" -rn --color

* Problem 1: It'll get errors from grep for matching directories.
* Problem 2: It'll occur "File not found" / "xargs: unmatched single quote" error for the files which filename contain quotes or spaces.

## Solutions
* For problem 1:
  * Add `-type f` arg for `find`

* For problem 2:
  * Add `-print0` arg for `find` and add `-0` arg for `xargs`.

#### Example

    find -name "*.md" -type f -print0 | xargs -0 grep -i "git config" -rn --color

#### References
* [What does “xargs grep” do?](https://askubuntu.com/questions/833128/what-does-xargs-grep-do)

    
