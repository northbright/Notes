# Minted Code Block Represents Tabs as `^^I` when Run `xelatex` to Create a PDF

## Problem
* Compile Tex File to a PDF via `xelatex`
* The Minted Code Block Represents Tabs as `^^I`

## Solution
Run `xelatex` with `-8bit` option which make all characters printable, don't use ^^X sequences.

## References
* [xelatex: Minted code block represents tabs as ^^I](https://tex.stackexchange.com/questions/264461/xelatex-minted-code-block-represents-tabs-as-i)
