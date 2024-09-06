# Make Tables of Content become Links to the Corresponding Pages

## Solution
Use "hyperref" package in the preamble of the document.

```latex
\documentclass{article}

\usepackage{hyperref}
\hypersetup{
    colorlinks=true,
    linkcolor=blue,
    filecolor=magenta,      
    urlcolor=cyan,
}

\usepackage{fancyhdr}

\begin{document}

% Title Page
\include{00-title}

% Table of Contents
\tableofcontents
\clearpage

\pagestyle{fancy}
\fancyhf{} % sets both header and footer to nothing
\renewcommand{\headrulewidth}{0pt}
\cfoot{\thepage}

\include{01-xx}
\include{02-xx}
\include{03-xx}

\end{document}
```

## References
* [Hyperlinks](https://www.overleaf.com/learn/latex/Hyperlinks)
* [How can I make a clickable Table of Contents?](https://tex.stackexchange.com/questions/73862/how-can-i-make-a-clickable-table-of-contents)
