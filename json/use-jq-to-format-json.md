# Use jq to Format JSON

## Problem
* Need to format JSON on macOS

## Solution
Use [jq](https://github.com/jqlang/jq).

* Download latest release on <https://github.com/jqlang/jq/releases/latest> in browser
* Run `chmod a+x` on the executable
  ```sh
  sudo mkdir -p /usr/local/jq/bin
  sudo mv ~/Downloads/jq-macos-amd64 /usr/local/jq/bin/jq
  sudo chmod a+x /usr/local/jq/bin/jq
  ```
* Add jq executable path to `$PATH`

  ```sh
  vi ~/.profile

  ## jq
  export PATH=$PATH:/usr/local/jq/bin  
  ```

  ```sh
  source ~/.zprofile
  ```

* Test

  ```sh
  jq -h
  ```

  ```sh
  echo '{"name":"frank","phone_num":"112233"}' | jq .

  // Output:
  {
    "name": "frank",
    "phone_num": "112233"
  }  
  ```
