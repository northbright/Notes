# Simulating Enter Key in Bash

## Problem
* Run `testparm` in bash script
* Prompt "Press enter to see a dump of your service definitions"
* Need to simulate Enter key and run bash script without prompt

## Solution
Use `echo -ne "\n"` to simulate Enter key.

```bash
echo -ne "\n" | testparm
```

## References
* [How To Simulate An ENTER Keypress In A Bash Script?](https://www.uptimia.com/questions/how-to-simulate-an-enter-keypress-in-a-bash-script)
