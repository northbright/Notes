# Assign Command Ouput to a Shell Variable

## Method A
Use command substitution(`v=$( COMMAND )`)

```bash
v=$(echo 3.14 | awk -F. '{ print $1 }' ); echo $v
```

Output:
```bash
3
```

## Method B
Use `read` command to read the output to a variable.

```bash
echo 3.14 | awk -F. '{ print $1 }' | read v; echo $v
```

Output:
```bash
3
```

## References
* [How to Read From Pipe in Bash [5 Cases]](https://linuxsimply.com/bash-scripting-tutorial/redirection-and-piping/piping/read-from-pipe/)
* [How can I assign the output of a command to a shell variable?](https://unix.stackexchange.com/questions/16024/how-can-i-assign-the-output-of-a-command-to-a-shell-variable)
* [Command Substitution](https://tldp.org/LDP/abs/html/commandsub.html)
* [Execute command and store everything to variable in bash](https://unix.stackexchange.com/questions/444935/execute-command-and-store-everything-to-variable-in-bash)
