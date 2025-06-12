# Got`dquote` due to Exclamation Mark Not Escaped in Bash

## Problem
* Run bash command:

```bash
echo -ne "1\n00:00:08,000 --> 00:00:22,000\nGoal from Wugui!" > "01.srt"
```

* Got `dquote>` and failed to run the command

## Root Cause
Exclamation mark(`!`) is not escaped.

## Solution
Use `\!` to escape exclamation mark.

```bash
echo -ne "1\n00:00:08,000 --> 00:00:22,000\nGoal from Wugui\!\!" > "01.srt"
```

## References
* [How to echo an exclamation point without the backslash in the output to prevent expansion](https://unix.stackexchange.com/questions/641069/how-to-echo-an-exclamation-point-without-the-backslash-in-the-output-to-prevent)
