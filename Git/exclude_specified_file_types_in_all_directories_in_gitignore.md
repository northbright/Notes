
# Exclude Specified File Types in All Directories in `.gitignore`

    *
    !.gitignore
    !LICENSE
    !README.md
    !**/*.go
    !**/*.csv

A leading `**` followed by a slash means match in all directories.  
Use `**` to exclude `*.go` and `*.csv` in all directories.

#### References
* <http://git-scm.com/docs/gitignore>