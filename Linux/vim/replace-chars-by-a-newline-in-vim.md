# Replace Chars by a Newline in vim

#### Use `\r` to represent a newline
* Use `\r` but not `\n` to get a newline.
* But **still** use `\n` to FIND a newline

#### Example
Replace ",newline" with just a newline(remove ",").

```
:%s/,\n/\r/gc
```

#### References
* [How to replace a character by a newline in Vim?](http://stackoverflow.com/questions/71323/how-to-replace-a-character-by-a-newline-in-vim)
* [Why does '\r' (and not '\n') work to replace with a newline in 'vim'?](https://unix.stackexchange.com/questions/247329/why-does-r-and-not-n-work-to-replace-with-a-newline-in-vim)
