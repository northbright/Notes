# Make a Signature Page Using LaTex

## Problem
* Using LaTex to Create a Contract
* Last Page is Used to Sign and Seal the Agreement
* Need to Split the Page in Half Horizontally

  | Party A | Party B |
  | :---: | :---: |
  | Party A Seal | Party B Seal |
  | Party A Signature | Party B Signature |

## Solution
Use `figure`, `hbox` and `vbox`.

```LaTex
\section{双方确认和签署}

\vspace{2cm}

\begin{figure}[htbp]
  \hfil
  \vbox{ % body container
    \hbox{
      \large
      \vbox{\hsize 0.5\textwidth \centering 甲方: \{\{ .PartyA \}\}盖章}
      \kern 3em
      \large
      \vbox{\hsize 0.5\textwidth \centering 乙方: \{\{ .PartyB \}\}盖章}
    }
    \vskip 18em
    \hbox{
      \vbox{\hsize 0.5\textwidth \centering 法定代表人或其授权代表签字：}
      \kern 3em
      \vbox{\hsize 0.5\textwidth \centering 法定代表人或其授权代表签字：}
    }
    \vskip 1.3em
  }
  \hfil
\end{figure}

\hspace{0.5cm}
```

## References
* [使用 TeX 盒子的两个例子](https://zhuanlan.zhihu.com/p/362226568)
* [How can I get my table or figure to stay where they are, instead of going to the next page?](https://www.overleaf.com/learn/latex/Questions/How_can_I_get_my_table_or_figure_to_stay_where_they_are%2C_instead_of_going_to_the_next_page%3F)

--------------

# 使用 LaTex 制作 1 个签名页

## 问题
* 使用 Latex 来制作 1 份合同
* 最后 1 页用来盖章和签名
* 需要水平分割页面成等宽的 2 份

  | 甲方 | 乙方 |
  | :---: | :---: |
  | 甲方盖章 | 乙方盖章 |
  | 甲方签字 | 乙方签字 |

## 解决方法
使用 `figure`, `hbox` 和 `vbox`。

```LaTex
\section{双方确认和签署}
  
\vspace{2cm} 
  
\begin{figure}[htbp]
  \hfil
  \vbox{ % body container
    \hbox{
      \large
      \vbox{\hsize 0.5\textwidth \centering 甲方: \{\{ .PartyA \}\}盖章}
      \kern 3em
      \large
      \vbox{\hsize 0.5\textwidth \centering 乙方: \{\{ .PartyB \}\}盖章}
    }
    \vskip 18em
    \hbox{
      \vbox{\hsize 0.5\textwidth \centering 法定代表人或其授权代表签字：}
      \kern 3em
      \vbox{\hsize 0.5\textwidth \centering 法定代表人或其授权代表签字：}
    }
    \vskip 1.3em
  }
  \hfil
\end{figure}

\hspace{0.5cm}
```

## 参考资料
* [使用 TeX 盒子的两个例子](https://zhuanlan.zhihu.com/p/362226568)
* [How can I get my table or figure to stay where they are, instead of going to the next page?](https://www.overleaf.com/learn/latex/Questions/How_can_I_get_my_table_or_figure_to_stay_where_they_are%2C_instead_of_going_to_the_next_page%3F)
