# Get Low Resolution Image when Export a PDF Page to a JPEG using Preview App on macOS

## Problem
* Export a PDF page to a JPEG using Preview App on macOS
* The image resolution is low(e.g. `595x841`)

## Root Cause
* The DPI is `72` by default and it's too low

## Solution
Set DPI to `150` to increase the resolution.

## References
* [Convert PDF to JPEG on macOS](https://github.com/northbright/Notes/blob/master/macos/pdf/convert-pdf-to-jpeg-on-macos.md)
* [How to Turn PDF Pages Into Images (Without Losing Quality)](https://thefreeconverter.com/blog/convert-pdf-to-jpg-images-guide)
