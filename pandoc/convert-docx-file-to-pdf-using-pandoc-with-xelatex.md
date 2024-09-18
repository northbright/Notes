# Convert .docx File to PDF using Pandoc with XeLaTex

## Problem
* Use [Pandoc](https://pandoc.org/) to convert ".docx" files to PDF on macOS.
* [Tex Live](https://tug.org/texlive/) is installed on macOS.
* ".docx" files cotains Chinese Characters and set CJK main font to "苹方-简".
* ".docx" files contains the International Phonetic Alphabet(IPA) symbols.
* Run `pandoc "考纲词汇默写01.docx" -o "考纲词汇默写01.pdf" --pdf-engine=xelatex -V CJKmainfont="苹方-简"`
* Got error:

  > Missing character: There is no ɡ (U+0261) (U+0261) in font [lmroman10-regular]:mapping=t

## Root Cause
Main font does not contain International Phonetic Alphabet(IPA) symbols.

## Solution
* Download the fonts support IPA(e.g. [Gentium Plus](https://software.sil.org/gentium/)).
* Install the font on macOS.
* Run Pandoc and set main font to the downloaded font.

  ```bash
  pandoc "考纲词汇默写01.docx" -o "考纲词汇默写01.pdf" --pdf-engine=xelatex -V CJKmainfont="苹方-简" -V mainfont="Gentium Plus"
  ```

## References
* [Converting Markdown to Beautiful PDF with Pandoc](https://jdhao.github.io/2019/05/30/markdown2pdf_pandoc/)
* [Adding complex phonetic symbols to LaTeX](https://tex.stackexchange.com/questions/304284/adding-complex-phonetic-symbols-to-latex)
* [How to use phonetic IPA characters in LaTeX](https://tex.stackexchange.com/questions/36542/how-to-use-phonetic-ipa-characters-in-latex)
* [Gentium Plus](https://software.sil.org/gentium/)
* [用LaTeX写国际音标表(IPA)](https://zhuanlan.zhihu.com/p/33739821)
* [在 Mac 上的“字体册”中安装和验证字体](https://support.apple.com/zh-cn/guide/font-book/fntbk1000/mac)
* [How to Install and Manage Your Fonts on Mac](https://www.howtogeek.com/install-manage-mac-fonts/)
