# Add System Wide Environment Variable for Bash

## Solution
Create a `.sh` under `/etc/profile.d/`.

e.g. Add `/usr/local/xx/bin` to `$PATH`:

```sh
sudo vi  /etc/profile.d/path.sh
```

```sh
export PATH="$PATH:/usr/local/xx/bin"
```

## References
* [How to permanently set environmental variables](https://unix.stackexchange.com/questions/117467/how-to-permanently-set-environmental-variables)
* [Setting variable in /etc/environment has no effect](https://superuser.com/questions/1308298/setting-variable-in-etc-environment-has-no-effect)
