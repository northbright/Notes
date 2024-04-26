# Resize Image Using FFmpeg

## Problem
* Need to resize the image to reduce the file size

## Solution
Use FFmpeg to scale the image.

* Specify both width and height

```
ffmpeg -i input.jpg -vf scale=3840:2160 output.jpg
```

* Specify only width or height and set another to `-1`, let ffmpeg calculate the dimension automatically

```
ffmpeg -i input.jpg -vf scale=320:-1 output.jpg
```

* Scale the image based on the original width(`iw`) or height(`ih`)

```
// Resized width / height: half of the original width / height
ffmpeg -i input.jpg -vf scale=iw/2:ih/2 output.jpg
```

## Solution(Batch Resize)
* Create a Shell Script

  ```
  vi batch-resize.sh
  ```

  ```
  #!/bin/sh

  find . -type f -name "*.jpg" -exec sh -c '
      name="${1%.*}"
      echo "$name"
      ffmpeg -i "$1" -vf scale=3840:2160 "$name"_4k.jpg
      rm -f $1
  ' find-sh {} \;
  ```

* Add Execution Permission

  `chmod a+x batch-resize.sh`

* Copy the Shell Script to the Dir Contains Image Files(.jpg) and Run it

## References
* [Use ffmpeg to resize image](https://newbedev.com/use-ffmpeg-to-resize-image)
* [Image Scaling - 2020](https://www.bogotobogo.com/FFMpeg/ffmpeg_image_scaling_jpeg.php)
* [ffmpeg batch command to reduce file quality](https://unix.stackexchange.com/questions/609734/ffmpeg-batch-command-to-reduce-file-quality)
* [use find command for recursive conversion using ffmpeg](https://superuser.com/questions/1532996/use-find-command-for-recursive-conversion-using-ffmpeg)
* [Scaling](https://trac.ffmpeg.org/wiki/Scaling)
