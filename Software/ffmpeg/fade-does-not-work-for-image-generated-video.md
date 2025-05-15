# `fade` does not Work for Image Generated Video

## Problem
* Generate video from 1 image for 3 seconds
* Use [fade](https://ffmpeg.org/ffmpeg-filters.html#fade) filter to apply fade out for 1 second from 00:00:02
* Command

```bash
ffmpeg -framerate 1/3 -i opening.JPG \
-f lavfi -i "aevalsrc=0" \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
subtitles=ending.srt:force_style='Fontsize=18',
fade=t=out:st=2:d=1," \
-pix_fmt yuv420p -r 30 \
-map 0:v -map 1:a -shortest \
./opening.mp4
``` 

* fade does not work

## Root Cause
The fade filter operates upon the frames supplied to it.
It cannot generate new frames.
Without input `-loop`, an image input is just a single frame stream.
See [FFmpeg: Fade in and out from PNG generated video](https://superuser.com/questions/1810004/ffmpeg-fade-in-and-out-from-png-generated-video).

## Solution
Use `-loop 1` and `-t` options.

## Example

```bash
ffmpeg -framerate 30 -loop 1 -t 3 -i opening.png \
-f lavfi -i "aevalsrc=0" \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
subtitles=opening.srt:force_style='Fontsize=18',
fade=t=out:st=2:d=1[outv]," \
-pix_fmt yuv420p -r 30 \
-map "[outv]" -map 1:a -shortest \
./opening.mp4
```

## References
* [FFmpeg: Fade in and out from PNG generated video](https://superuser.com/questions/1810004/ffmpeg-fade-in-and-out-from-png-generated-video)
