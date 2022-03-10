# Add Pagebreak When Convert Markdown to PDF via Pandoc

## Problem
* Need to add pagebreak in Markdown files when convert Markdown files to PDF via Pandoc

## Solution
* Use LaTex command: `\pagebreak` directly in Markdown file

## Example

```
# My Article Title

## Chapter 1

A long long story starts...

Should start a new page for the long story.

\pagebreak

The long story continues in a new page
```

## References
* [pagebreak in markdown while creating pdf](https://stackoverflow.com/questions/22601053/pagebreak-in-markdown-while-creating-pdf)
* [Pandoc markdown page break](https://newbedev.com/pandoc-markdown-page-break)
