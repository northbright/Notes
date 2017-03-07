# Return Value of `vsnprintf`

`int vsnprintf(char *str, size_t size, const char *format, va_list ap);`

#### Return Value
* n < 0: error
* n > size: buffer is insufficient. n = length of formated string(not including '\0').
* 0 < n <= size: succeeded. n = length of formated string(not including '\0').

#### References
* [vsnprintf(3) - Linux man page](https://linux.die.net/man/3/vsnprintf)

