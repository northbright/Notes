# Make `/usr/local/lib` Searched for Shared Libraries

## Steps

## Write `/usr/local/lib` to `/etc/ld.so.conf.d/usrlocallib.conf`
   
```sh
echo "/usr/local/lib" | sudo tee /etc/ld.so.conf.d/usrlocallib.conf
```

## Reload ldconfig cache

```sh
sudo ldconfig
```

## Check

```sh
ldconfig -p | grep xx.so
```

## References
* <http://stackoverflow.com/questions/4743233/is-usr-local-lib-searched-for-shared-libraries>
* [Sudo Echo “To” > File: Permission Denied](https://www.shellhacks.com/sudo-echo-to-file-permission-denied/)
* [How to solve "permission denied" when using sudo with redirection in Bash?](https://askubuntu.com/questions/230476/how-to-solve-permission-denied-when-using-sudo-with-redirection-in-bash)
