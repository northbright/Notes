# Resize All Images in a Folder on Windows

## Problem
* Need resize all images in a folder to fixed width and height
* If the image's original width or height is smaller, it should be streched 

## Solutions
Use [ImageMagick](http://www.imagemagick.org) command-line tools: [convert](https://www.imagemagick.org/script/convert.php), [mogrify](https://www.imagemagick.org/script/mogrify.php) in BAT files
* Install the [Windows Binary Release](https://imagemagick.org/script/download.php#windows) of [ImageMagick](http://www.imagemagick.org)
* Create BAT Files
  * Resize original images directly without generating new files 
     
         for /r %%i in (*.jpg *.jpeg *.png) do (
             magick mogrify -resize 413x551! %%i
         )

  * Generate new resized images

         for /r %%i in (*.jpg *.jpeg *.png) do (
             magick convert %%i -resize 413x551! "%%i-resized.jpg"
         )

## References
* [ImageMagick change image width and height](https://stackoverflow.com/questions/26560393/imagemagick-change-image-width-and-height)
* [In ImageMagick, how can I scale an image down just enough so it's cropped to particular dimensions?](https://stackoverflow.com/questions/12222839/in-imagemagick-how-can-i-scale-an-image-down-just-enough-so-its-cropped-to-par)
* [ImageMagick Tutorial: How To Batch Resize Images on the Command Line](https://dototot.com/imagemagick-tutorial-batch-resize-images-command-line/)
* [A Batch Script To Resize Images [closed]](https://stackoverflow.com/questions/40456998/a-batch-script-to-resize-images)
* [Iterate all files in a directory using a 'for' loop](https://stackoverflow.com/questions/138497/iterate-all-files-in-a-directory-using-a-for-loop)
* [Image Geometry](https://www.imagemagick.org/script/command-line-processing.php#geometry)
