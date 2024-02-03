# Got "Package minted Error: Missing Pygments output" Error when Run Xelatex to Compile Tex Using minted for Code Highlighting

## Problem
* OS: macOS Sonoma 14.0
* Tex file path: `~/my_book/my_book.tex`
* Run the Commands
  ```
  cd ~/my_book
  xelatex -shell-escape -output-dir ./output my_book.tex
  ```
* Got "Package minted Error: Missing Pygments output" Error

## Root Cause
#### TLDR;
minted needs to read `xx.pyg` to run `pygmentize` as input but it searchs `xx.pyg` in the current working dir.

#### Details
* minted Outputs a `.pyg` for the Code in the Output Dir
* minted Makes Dir `(_minted-XX)` in Current Working Dir and Outputs a `default.pygstyle` in It.
* minted Needs to Read the `.pyg` File to Run `pygmentize` as Input to Ouput a `_minted-XX/XX.pygtex`
* minted Searchs the `.pyg` in Current Working Dir
* Report Error if Can NOT Find `.pyg` File
* For More Details, See the `xx.log` in Output Dir:

  >  (./xx.tex
     \openout3 = `my_book.pyg'.

     runsystem(pygmentize -S default -f latex -P commandprefix=PYG > _minted-my_book
     /default.pygstyle)...executed.

     (./_minted-my_book/default.pygstyle)
     runsystem(pygmentize -l 'shell' -f latex -P commandprefix=PYG -F tokenmerge -P
     stripnl='False' -o _minted-my_book/EE19E9BC2E8206EFA93C87A9FD477E1288C7AECC944A
     B63CE08357FF6C62E716.pygtex my_book.pyg)...executed.

     ! Package minted Error: Missing Pygments output; \inputminted was
     probably given a file that does not exist--otherwise, you may need
     the outputdir package option, or may be using an incompatible build tool,
     or may be using frozencache with a missing file.

     ....

     This could be caused by using -output-directory or -aux-directory
     without setting minted's outputdir, or by using a build tool that
     changes paths in ways minted cannot detect,
     or using frozencache with a missing file.

## Solution

#### Method A

Pass output dir to both `xelatex` and `minted`.

* Set `--output-directory` Option for Xelatex and Set `outputdir` Variable for minted when Run Xelatex

  ```
  xelatex --shell-escape --output-directory=<out_dir> "\def\outputdir{<out_dir>} \input{<source_dir>/main.tex}"
  ```

* Add `outputdir` Option for minted in Tex File 

  ```
  \usepackage[outputdir=\outputdir]{minted}
  ```

#### Method B(recommeded)

Run `xelatex` without `-output-directory` option and it makes output dir the same as current working dir.

```
cd ~/my_book
xelatex -shell-escape my_book.tex
```

## References
* [minted environment not working in overleaf](https://tex.stackexchange.com/questions/531738/minted-environment-not-working-in-overleaf)
* [LaTeX Minted package using custom output-directory=build](https://tex.stackexchange.com/questions/339931/latex-minted-package-using-custom-output-directory-build)
* [outputdir alternative? #264](https://github.com/gpoore/minted/issues/264)
