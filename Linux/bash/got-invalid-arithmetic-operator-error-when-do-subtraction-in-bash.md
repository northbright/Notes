# Got "invalid arithmetic operator" Error when Do Subtraction in Bash

## Problem
* Need to run a bash command to get the duration(in seconds) of a video using `ffprobe` and update the duration: d = d - 2.
* Command

  ```bash
  bash -c 'sec=$(ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "02.MOV"); sec=$(( sec - 2)); echo $sec'
  ```
* Run the command on macOS and got error:

  > syntax error: invalid arithmetic operator (error token is ".633333 - 2")

* Try to make the command simple and got the same error.

  ```bash
  bash -c 'sec=$(( 9.633333 - 2)); echo $sec'
  ```

* But it's ok when using "zsh".

## Root Cause
Bash is only capable of handling integers, not floating point numbers.

## Solution
Use `bc` for floating math when using "bash".

```bash
bash -c 'sec=$(echo 9.633333 - 2 | bc); echo $sec'
// Output:
7.633333
```

```bash
bash -c 'sec=$(ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "02.MOV"); sec=$(echo $sec - 2 | bc); echo $sec'
// Output:
7.633333
```

## Reference
* [How to Solve "Invalid Arithmetic Operator" - Floating-point Math in Bash   ](https://softhints.com/how-to-solve-invalid-arithmetic-operator-floating-point-math-in-bash/)
* ["invalid arithmetic operator" error when trying to add variables in Bash script](https://askubuntu.com/questions/1439195/invalid-arithmetic-operator-error-when-trying-to-add-variables-in-bash-script)
