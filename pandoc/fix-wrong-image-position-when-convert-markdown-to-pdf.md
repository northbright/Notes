# Fix Wrong Image Position when Convert Markdown to PDF

## Problem
* When use Pandoc to convert Markdown files to PDF, the images goes to the wrong posistions
* The images in page 1 goes to page 2

## Solution
Use `-f markdown-implicit_figures \` when run `pandoc`

## References
* [Markdown to PDF using Pandoc](http://j3soon.com/notes/markdown-to-pdf-using-pandoc/)
