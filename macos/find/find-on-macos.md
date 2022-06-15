# `find` on Mac OS X

## Problem
* Find all Markdown files under current dir(`.`) and search if the content of each markdown file contains "PDF" keyword

## Solution
```
find . -name "*.md" -type f -print0 | xargs -0 grep "PDF" -rn --color
```

## References
* [Use find and grep to Search Keywords in Matched Files](https://github.com/northbright/Notes/blob/master/Linux/find/use-find-and-grep-to-search-keywords-in-matched-files.md)
* [xargs - Mac OS X in a Nutshell [Book]](https://www.oreilly.com/library/view/mac-os-x/0596003706/re416.html)
