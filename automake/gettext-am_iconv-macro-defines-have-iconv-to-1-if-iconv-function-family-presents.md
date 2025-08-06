# gettext `AM_ICONV` Macro Defines `HAVE_ICONV` to 1 if iconv Function Family Presents

[Install gettext from Source on macOS](https://github.com/northbright/Notes/blob/master/automake/install-gettext-from-source-on-macos.md)

```sh
vi /usr/local/share/gettext/m4/iconv.m4
```

```m4
  if test "$am_func_iconv" = yes; then
    AC_DEFINE([HAVE_ICONV], [1],
      [Define if you have the iconv() function and it works.])
  fi
```
