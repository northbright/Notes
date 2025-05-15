# Use ffprobe to Get Resolution of Input

## Problem
* Need to get resolution of input video or image using command line
* Get resolution only

## Solution
Use [ffprobe](https://ffmpeg.org/ffprobe.html).

## Example
* Get resolution of a video or an image.

```bash
ffprobe -v error -select_streams v:0 -show_entries stream=width,height -of csv=s=x:p=0 input.mp4

// Output:
1280x720
```

```bash
ffprobe -v error -select_streams v:0 -show_entries stream=width,height -of csv=s=x:p=0 01.png

// Output:
1280x720
```

* `-v error` makes the output less verbose.
* `-select_streams v:0` selects only the first video stream.
* `-show_entries stream=width,height` chooses only width and height from the big list of parameters that ffprobe can provide.
* `-of csv=s=x:p=0` formats the text output.
  * The csv formatting type is used because it makes a simple output.
  * `s=x` makes it use an `x` to separate the width and height values.
  * `p=0` makes it omit the stream prefix in the output.

## References
* [One liner ffmpeg (or other) to get only resolution?](https://askubuntu.com/questions/577090/one-liner-ffmpeg-or-other-to-get-only-resolution)
