# Replace Chars by a Newline in vim

#### Use `\r` to represent a new line
* Use `\r` but not `\n` to get a newline.
* But **still** use `\n` to FIND a newline

#### Example
* Insert a newline: `var db *DB` after `var err error`

        var err error
        var id uint64

        :%s/var err error\n/var err error\rvar db \*DB\r/gc

#### References
* [How to replace a character by a newline in Vim?](http://stackoverflow.com/questions/71323/how-to-replace-a-character-by-a-newline-in-vim)
