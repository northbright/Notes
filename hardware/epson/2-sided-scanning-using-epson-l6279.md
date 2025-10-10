# 2-Sided Scanning using Epson L6279

## Problem
* EPSON L6279 supports 1-Sided scanning only
* Need to do 2-Sided scanning

## Solution
Scan all papers to a PDF 2 times(one for front side and one for back side) and using PDF software to merge all pages.

1. Put papers(front side) to the Automatic Document Feeder
2. Launch EPSON SmartScan and click Scan
3. Save as a PDF file(e.g. `1.pdf`)
4. Do step 1 - 3 again for back side and get another PDF(e.g. `2.pdf`)
5. Run Foxit PDF editor > Open `2.pdf` > Page Management Tab > Reverse the pages > Save
6. Run Foxit PDF editor > Open `1.pdf` > Page Management Tab > Cross Merge > Select `1.pdf` for Odd Number Pages and select `2.pdf` for Even Number Pages > Confirm

## References
* [单面输稿器打印机如何大量双面扫描并整合出文档](https://www.bilibili.com/video/BV1PP411S7s7)
