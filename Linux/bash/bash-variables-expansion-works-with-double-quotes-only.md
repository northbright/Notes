# Bash Variables Expansion Works with Double Quotes Only

## Problem
To show `!`, use single quote:

```bash
name=Jacky; echo 'Hello $name!'
```

Output: `Hello $name!`

## Root Cause
Bash variables expansion works with double quotes only.

## Solution
* Use double quotes to expand the variables.
* Use another single quotes to show `!`

```bash
name=Jacky; echo "Hello $name"'!'
```

## References
* [Can't use exclamation mark (!) in bash?](https://unix.stackexchange.com/questions/33339/cant-use-exclamation-mark-in-bash)
* [How to echo an exclamation point without the backslash in the output to prevent expansion](https://unix.stackexchange.com/questions/641069/how-to-echo-an-exclamation-point-without-the-backslash-in-the-output-to-prevent)
* [variable expansion in single quote](https://askubuntu.com/questions/772057/variable-expansion-in-single-quote)
* [Is there any way to print value inside variable inside single quote?](https://unix.stackexchange.com/questions/209971/is-there-any-way-to-print-value-inside-variable-inside-single-quote)
