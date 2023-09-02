# Failed to Enable a Service due to It is Masked

## Problem
* Want to Enable `nmbd.service`(Samba NetBIOS Service)

  ```
  sudo systemctl enable nmbd.service
  ```

* Got Error

  > Unit nmbd.service is masked.

## Root Cause
* `nmbd.service` is masked and it is symlinked to `/dev/null`.

## Solution
Unmask it.

```
sudo systemctl unmask nmbd.service
```

## References
* [linux.服务器后台启动某个服务时，提示unit is masked，请问该如何解决？](https://www.zhihu.com/question/526314418/answer/2427705224)
* [Unit systemd-resolved.service is masked](https://askubuntu.com/questions/1207493/unit-systemd-resolved-service-is-masked)
