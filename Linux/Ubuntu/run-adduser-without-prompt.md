# Run `adduser` without Prompt

## Problem
* Need to create an user without password(nologin) for Samba
* Need to run `adduser` without prompt in shell

## Solution
Use `--disabled-password --gecos ""` options.

```bash
adduser --disabled-password --gecos "" \
  --home /data/samba/ppt \
  --no-create-home \
  --shell /usr/sbin/nologin \
  --ingroup sambashare ppt
```

## References
* [Run adduser non-interactively](https://askubuntu.com/questions/94060/run-adduser-non-interactively)
