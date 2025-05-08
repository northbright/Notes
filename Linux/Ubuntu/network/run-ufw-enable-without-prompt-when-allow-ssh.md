# Run `ufw` Enable without Prompt when Allow SSH

## Problem
* Run `sudo ufw enable` after running `sudo ufw allow ssh`
* It prompts:

  > Command may disrupt existing ssh connections. Proceed with operation (y|n)

* Need to run `sudo ufw enable` in bash script without prompt

## Solution
Use `--force` option.

```bash
sudo ufw --force enable
```

## References
* [UFW Enable requires y prompt, how to automate with Bash Script?](https://serverfault.com/questions/790143/ufw-enable-requires-y-prompt-how-to-automate-with-bash-script)
