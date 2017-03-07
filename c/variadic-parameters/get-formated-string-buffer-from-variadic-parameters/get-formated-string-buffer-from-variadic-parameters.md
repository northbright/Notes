# Get Formated String Buffer from Variadic Parameters

#### Problem
* We want to write function with variadic parameters like `printf()` and get formated string.

#### Solution
* Use `va_list`, `va_start()`, `va_copy()`, `va_end()` to deal with variadic arguments.
* Parse `va_list` to `vsnprintf()`
* Check return value of `vsnprintf()` to detect the actual size of formated string.
* Use `malloc()` to allocate a new buffer to store the string.

#### Example

    #include <stdio.h>
    #include <stdint.h>
    #include <string.h>
    #include <malloc.h>
    #include <stdarg.h>

    int MyPrintf(char *fmt, ...) {
        int nRet = -1;
        int n, nBytes = 0;
        char *buf = NULL;
        va_list args1, args2;
        char fixedBuffer[64] = {0};
        char *inputStr = fixedBuffer;

        va_start(args1, fmt);
        va_copy(args2, args1);

        // Get formated input string buffer.
        // If n > 0 and n <= sizeof(fixedBuffer), vsnprintf() succeeded,
        // n = the size of formated string(not including '\0').
        n = vsnprintf(fixedBuffer, sizeof(fixedBuffer), fmt, args1);
        printf("n = %d\n", n);

        if (n < 0) {
            goto end;
        }

        // Fixed buffer is not large enough.
        // n = the size of formated string(not including '\0').
        // Use malloc() to allocate a new buffer to store formated input string.
        if (n > sizeof(fixedBuffer)) {
            buf = malloc(sizeof(char) * (n + 1));
            if (buf == NULL) {
                printf("MyPrintf() error: tmpBuf = malloc(%d) failed.\n", n + 1);
                goto end;
            }

            nBytes = vsnprintf(buf, n + 1, fmt, args2);
            if (nBytes != n) {
                printf("MyPrintf) error: vsnprintf() nBytes(%d) != n(%d)\n", nBytes, n);
                goto end;
            }

            // Make inputStr point to dynamic buffer.
            inputStr = buf;
        }

        // Now we get the formated string in inputStr.
        // Do what you want to inputStr.
        printf("inputStr: %s\n", inputStr);

        nRet = 0;

    end:
        // Free allocated buffer if need.
        if (buf != NULL) {
            free(buf);
            buf = NULL;
        }

        va_end(args1);
        va_end(args2);
        
        return nRet;
    }

    int main() {
        MyPrintf("%d", 1);
        MyPrintf("%s", "Hello World!");
        MyPrintf("%.2f", 3.141516);
    }

#### References
* [C variadic wrapper](http://stackoverflow.com/questions/37947200/c-variadic-wrapper)
* [vsnprintf(3) - Linux man page](https://linux.die.net/man/3/vsnprintf)
