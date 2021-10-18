# Use SSH to Run Local Script on Remote Server

## Solution
```
ssh user@host 'bash -s' < xx.sh
```

## Example
```
vi check.sh
```

```
#!/bin/bash
df -h ~/public
du -sh ~/public
```

```
ssh xx@xx.com 'bash -s' < check.sh
```

## References
* [How to use SSH to run a local shell script on a remote machine?](https://stackoverflow.com/questions/305035/how-to-use-ssh-to-run-a-local-shell-script-on-a-remote-machine)
