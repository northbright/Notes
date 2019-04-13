# Add Double Quote for File Names in BAT File

## Problems
* Need to write a BAT file to call [ImageMagick](https://www.imagemagick.org) to resize all images in a folder
* It failed when the file name contain spaces
* The BAT file:

      for /r %%i in (*.jpg *.jpeg *.png) do (
          magick mogrify -density 72 -resize 413x551! %%i
      )
      

## Solution
Add double quote for file names

      for /r %%i in (*.jpg *.jpeg *.png) do (
          magick mogrify -density 72 -resize 413x551! "%%i"
      )
