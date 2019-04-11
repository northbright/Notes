# find with xargs Got Unmatched Single Quote Error

## Problem
* To find some files which contains specified string
* Use `find` with `xargs`

      find . -name "*.md" -type f | xargs grep "lib" -rn --color
* Got "xargs: unmatched single quote" error

## Root Cause
* File name contains single quote

## Solution
* Use `-print0` option for `find` and `-0` option for `xargs`

## Example

    find . -name "*.md" -type f -print0 | xargs -0 grep "lib" -rn --color

## References
* [How can I use xargs to copy files that have spaces and quotes in their names?](https://stackoverflow.com/questions/143171/how-can-i-use-xargs-to-copy-files-that-have-spaces-and-quotes-in-their-names)
* [xargs: unmatched single quote](https://www.linuxquestions.org/questions/linux-newbie-8/xargs-unmatched-single-quote%3B-by-default-quotes-are-special-to-xargs-unless-you-use-936066/)

