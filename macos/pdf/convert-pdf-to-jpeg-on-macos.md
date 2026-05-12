# Convert PDF to JPEG on macOS

## Problem
* Need to export a PDF page(image) to a JPEG
* Keep the image quality

## Solution
Export PDF page using Preview App with a high DPI setting(e.g. `150`).

* Open the PDF via Preview App
* Select the page which need to convert to a JPEG
* Go to File > Export > Select JPEG > Set DPI to a higher value(e.g. `150`)

  * Default DPI is set to `72` and the exported JPEG may has lower resolution.
  * For most situations, 150 DPI hits the sweet spot.

  | DPI | Letter Page Size | File Size (typical) | Best For |
  | :--: | :--: | :--: | :--: |
  | 72 | 612 x 792 px | 50-200 KB | Email, quick previews, social media thumbnails |
  | 150 | 1275 x 1650 px | 200-600 KB | Presentations, websites, general sharing |
  | 300 | 2550 x 3300 px | 500 KB - 2 MB | Printing, high-res displays, archival |

## References
* [How to Turn PDF Pages Into Images (Without Losing Quality)](https://thefreeconverter.com/blog/convert-pdf-to-jpg-images-guide)

