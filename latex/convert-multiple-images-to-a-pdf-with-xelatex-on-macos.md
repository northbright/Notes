# Convert Multiple Images to a PDF with XeLaTex on macOS

## Problem
* Installed [MacTex](https://tug.org/mactex/) on macOS
* Need to Convert Multiple Images to a Single PDF

## Solution
Create a `.tex` file and use XeLaTex to output a PDF.

* Go to the Image Dirs and Make an Output Dir
  
  ```bash
  cd ~/xx/images
  mkdir out
  ```

  ```
  +images/
  |
  +--out/
  |
  +--01.png
  +--02.png
  +--03.png
  +--04.png
  ```

* Create a `.tex`

  ```bash
  vi a.tex
  ```

  ```tex
  \documentclass[UTF8]{ctexart}
  \usepackage{graphicx}
  \usepackage{geometry}
  \geometry{left=1cm,right=1cm,top=2cm,bottom=2cm}

  \begin{document}

  \begin{figure}[htbp]
  \centering
  \includegraphics[scale=0.5]{01.png}
  \end{figure}

  \begin{figure}[htbp]
  \centering
  \includegraphics[scale=0.5]{02.png}
  \end{figure}

  \begin{figure}[htbp]
  \centering
  \includegraphics[scale=0.5]{03.png}
  \end{figure}

  \begin{figure}[htbp]
  \centering
  \includegraphics[scale=0.5]{04.png}
  \end{figure}

  \end{document} 
  ```

* Compile to PDF via `xelatex`

  ```bash
  xelatex -output-directory ./out a.tex
  ```

  * It'll Generate a `./out/a.pdf`
  ```bash
  ls ./out/a.pdf
  ```

## References
* [Page size and margins](https://www.overleaf.com/learn/latex/Page_size_and_margins)
* [Inserting Images](https://www.overleaf.com/learn/latex/Inserting_Images)
