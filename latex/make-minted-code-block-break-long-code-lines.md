# Make minted Code Block Break Long Code Lines

## Problem
Long code lines are out of page range.

## Solution
Set `breaklines` and `linenos` options for minted.

```latex
\begin{minted}[linenos,tabsize=2,breaklines]{golang}
package main

import (
        "log"

        "github.com/northbright/tex2pdf"
)

func main() {
        // a very very very very very very very long comment.
        ......
}
\end{minted}
```

## References
* [break lines in minted code](https://tex.stackexchange.com/questions/129383/break-lines-in-minted-code)

