# Echo Single Quote within Single Quotes

## Problem

```bash
echo 'It\'s time to do something.'
```

Output: `quote>` 

## Root Cause
A single-quote cannot occur within single-quotes.

## Solution
Use `echo $'string'`(but it can not expand variables any more).

> Words of the form $'string' are treated specially. The word expands to string, with backslash-escaped characters replaced as specified by the ANSI C standard. Backslash escape sequences, if present, are decoded as follows:

> \a     alert (bell)
> \b     backspace
> \e
> \E     an escape character
> \f     form feed
> \n     new line
> \r     carriage return
> \t     horizontal tab
> \v     vertical tab
> \\     backslash
> \'     single quote
> \"     double quote
> \nnn   the eight-bit character whose value is the octal value nnn (one to three digits)
> \xHH   the eight-bit character whose value is the hexadecimal value HH (one or two hex digits)
> \cx    a control-x character

## Example

```bash
echo $'It\'s time to do something.'
```

Output: `It's time to do something.`

## References
* [How to escape quotes in the bash shell?](https://unix.stackexchange.com/questions/30903/how-to-escape-quotes-in-the-bash-shell)
* [How to echo `single quote` when using single quote to wrap special characters in shell?](https://unix.stackexchange.com/questions/187651/how-to-echo-single-quote-when-using-single-quote-to-wrap-special-characters-in)
