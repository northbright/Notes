# Bold Texts Disapper in Terminal

## Problem
* Bold texts(`** content **`) disappear when write a README.md(Markdown) in vim
* Some texts also disapper when run `git diff`

## Root Cause
* "Terminal" > "Preferences" > "Text" > Profile's "Background Color" and "Bold Text Color" are both set to "black"

## Solution
* Set different colors for "Background Color" and "Bold Text Color"
