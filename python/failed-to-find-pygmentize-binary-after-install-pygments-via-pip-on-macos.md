# Failed to Find pygmentize Binary after Installed pygments via PiP on macOS

## Problem
* macOS: Sonoma 14.0
* Want to Use [Code Highlighting with minted](https://www.overleaf.com/learn/latex/Code_Highlighting_with_minted) in LaTex
* [minted](https://ctan.org/pkg/minted?lang=en) Requires [pygments](https://pygments.org/) to be Installed
* Run `python3 -m pip install pygments` to Install [pygments](https://pygments.org/)
* Xelatex Can Not Find `pygmentize` Binary in Terminal

## Root Cause
* `python3 -m pip install pygments` Installs pygments for Current User
* Binary Location: `/Users/xx/Library/Python/3.9/bin`

## Solution
Add `/Users/xx/Library/Python/3.9/bin` to `PATH` variable.

* Run `vi ~/.zprofile` and Add Binary Path of Python

  ```
  ......
  ## Python
  export PATH=$PATH:/Users/xxu/Library/Python/3.9/bin
  ```

* Run `source ~/.zprofile`
