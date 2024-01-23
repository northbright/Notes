# `-shell-escape` Option Enables Tex to Run System Commands

## Problem
* What Does `-shell-escape` Option Do when Run `xelatex`?

## Answer
For security reason, LaTex can not run system calls(commands) within Tex source(.tex) by default.
`-shell-escape` enables the possibility of running system commands from within TeX.

## References
* [How can I enable shell-escape?](https://tex.stackexchange.com/questions/598818/how-can-i-enable-shell-escape)
* [What does --shell-escape do?](https://tex.stackexchange.com/questions/88740/what-does-shell-escape-do)
* [Interaction modes](https://tex.stackexchange.com/questions/91592/where-to-find-official-and-extended-documentation-for-tex-latexs-commandlin)

