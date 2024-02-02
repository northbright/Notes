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
* minted Need to specify `outputdir` if output dir is NOT current working dir

  ```
  \usepackage[outputdir=../]{minted}
  ```

## Solution
Set xelatex output dir to the current working dir(NOT using `-outout-dir` option).

```
cd ~/my_book
xelatex -shell-escape my_book.tex
```

## References
* [minted environment not working in overleaf](https://tex.stackexchange.com/questions/531738/minted-environment-not-working-in-overleaf)
