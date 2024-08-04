# Get Count of Files in a Dir Using Command Line

## Solution
Go to the dir and run `ls | wc -l`.

* Count all files in a dir.
```bash
cd ~/xx
ls | wc -l
```

* Count all .jpg file in a dir
```bash
ls *.jpg | wc -l
```

* `wc` is a "word count" Program
* The `-l` of `wc` Causes It to Count Lines
* In This case, It's Counting the Lines in the Output from `ls`

## Warning
Do NOT run `ls` with `-l`. The count of files will be actual count + 1 because that it outputs "total: xx" line at the first.

e.g.
```bash
ls -l
totoal: xx
a.jpg
b.jpg
...
```

## References
* [How can I get a count of files in a directory using the command line?](https://unix.stackexchange.com/questions/1125/how-can-i-get-a-count-of-files-in-a-directory-using-the-command-line)
