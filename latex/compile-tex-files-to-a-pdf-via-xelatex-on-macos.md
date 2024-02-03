# Compile a Tex File to a PDF via `xelatex` on macOS

## Problem
* Installed [MacTex](https://tug.org/mactex/) on macOS
* Need to Use Command Line to Compile a Tex Files to a PDF

## Solution
Run `xelatex` **2** times to compile the Tex File.

#### Step 1
To make `xelatex` can find All `.tex` files when using `\include{}` commands in any `.tex`,
there're 2 methods.

* Method A(recommended)
  
  Change working dir to the dir contains `xx.tex`(e.g. `~/my_book/xx.tex`).

  ```
  cd ~/my_book
  ```

* Method B

  **UPDATE**: Method B can **NOT** work if using `minted` package for code highlighting.
  See: [Got "Package minted Error: Missing Pygments output" Error when Run Xelatex to Compile Tex Using minted for Code Highlighting](https://github.com/northbright/Notes/blob/master/latex/got-package-minted-error-missing-pygments-output-when-run-xelatex-to-compile-tex-using-minted-for-code-highlighting.md)
  
  Add local Tex path into `TEXINPUTS` variable.

  ```
  // 1. Make sure put local tex path **AFTER** old TEXINPUTS var(it's empty infact)
  //    or we'll get LaTeX Error: "File `ctexart.cls' not found".
  //
  // 2. The "//" means that TeX programs will search recursively in that folder.
  export TEXINPUTS=$TEXINPUTS:~/my_book//
  ```

#### Step 2
Run `xelatex` **2** times to compile the Tex File.

* Run `xelatex` for the First Time to Write `.aux` Files for Cross-References and `.toc` for Table of Content

  ```
  xelatex -output-directory ~/output ~/my_book/xx.tex
  ```

* Run `xelatex` for the Second Time to Generate the Final `.pdf` with Cross-References and Tableof Content(TOC)

  ```
  xelatex -output-directory ~/output ~/my_book/xx.tex
  ```

## References
* [How can I compile my .tex file into a .pdf in terminal?](https://tex.stackexchange.com/questions/312812/how-can-i-compile-my-tex-file-into-a-pdf-in-terminal)
* [Prevent pdflatex from writing a bunch of files](https://tex.stackexchange.com/questions/11123/prevent-pdflatex-from-writing-a-bunch-of-files)
* [Definition of the TEXINPUTS variable](https://tex.stackexchange.com/questions/93712/definition-of-the-texinputs-variable)
