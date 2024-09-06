# Set Paper Size and Margin for LaTex Document

## Solution
Use geometry package to specify the paper size and margin.

```latex
\documentclass{article}

\usepackage{geometry}
 \geometry{
 a4paper,
 total={170mm,257mm},
 left=20mm,
 top=20mm,
 }
```

## References
* [Page size and margins](https://www.overleaf.com/learn/latex/Page_size_and_margins)
