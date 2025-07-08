# Got`dquote` due to Exclamation Mark Not Escaped in Bash

## Problem
* Run bash command:

```bash
echo -ne "1\n00:00:08,000 --> 00:00:22,000\nGoal from Wugui!" > "01.srt"
```

* Got `dquote>` and failed to run the command

## Root Cause
The exclamation mark is part of history expansion in bash.

## Solution
To use it you need it enclosed in single quotes(e.g: 'http://example.org/!132').

```bash
echo -ne '1\n00:00:08,000 --> 00:00:22,000\nGoal from Wugui!' > '01.srt'
```

## References
* [Can't use exclamation mark (!) in bash?](https://unix.stackexchange.com/questions/33339/cant-use-exclamation-mark-in-bash)
* [How to echo an exclamation point without the backslash in the output to prevent expansion](https://unix.stackexchange.com/questions/641069/how-to-echo-an-exclamation-point-without-the-backslash-in-the-output-to-prevent)
* [Why is printf better than echo?](https://unix.stackexchange.com/questions/65803/why-is-printf-better-than-echo)
