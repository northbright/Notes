# Count the Occurrence of Pattern Match in Vim

## Problem
Need to count occurrence when search keyword in Vim

## Solution
Use the `n` flag in substitute command: `:%s/pattern//n` to count the occurrence of pattern search but ignore the substitution.

The output format:
```sh
12 occurrences on 9 lines
```

## References
* [Count Occurrences](https://vimtricks.com/p/vimtrick-count-occurrences/)
* [Is there a way to count the number of occurrences of a word in a file?](https://vi.stackexchange.com/questions/93/is-there-a-way-to-count-the-number-of-occurrences-of-a-word-in-a-file)
