# Remove `^M` in a Text File when Open It Using Vim

## Problem
* Open a text using Vim on macOS
* See `^M` characters

## Root Cause
* This file was saved on Windows
* The `^M` is a carriage-return character
* The ASCII code 0x0D represents the Carriage Return(CR) character
* The ASCII code 0x0A represents the Line Feed(LF) character

## Solution
1. Type `:e ++ff=dos`
  
  This command tells Vim to read the file again, forcing dos file format. Vim will remove CRLF and LF-only line endings, leaving only the text of each line in the buffer.

2. Then type `:set ff=unix`

3. And Finally type `wq`

## References
* [What is `^M` and how do I get rid of it?](https://unix.stackexchange.com/questions/32001/what-is-m-and-how-do-i-get-rid-of-it)
