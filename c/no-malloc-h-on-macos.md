# No "malloc.h" on macOS

## Problem
* Report "no malloc.h" when compiling c code on macOS:

  ```c
  #include <malloc.h>
  ```

## Solution
Include `<stdlib.h>` on macOS instead.

```c
#ifdef __APPLE__
    #include <stdlib.h>
#else
    ##include <malloc.h>
#endif
```

## References
* [macOS以及ios上的一些内存函数具体实现](https://juejin.cn/post/7220043684291838011)
* [C和C++在mac上用不了malloc.h头文件的最佳解决方法](https://blog.csdn.net/weixin_55361556/article/details/142268468)
* [How to detect reliably Mac OS X, iOS, Linux, Windows in C preprocessor?](https://pvq.app/questions/5919996/how-to-detect-reliably-mac-os-x-ios-linux-windows-in-c-preprocessor)
