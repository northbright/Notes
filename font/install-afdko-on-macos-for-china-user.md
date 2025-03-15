# Install afdko on macOS for China User

## Problem
* Need to build [source-han-serif](https://github.com/adobe-fonts/source-han-serif)
* Need to install [afdko](https://github.com/adobe-type-tools/afdko/) first on macOS

## Solution
* Install Python3
  * [Install Python 3 on macOS](https://github.com/northbright/Notes/blob/master/python/install-python3-on-macos.md)

* Set pip Mirror for China User
  * [Set Mirror of pip on macOS for China Users](https://github.com/northbright/Notes/blob/master/python/set-mirror-of-pip-on-macos-for-china-users.md)

* Install [afdko](https://github.com/adobe-type-tools/afdko/)

  * Use virtual environment to install adfko

    ```shell
    cd ~/download

    python -m venv afdko_env
    source afdko_env/bin/activate
    python -m pip install afdko
    ```

    It'll generates binaries(e.g. `makeotf`) under `afdko_env/bin`.

  * Copy binaries to `/usr/local/afdko/bin`

    ```shell
    sudo mkdir -p /usr/local/afdko
    sudo cp -rf afdko_env/bin /usr/local/afdko
    ```

  * Export afdko binary path

    ```shell
    vi ~/.zprofile
    ```

    ```shell
    # afdko
    export PATH=$PATH:/usr/local/afdko/bin
    ```

    ```shell
    source ~/.zprofile
    ```

* Test

  ```shell
  which makeotf

  // Output:
  /usr/local/afdko/bin/makeotf
  ```

## References
* <https://adobe-type-tools.github.io/afdko/>
