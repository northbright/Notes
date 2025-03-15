# Use otf2otc to Build ttc from Mutiple otfs

## Problem
* Use [afdko](https://github.com/adobe-type-tools/afdko/) to build [Source Han Serif](https://github.com/adobe-fonts/source-han-serif) from source
* Need to build OpenType Collection font file(`.ttc` or `.otc`) from two or more OpenType font files(`.otc`)

## Solution
Use `otf2otc` which comes with [afdko](https://github.com/adobe-type-tools/afdko/) to build `.ttc` file from multiple `.otf` files.

* [Install afdko on macOS for China User](https://github.com/northbright/Notes/blob/master/font/install-afdko-on-macos-for-china-user.md)

* Make sure activate Python virtual env for `afdko_env` in last step

  ```shell
  source ~/download/afdko_env/bin/activate
  ```

* Run `otf2otc`

  ```shell
  otf2otc -o <output ttc file> <input otf 1> <input otf 2> ...
  ```
  e.g. 

  ```shell
  otf2otc -o SourceHanSerifSC.ttc SourceHanSerifSC-Regular.otf SourceHanSerifSC-Bold.otf
  ```

  You may run `otf2otc -h` for more help.

* Deactivate Python virtual env after use

  ```shell
  deactivate
  ```

## References
* [如何打包或解包 TrueType Collection (TTC) 文件？](https://www.zhihu.com/question/24071424)
