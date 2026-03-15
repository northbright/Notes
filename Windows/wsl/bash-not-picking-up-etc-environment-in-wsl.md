# Bash Not Picking up `/etc/environment` in WSL

## Problem
* WSL2 with Ubuntu-24.04 installed
* Add a Tavily API key in `/etc/environment` for OpenClaw

  ```sh
  sudo vi /etc/environment
  ```

  ```sh
  TAVILY_API_KEY="xxxx"
  ```

* Run `wsl -d Ubuntu-24.04` to open a bash

* `echo $TAVILY_API_KEY` shows empty

* It does not work even with `--shell-type login` to launch bash as a login shell
* As of build 16188 when running bash.exe without arguments (or with the ~ argument) bash will be launched as a login shell

## Root Cause
* WSL issue: [bash not picking up /etc/environment #1405](https://github.com/microsoft/WSL/issues/1405) 
  > Light snooping shows me that WSL "logins" are not real logins as far as PAM is concerned

## Workaround
Create a `.sh` in `/etc/profile.d/`.

```sh  
vi /etc/profile.d/apikey.sh
```
  
```sh
export TAVILY_API_KEY="xxxx"
```

Restart Ubuntu:

```sh
wsl --shutdown
wsl -d Ubuntu-24.04
```

## References
* [bash not picking up /etc/environment #1405](https://github.com/microsoft/WSL/issues/1405)
* [WSL run a non-login shell even with `--shell-type login`](https://superuser.com/questions/1829907/wsl-run-a-non-login-shell-even-with-shell-type-login)
* [Add "Run as login shell" option for Bash. #816](https://github.com/microsoft/WSL/issues/816)
* [Setting variable in /etc/environment has no effect](https://superuser.com/questions/1308298/setting-variable-in-etc-environment-has-no-effect)
