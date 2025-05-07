# Write or Append Multiple Lines to a File in Bash Script

## Solution
Use Here Documents.

* Write multiple lines to a file

  ```bash
  vi write.sh
  ```

  ```bash
  #!bin/bash

  cat << EOF > 1.txt
  Hello,
  World!
  EOF 
  ```

  Run `write.sh`.
  ```bash
  chmod a+x write.sh
  ./write.sh
  cat 1.txt
  ```

* Append multiple lines to a file

  ```bash
  vi append.sh
  ```

  ```bash
  #!bin/bash

  cat << EOF >> 1.txt
  Good,
  Luck!
  EOF
  ```

  Run `append.sh`.
  ```bash
  chmod a+x append.sh
  ./append.sh
  cat 1.txt

  // Output:
  Hello,
  World!
  Good,
  Luck!  
  ```

## References
* [How to append multiple lines to a file](https://unix.stackexchange.com/questions/77277/how-to-append-multiple-lines-to-a-file)
* [Multiline Echo in Bash](https://www.delftstack.com/howto/linux/bash-echo-multiple-lines/)
