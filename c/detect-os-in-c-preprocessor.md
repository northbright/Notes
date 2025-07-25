# Detect OS in C Preprocessor

## Solution
```c
#include <stdio.h>
#include <stdlib.h>

int main() {
  #ifdef __APPLE__
    printf("Running on Mac OS X\n");
    #elif __ANDROID__
    printf("Running on Android\n");
    #elif __linux__
    printf("Running on Linux\n");
    #elif __windows__
    printf("Running on Windows\n");
  #else
    printf("Unknown operating system\n");
  #endif

  return 0;
}
```

## References
* [C和C++在mac上用不了malloc.h头文件的最佳解决方法](https://blog.csdn.net/weixin_55361556/article/details/142268468)
* [How to detect reliably Mac OS X, iOS, Linux, Windows in C preprocessor?](https://pvq.app/questions/5919996/how-to-detect-reliably-mac-os-x-ios-linux-windows-in-c-preprocessor)
