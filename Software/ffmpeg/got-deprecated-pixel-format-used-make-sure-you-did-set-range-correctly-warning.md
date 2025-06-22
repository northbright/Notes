# Got "deprecated pixel format used make sure you did set range correctly" Warning

## Problem
* Convert input JPEG images to MP4

  ```bash
  ffmpeg \
  -i "op.jpg" \
  -filter_complex " \
  [0:v:0]fps=30,loop=loop=90:size=1,scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,setsar=1:1,format=pix_fmts=yuv420p[op_v]" \
  -map "[op_v]" \
  output.mp4
  ```

* Got warning:

  > [swscaler @ 0xXX] deprecated pixel format used, make sure you did set range correctly

## Root Cause
The warning is displayed because:
The pixelformat of your input source (the jpeg file) uses a deprecated pixelformat with a different range for luma and chroma as your output pixelformat, this can lead to differences in color and/or brightness.

* yuvj422p is the deprecated pixelformat used by your jpg files (range 0-255 for luma and chroma) 16 bpp
* yuv420p is the pixelformat of your output. (range 16-235 for luma and 16-240 for chroma) 12 bpp

So three conversions need to be made here:
* yuv conversion from 4:2:2 to 4:2:0
* range conversion for y
* range conversion for uv

## Solution
Just ignore the warning.

## References
* [[FFmpeg-user] deprecated pixel format used, make sure you did set range correctly](https://lists.ffmpeg.org/pipermail/ffmpeg-user/2023-June/056488.html)
* [deprecated pixel format used, make sure you did set range correctly](https://superuser.com/questions/1273920/deprecated-pixel-format-used-make-sure-you-did-set-range-correctly)
