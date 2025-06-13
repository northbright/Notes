# `echo -e` Not Recognized by `/bin/sh` on macOS.md

## Problem
* Run the command in macOS terminal successfully:

```bash
echo -ne "1\n00:00:00,000 --> 00:00:03,000\nGood Times with Maomi & Mimao" > "op.srt"
```

Check the content of `op.srt`

```bash
vi op.srt
```

```bash
1
00:00:00,000 --> 00:00:03,000
Good Times with Maomi & Mimao
```

* Put the command in a shell script

```bash
#!/bin/sh
echo -ne "1\n00:00:00,000 --> 00:00:03,000\nGood Times with Maomi & Mimao" > "op.srt"
```

* Run the script and the content is incorrect

```bash
-ne 1
00:00:00,000 --> 00:00:03,000
Good Times with Maomi & Mimao
```

## Root Cause
* `/bin/sh` on macOS does not recognize `-ne` option of `echo` command.
* The interactive shell(`zsh`) does recognize.

## Solution
Use `/bin/bash` or interactive shell(`/bin/zsh`) instead in the shell script.

```bash
#!/bin/bash
echo -ne "1\n00:00:00,000 --> 00:00:03,000\nGood Times with Maomi & Mimao" > "op.srt"
```

## References
* [How do I use the -ne flag for echo in a shell script?](https://superuser.com/questions/300218/how-do-i-use-the-ne-flag-for-echo-in-a-shell-script)
* [在 Mac 上将 zsh 用作默认 Shell](https://support.apple.com/zh-cn/102360)
* [在 Mac 上的“终端”中更改默认 shell](https://support.apple.com/zh-cn/guide/terminal/trml113/mac)
