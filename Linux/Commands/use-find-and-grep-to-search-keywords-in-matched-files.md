# Use `find` and `grep` to Search Keywords in Matched Files

#### Basic Command

    // Search all .md files to find the lines which contain "git config":
    find . -name "*.md" | xargs grep -i "git config" -rn --color

#### Problems
1. It will get errors from grep for matching directories.
2. It will occur "File not found error" for the files which filename contain quotes or spaces.

#### Solution
* For problem - It will get errors from grep for matching directories:
  * Add `-type f` arg for `find`

* For problem - It will occur "File not found error" for the files which filename contain quotes or spaces:
  * Add `-print0` arg for `find` and add `-0` arg for `xargs`.

#### Example

    find -name "*.md" -print0 | xargs -0 grep -i "git config" -rn --color

#### References
* [What does “xargs grep” do?](https://askubuntu.com/questions/833128/what-does-xargs-grep-do)

    
