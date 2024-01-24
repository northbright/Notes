# Run `xelatex` Command in Github Actions Runner

## Problem
* Need to Run `xelatex` Command in Github Actions Runner

## Solution
Use [setup-texlive-action](https://github.com/teatimeguest/setup-texlive-action) with `scheme-full`

```
    - name: Setup Texlive
      uses: teatimeguest/setup-texlive-action@v3
      with:
        packages: >-
          scheme-full

    - name: Check XeLaTex Version
      run: xelatex --version
```

## References
* [setup-texlive-action](https://github.com/teatimeguest/setup-texlive-action)
* [关于 tlmgr 使用方法的简介](https://ctan.math.washington.edu/tex-archive/info/tlmgr-intro-zh-cn/tlmgr-intro-zh-cn.pdf)

 
