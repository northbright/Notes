# Difference Between `su` and `su -`

* `su` just switches user, providing a normal shell with the same environment as old user
* `su -` invokes a login shell after switching to the new user. The login shell **RESETS** most environment variables

## References
* [Why do we use su - and not just su?](https://unix.stackexchange.com/questions/7013/why-do-we-use-su-and-not-just-su)
