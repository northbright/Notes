# Macro Search Path of aclocal

By default, aclocal searches for `.m4` files in the following directories, in this order:

1. "acdir-APIVERSION"
2. "acdir": `${prefix}/share/aclocal/`
   
   `${prefix}` is the configured prefix when install Automake.

For example, suppose that Automake 1.11.2 was configured with `--prefix=/usr/local`.
Then, the search path would be:

`/usr/local/share/aclocal-1.11.2/`
`/usr/local/share/aclocal/`

To show "acdir", run `aclocal --print-ac-dir`.

## References
* [Macro Search Path](https://www.gnu.org/software/automake/manual/html_node/Macro-Search-Path.html)
