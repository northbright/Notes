# Use a Private Module

## Steps
* Set `GOPRIVATE` environment variable(e.g. on macOS)

  ```sh
  vi ~/.zprofile
  ```

  ```sh
  ......
  # Go
  export GOPRIVATE=github.com/USER_NAME/SECRET,github.com/USER_NAME/ANOTHER_SECRET
  ......
  ```

  ```sh
  source ~/.zprofile
  ```

* Create SSH Key Pair on Local Machine and Add public key to Github Account's SSH Keys

  * Generate SSH Key Pair on Local Machine

    ```sh
    ssh-keygen -t rsa -b 2048
    ```

  * Copy the public key in `~/.ssh/id_rsa.pub`
  * Add it to Github Account Settings > SSH and GPG Keys > SSH Keys

* Make `Git` Use SSH instead of HTTPS for URL: `https://github.com/`

  ```sh
  vi ~/.gitconfig
  ```

  Append these lines:

  ```sh
  [url "ssh://git@github.com/"]
      insteadOf = https://github.com/
  ```

* Import the Private Module in Your Project

  ```go
  import (
    "github.com/USER_NAME/SECRET"
  )
  ```

  ```sh
  go mod tidy
  ```

## References
* [How to Use a Private Go Module in Your Own Project](https://www.digitalocean.com/community/tutorials/how-to-use-a-private-go-module-in-your-own-project)
