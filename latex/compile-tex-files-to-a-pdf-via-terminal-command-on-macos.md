# Compile a Tex File to a PDF via Terminal Command on macOS

## Problem
* Installed [MacTex](https://tug.org/mactex/) on macOS
* Need to Use Command Line to Compile a Tex Files to a PDF

## Solution
Run `xelatex` **2** times to compile the Tex File.

* Set Working Dir(contains xx.tex file) to Make `xelatex` Find All `.tex` Files when Using `\include{}` Commands in Any `.tex` File

  ```
  cd ~/my_book
  ```

* Run `xelatex` for the First Time to Write `.aux` Files for Cross-References and `.toc` for Table of Content

  ```
  xelatex -output-directory ~/output xx.tex
  ```

* Run `xelatex` for the Second Time to Generate the Final `.pdf` with Cross-References and Tableof Content(TOC)

  ```
  xelatex -output-directory ~/output xx.tex
  ```

## References
* [How can I compile my .tex file into a .pdf in terminal?](https://tex.stackexchange.com/questions/312812/how-can-i-compile-my-tex-file-into-a-pdf-in-terminal)
* [Prevent pdflatex from writing a bunch of files](https://tex.stackexchange.com/questions/11123/prevent-pdflatex-from-writing-a-bunch-of-files)
