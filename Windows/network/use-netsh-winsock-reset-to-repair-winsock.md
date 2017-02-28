# Use `netsh winsock reset` to Fix Winsock

#### Problem
* `ping` command works but all browsers can't open any website.

#### Root Cause
* Winsock may have issues(E.g. after 网易UU installed).

#### Reset Winsock
* Run `cmd` as administrator
* Run `netsh winsock reset`
* Restart PC

#### References
* [Netsh Commands for Windows Sockets (WINSOCK)](https://technet.microsoft.com/en-us/library/cc753591(v=ws.10).aspx)
