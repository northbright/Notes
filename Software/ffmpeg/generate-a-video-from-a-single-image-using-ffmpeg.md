# Generate a Video from a Single Image using FFmpeg

## Problem
* Generate video from 1 image for 3 seconds
* Resolution: 1280x720
* Need to add a silence audio stream
  * Used to concat videos later
  * FFmpeg won't initialize the an audio encoder if the first input has no audio stream
* Add subtitles from .srt file
* Fade out at 00:00:02 and duration is 1 second

## Solution A
```bash
ffmpeg -framerate 30 -loop 1 -t 3 -i opening.png \
-f lavfi -i "aevalsrc=0" \
-filter_complex \
"[0:v:0]scale=1280:720:force_original_aspect_ratio=decrease[v1],
[v1]pad=1280:720:(ow-iw)/2:(oh-ih)/2[v2],
[v2]subtitles=opening.srt:force_style='Fontsize=18'[v3],
[v3]fade=t=out:st=2:d=1[outv]," \
-pix_fmt yuv420p -r 30 \
-map "[outv]" -map 1:a -shortest \
./opening.mp4
```

* `-framerate 30`: set fps to 30
* `-loop 1`: loop input image infinitely
* `-t 3`: set video duration to 3 seconds
* `-f lavfi -i "aevalsrc=0"`: create a silence audio input
* `-pix_fmt yuv420p`: set pix format to `yuv420p` to ensure compatibility so crappy players can decode the video when outputing H.264

## Solution B
Specify frame rate, loop and generate silence audio stream in one `filter_complex`.

```bash
ffmpeg -i opening.png \
-filter_complex \
"[0]fps=30[v],
[v]loop=loop=90:size=1,
scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
format=pix_fmts=yuv420p,
subtitles=opening.srt:force_style='Fontsize=18',
fade=t=out:st=2:d=1[outv],
aevalsrc=0:d=3[outa]" \
-map "[outv]" -map "[outa]" \
./opening.mp4
```

* `fps=30`: use `fps` filter to set fps to 30
* `loop=loop=90:size=1`: use `loop` filter to loop first frame(size=1) for 90 times
  duration = 3(90 frames / 30frames per second)
* `format=pix_fmts=yuv420p`: use `format` filter to set pix format to `yuv420p`
* `aevalsrc=0:d=3[outa]`: use `aevalsrc` filter to create a silenct audio stream(duration = 3 seconds)

## References
* [FFmpeg 视频处理入门教程](https://ruanyifeng.com/blog/2020/01/ffmpeg.html)
* [Loop images at specific frame rate to generate a video](https://ffmpegbyexample.com/examples/fnjrnx47/loop_images_at_specific_frame_rate_to_generate_video/)
* [Slideshow](https://trac.ffmpeg.org/wiki/Slideshow)
* [FFmpeg: Fade in and out from PNG generated video](https://superuser.com/questions/1810004/ffmpeg-fade-in-and-out-from-png-generated-video)
