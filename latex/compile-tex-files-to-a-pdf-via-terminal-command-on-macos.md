# Compile a Tex File to a PDF via Terminal Command on macOS

## Problem
* Installed [MacTex](https://tug.org/mactex/) on macOS
* Need to Use Command Line to Compile a Tex Files to a PDF

## Solution
Run `xelatex` 2 times to compile the Tex File.

```
xelatex -output-directory ~/output xx.tex
xelatex -output-directory ~/output xx.tex
```

* Run `xelatex` for the First Time
  * It'll Generate a `xx.pdf`
  * It'll Generate a `xx.toc`(Table of Content)
  * But the TOC in the PDF is **EMPTY**

* Run `xelatex` for the Second Time
  * It'll Re-Generate `xx.pdf` with `xx.toc` to Create the TOC in the PDF

## References
* [How can I compile my .tex file into a .pdf in terminal?](https://tex.stackexchange.com/questions/312812/how-can-i-compile-my-tex-file-into-a-pdf-in-terminal)
