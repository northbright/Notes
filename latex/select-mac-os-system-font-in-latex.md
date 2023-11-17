# Select macOS System Font(CJK) in LaTex

## Problem
* macOS 14 Sonoma
* [MacTex](https://tug.org/mactex/)(include TeXShop) is Installed
* Use TeXShop to Edit Latex
* Need to Select System CJK Font(e.g. `苹方-简`) in LaTex

## Solution
To select macOS system font in LaTex, we need to use the **"Font Name"**.

* Open Font Book
  * Method A: Press `command` + `space` and Type "Font Book"
  * Method B: Open a Finder > Applications > Font Book
* Select One Font and Click "i" Icon to Show Details of the Font
* The 1st Line is the Font Name（e.g. `苹方-简`)
* Copy the Font Name and Paste it to TexShop
  * Use `ctex` Package

    ```LaTex
    \documentclass[UTF8]{ctexart}
    \setCJKmainfont{苹方-简} % 设置 CJK 主字体
    \begin{document}
    你好，world!
    \end{document}
    ```

  * Use `xeCJK` Package

    ```LaTex
    \documentclass{article}
    \usepackage{xeCJK}% 调用 xeCJK 宏包
    \setCJKmainfont{苹方-简}% 设置 CJK 主字体
    \begin{document}
    你好，world!
    \end{document}
    ```

## References
* [实现中英文混排](https://www.kancloud.cn/thinkphp/latex/41810)
* [[LaTeX 引擎] XeLaTeX + macOS，通过字体名调用发行版字体](https://zhuanlan.zhihu.com/p/59774395)

--------------

# 在 LaTex 中选择 macOS 的系统字体

## 问题
* macOS 14 Sonoma
* 已经安装 [MacTex](https://tug.org/mactex/) （包括 TexShop）
* 需要在 LaTex 中选择 macOS 的系统字体（e.g. `苹方-简`）

## 解决方法
要在 LaTex 中选择 macOS 的系统字体，需要使用**字体名称**

* 打开“字体册”
  * 方法 A：按下 `commmand` + `空格`，输入“字体册”
  * 方法 B：打开“访达” > 应用程序 > 字体册
* 选择 1 个字体，点击 "i" 图标显示详情
* 第一行即为字体名称（e.g. `苹方-简`)
* 复制字体名称到 TexShop 中
  * 使用 `ctex` 包

    ```LaTex
    \documentclass[UTF8]{ctexart}
    \setCJKmainfont{苹方-简} % 设置 CJK 主字体
    \begin{document}
    你好，world!
    \end{document}
    ```
  * 使用 `xeCJK` 包

    ```LaTex
    \documentclass{article}
    \usepackage{xeCJK}% 调用 xeCJK 宏包
    \setCJKmainfont{苹方-简}% 设置 CJK 主字体
    \begin{document}
    你好，world!
    \end{document}
    ```

## 参考资料
* [实现中英文混排](https://www.kancloud.cn/thinkphp/latex/41810)
* [[LaTeX 引擎] XeLaTeX + macOS，通过字体名调用发行版字体](https://zhuanlan.zhihu.com/p/59774395)

