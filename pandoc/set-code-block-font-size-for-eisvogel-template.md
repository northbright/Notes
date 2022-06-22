# Set Code Block Font Size for [Eisvogel](https://github.com/Wandmalfarbe/pandoc-latex-template) template

## Problem
* Use [Pandoc](https://pandoc.org/) with [Eisvogel](https://github.com/Wandmalfarbe/pandoc-latex-template) to convert Markdown files to PDF
* Default font size of code block is too large for me
* Need to set code block size

## Solution
* Set `code-block-font-size` in `src/titile.txt`

  ```
  code-block-font-size: \scriptsize
  ```

* Run Pandoc with `--listings` flag

## References
* [How do I set the fenced code font size smaller? #17](https://github.com/Wandmalfarbe/pandoc-latex-template/issues/17)
* [Font size #123](https://github.com/Wandmalfarbe/pandoc-latex-template/issues/123)
* [Eisvogel](https://github.com/Wandmalfarbe/pandoc-latex-template)
* [Write a Book with Markdown](https://pianomanfrazier.com/post/write-a-book-with-markdown/) with [Example: pandoc markdown book](https://gitlab.com/pianomanfrazier/pandoc-markdown-book)
