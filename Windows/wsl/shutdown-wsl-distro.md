# Shutdown WSL Distro

## Shutdown All WSL Distro

```sh
wsl --shutdown
```

Check

```sh
wsl -l -v

// Output:
  NAME         STATE     VERSION
* Ubuntu       Stopped   2
  Ubuntu-24.04 Stopped   2
```

## Shutdown the Specified Distro

```sh
wsl --terminate <Distro Name>
```
e.g.
```
wsl --terminate Ubuntu-24.04
```

## References
* [Basic commands for WSL](https://learn.microsoft.com/en-us/windows/wsl/basic-commands)
