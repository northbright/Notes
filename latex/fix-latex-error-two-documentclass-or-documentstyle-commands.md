# Fix "LaTeX Error: Two \documentclass or \documentstyle commands."

## Problem
Got "LaTeX Error: Two \documentclass or \documentstyle commands." when run `xelatex` to compile tex files into a PDF.

## Root Cause
There're two `\documentclass` in the .tex file:

```latex
\documentclass[UTF8]{ctexart}
......
\documentclass[UTF8,nofonts]{ctexart}
```

## Solution
* Keep only one `\documentclass`
