# Write a PDF Book with Markdown

## Problem
* Write a book with Markdown
* Need to output a PDF book

## Solution
Use [Pandoc](https://pandoc.org/) with `xelatex` as PDF engine(`--pdf-engine=xelatex`) using [Eisvogel](https://github.com/Wandmalfarbe/pandoc-latex-template) to convert Markdown files to PDF

* Install [Tex Live](https://tug.org/texlive/) to get `xelatex`

  * Follow "Concise instructions, per platform" to install.

    e.g. Visit [MacTex](https://tug.org/mactex/) to download the Mac distribution

  * **Full Size** Distribution is recommended

    You may need to install packages manually after **Smaller Distribution** installed

  * Check

    Open a Terminal window    

    ```
    which xelatex
    // Output:
    // /Library/TeX/texbin/xelatex
    ```

* Install [Pandoc](https://pandoc.org/)

  * Check

    Open a Terminal window

    ```
    which pandoc
    // Output:
    // /usr/local/bin/pandoc
    ```

* Get Example Code from [pandoc markdown book](https://gitlab.com/pianomanfrazier/pandoc-markdown-book)
  Thanks to Ryan Frazier's [Write a Book with Markdown](https://pianomanfrazier.com/post/write-a-book-with-markdown/).

  This [repo](https://gitlab.com/pianomanfrazier/pandoc-markdown-book) hosts the scripts and other source code metioned in the blog.

  * Use Git to clone / update the repo


    * Clone

      ```
      cd ~/
      git clone https://gitlab.com/pianomanfrazier/pandoc-markdown-book.git
      ```

    * Update

      ```
      cd ~/pandoc-markdown-book
      git pull
      ```

* Update latest [Eisvogel](https://github.com/Wandmalfarbe/pandoc-latex-template) template

  ```
  cd ~/
  git clone https://github.com/Wandmalfarbe/pandoc-latex-template.git
  ```

  ```
  // Copy latest eisvogel.tex
  cp ~/pandoc-latex-template/eisvogel.tex ~/pandoc-markdown-book/templates/
  ```

* Modify `compile_pdf.sh`

  * Backup `compile_pdf.sh`

    ```
    cd ~/pandoc-markdown-book
    cp compile_pdf.sh compile_pdf.sh.bk
    ```

  * Replace `eisvogel.latex` with `eisvogel.tex`

    Set `--template=./templates/eisvogel.tex \`

  * Uncomment `--filter pandoc-crossref \`

  * Set CJK Font(Optional)

    If you need write Chinese or other CJK languages, you need to select the CJK font.

    * Firstly, find out the **font name**

      e.g. * [mac怎么查看系统已安装的字体名录？](https://www.zhihu.com/question/21686333/answer/618481248)

    * Add `CJKmainfont` flag

      ```
      -V CJKmainfont="PingFangSC-Regular" \
      ```

  * Enable Setting Code Block Font Size(Optional)

    ```
    --listings \
    ```

    After add `--listings` in `compile_pdf.sh`, you may set `code-block-font-size` in `src/title.txt`
    See `man pandoc | grep listings` for more infomation.

* Customize `src/title.txt`

  * Enable Title Page

    ```
    titlepage: true
    ```

  * Title Page Background

    * Default Title Page Background PDF: `backgrounds/background10.pdf`

      ```
      titlepage-background: backgrounds/background10.pdf
      ```
  * Set Code Block Font Size(Optional)

    ```
    code-block-font-size: \scriptsize
    ```

    See [How do I set the fenced code font size smaller? #17](https://github.com/Wandmalfarbe/pandoc-latex-template/issues/17) and [Font size #123](https://github.com/Wandmalfarbe/pandoc-latex-template/issues/123) for more information.

* Run `./compile_pdf.sh`

  ```
  ./compile_pdf.sh
  ```

  Check `build/output.pdf`

* Complete Source Code

  * `compile_pdf.sh`

    ```
    mkdir -p build

    # pandoc version 2.7.3
    pandoc \
        --pdf-engine=xelatex \
        --template=./templates/eisvogel.tex \
        --highlight-style tango \
        --toc -N \
        -o build/output.pdf \
        -V CJKmainfont="PingFangSC-Regular" \
        --listings \
        src/title.txt src/*.md
        # --template=./templates/eisvogel.latex \
        # --top-level-division=chapter \
        # --filter pandoc-crossref \
        # -V book \
    ```

  * `src/title.txt`

    ```
    ---
    title: Some Markdown Book
    subtitle: Everything is awesome
    author: Ryan Frazier
    subject: "markdown"
    keywords: [books,programming]
    language: en-US
    cover-image: img/example-book-cover.png
    lof: true
    lof-own-page: true
    toc-own-page: true
    titlepage: true
    titlepage-background: backgrounds/background10.pdf
    titlepage-text-color: "333333"
    titlepage-rule-color: "00737C"
    papersize: letter
    prepend-titlepage: img/example-book-cover.pdf
    colorlinks: true
    code-block-font-size: \scriptsize
    ---
    ```

You may get the modified source code from [Pandoc Markdown Book](https://github.com/northbright/pandoc-markdown-book).

## References
* [Write a Book with Markdown](https://pianomanfrazier.com/post/write-a-book-with-markdown/) with [Example: pandoc markdown book](https://gitlab.com/pianomanfrazier/pandoc-markdown-book)
* [mac怎么查看系统已安装的字体名录？](https://www.zhihu.com/question/21686333/answer/618481248)
* [pandoc 安装与使用](https://zhuanlan.zhihu.com/p/258912543)
