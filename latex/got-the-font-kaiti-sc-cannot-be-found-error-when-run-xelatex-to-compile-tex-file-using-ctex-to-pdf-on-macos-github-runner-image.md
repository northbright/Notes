# Got "The font Kaiti SC cannot be found" Error when Run `xelatex` to Compile Tex File with ctex to PDF on macOS Github Runner Image

## Problem
* Use Github Action to Run `xelatex` to Compile a ".tex" file to a PDF
* Use [teatimeguest/setup-texlive-action](https://github.com/teatimeguest/setup-texlive-action) to Install Tex Live
* Runner Image: `macOS-14`
* It Compiles the Tex Files into a PDF Successfully **WITHOUT** Chinese and ctex Package
* It Failed to Compile and Got Error when Using ctex package for Chinese Support: 
  > "The font Kaiti SC cannot be found"

* Action: `build.yml`

```yml
name: Build

on:
- push

jobs:
  build:
    name: Build
    runs-on: ${{ matrix.os }}
    strategy:
      matrix:
        os:
        - macos-14

      fail-fast: false
    steps:
    - name: Checkout source codes
      uses: actions/checkout@v4
    - name: Setup Texlive
      uses: teatimeguest/setup-texlive-action@v3
      with:
        packages: >-
          scheme-small
          ctex
          fandol
          minted

    - name: Setup Python
      uses: actions/setup-python@v5
      with:
        python-version: '3.10' 

    - name: Setup pygmentize
      run: python3 -m pip install pygments && pygmentize -V

    - name: Check XeLaTex Version
      run: xelatex --version

    - name: xelatex test
      run: xelatex -synctex 1 -interaction nonstopmode -8bit -shell-escape my_book.tex
```

## Root Cause
* "Kaiti SC"(Kaiti.ttc) are required by ctex package on macOS even your tex file **NOT** using "Kaiti".
  * In `texlive/2023/texmf-dist/tex/latex/ctex/fontset/ctex-fontset-macnew.def`:

* Kaiti.ttc is NOT installed on Github Runner Image of macOS-14(or other macOS runner images).

## Solution
* Use free Fandol fonts for Chinese documents, which are preinstlled in latest TeX Live (MacTeX).

  ```latex
  \documentclass[UTF8,nofonts]{ctexart}
  \setCJKmainfont[BoldFont=FandolSong-Bold.otf,ItalicFont=FandolKai-Regular.otf]{FandolSong-Regular.otf}
  \setCJKsansfont[BoldFont=FandolHei-Bold.otf]{FandolHei-Regular.otf}
  \setCJKmonofont{FandolFang-Regular.otf}
  ```

* Install fandol with "teatimeguest/setup-texlive-action" in Github Action job.

  ```yml
    - name: Setup Texlive
      uses: teatimeguest/setup-texlive-action@v3
      with:
        packages: >-
          scheme-small
          ctex
          fandol
  ```

* Download `kaiti.ttf` in Github Action job.

  ```yml
  - name: Download font files
    run: |
      mkdir -p ~/Library/Fonts
      curl "https://p15.p3.n0.cdn.zight.com/items/eDueDDv9/a605729f-c1d2-4131-b805-e870615b43aa.ttc" -o ~/Library/Fonts/Kaiti.ttc
  ```

  The download link of `kaiti.ttf` is from <https://github.com/TomBener/quarto-action-pdf/blob/main/.github/workflows/quarto-publish.yml>

## Example of Tex File
`my_book.tex`

```latex
\documentclass[UTF8,nofonts]{ctexart}
\setCJKmainfont[BoldFont=FandolSong-Bold.otf,ItalicFont=FandolKai-Regular.otf]{FandolSong-Regular.otf}
\setCJKsansfont[BoldFont=FandolHei-Bold.otf]{FandolHei-Regular.otf}
\setCJKmonofont{FandolFang-Regular.otf}

\begin{document}
你好，世界！
\end{document}
```

## Example of Github Action
```yml
name: Build

on:
- push

jobs:
  build:
    name: Build
    runs-on: ${{ matrix.os }}
    strategy:
      matrix:
        os:
        - macos-14

      fail-fast: false
    steps:
    - name: Checkout source codes
      uses: actions/checkout@v4

    - name: Download font files
      run: |
        mkdir -p ~/Library/Fonts
        curl "https://p15.p3.n0.cdn.zight.com/items/eDueDDv9/a605729f-c1d2-4131-b805-e870615b43aa.ttc" -o ~/Library/Fonts/Kaiti.ttc

    - name: Setup Texlive
      uses: teatimeguest/setup-texlive-action@v3
      with:
        packages: >-
          scheme-small
          ctex
          fandol
          minted

    - name: Setup Python
      uses: actions/setup-python@v5
      with:
        python-version: '3.10' 

    - name: Setup pygmentize
      run: python3 -m pip install pygments && pygmentize -V

    - name: Check XeLaTex Version
      run: xelatex --version

    - name: xelatex test
      run: xelatex -synctex 1 -interaction nonstopmode -8bit -shell-escape my_book.tex
```

## References
* [Issue with Chinese Font Detection in Quarto GitHub Action for PDF Output #103](https://github.com/quarto-dev/quarto-actions/issues/103)
* [quarto-publish.yml](https://github.com/TomBener/quarto-action-pdf/blob/main/.github/workflows/quarto-publish.yml)
* [New Mac cannot find fonts Kaiti SC #540](https://github.com/CTeX-org/ctex-kit/issues/540)
