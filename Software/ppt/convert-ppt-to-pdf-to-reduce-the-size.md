# Convert PPT to PDF to Reduce the Size

## Problem
* Open PPT via Keynote on macOS 
* PPT contains a lot of images and its size is very large(100 MB+)
* Need to reduce the size of PPT

## Solution
Convert PPT to PDF format via Keynote and re-export the PDF using Preview App with Quartz filter set to "Reduce File Size".

1. Convert PPT to PDF format via Keynote

  * Go to File > Export > to PDF > Image Quality > Good(lowest quality)
  * The generated PDF' size is smaller(38 MB)

2. Open the PDF in Preview App and **re-export** to another PDF

  * Go to File > Format > PDF > Quartz filter > "Reduce File Size" > Output to another PDF
  * The outputed PDF size is 4.9 MB

## References
* [Keynote creating very large PDF files](https://discussions.apple.com/thread/253675276?sortBy=rank)
