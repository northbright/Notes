# Resize Image Using FFmpeg

## Problem
* Need to resize the image to reduce the file size

## Solution
Use FFmpeg to scale the image.

* Specify both width and height

```
ffmpeg -i input.jpg -vf scale=320:240 output.jpg
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

## References
* [Use ffmpeg to resize image](https://newbedev.com/use-ffmpeg-to-resize-image)
* [Image Scaling - 2020](https://www.bogotobogo.com/FFMpeg/ffmpeg_image_scaling_jpeg.php)
