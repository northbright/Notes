# [Reader.ReadRune](https://godoc.org/bufio#Reader.ReadRune) of [bufio](https://godoc.org/bufio) will Decode UTF-8 BOM bytes to `U+FEFF(0xFEFF)`

## Problem
* A UTF-8 text file was created using Windows's Notepad
* Using Go program to read lines of the text file
* First decoded rune of the file is `0xFEFF`

## Root Cause
* Windows Notepad will add UTF-8 BOM(`0xEF, 0xBB, 0xBF`) bytes at the beginning of the file
* [Reader.ReadRune](https://godoc.org/bufio#Reader.ReadRune) of [bufio](https://godoc.org/bufio) will Decode UTF-8 BOM bytes to the rune(Unicode **codepoint**): `U+FEFF`

## References
* [Byte Order Mark (BOM) FAQ](http://www.unicode.org/faq/utf_bom.html#bom1)
* [Why BOM is U+FE FF, rather than U+FF FE?](https://stackoverflow.com/questions/36360792/why-bom-is-ufe-ff-rather-than-uff-fe)
