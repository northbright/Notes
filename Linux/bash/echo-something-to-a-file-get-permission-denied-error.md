# echo Something to a File Get "permission denied" Error

## Problem
Run `sudo echo "/usr/local/lib" > /etc/ld.so.conf.d/usrlocallib.conf` and got "permission denied" error.

## Root Cause
Output redirection (via the > operator) is done by the shell, **NOT** by **echo**.

## Solution
* Method A: use `tee`

  * Use `tee` to overwrite a file.

    ```sh
    echo "/usr/local/lib" | sudo tee /etc/ld.so.conf.d/usrlocallib.conf
    ```

  * Use `tee -a` to append something to a file.

    ```sh
    echo "/usr/local/xx/lib" | sudo tee -a /etc/ld.so.conf.d/usrlocallib.conf
    ```

* Method B: use `sudo bash -c` to run `echo` direction

  ```sh
  sudo bash -c "echo '/usr/local/lib' > /etc/ld.so.conf.d/usrlocallib.conf"
  ```

## References
* [Sudo Echo “To” > File: Permission Denied](https://www.shellhacks.com/sudo-echo-to-file-permission-denied/)
* [How to solve "permission denied" when using sudo with redirection in Bash?](https://askubuntu.com/questions/230476/how-to-solve-permission-denied-when-using-sudo-with-redirection-in-bash)
