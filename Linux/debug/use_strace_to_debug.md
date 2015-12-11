# Use `strace` to Debug

* `strace` can be seen as a light weight debugger.
* It allows a programmer / user to quickly find out how a program is interacting with the OS.
* It does this by monitoring system calls and signals.
* If a syscall fails, you would see error codes returned from the syscalls.

## References

* [How should strace be used?](http://stackoverflow.com/questions/174942/how-should-strace-be-used)
* [strace: for fun, profit, and debugging.](http://timetobleed.com/hello-world/)