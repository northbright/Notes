# Generate Video from One Image using FFmpeg

## Problem
* Generate video from 1 image for 3 seconds
* Resolution: 1280x720
* Need to add a silence audio stream
  * Used to concat videos later
  * FFmpeg won't initialize the an audio encoder if the first input has no audio stream
* Add subtitles from .srt file
* Fade out at 00:00:02 and duration is 1 second

## Solution
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

## References
* [FFmpeg: Fade in and out from PNG generated video](https://superuser.com/questions/1810004/ffmpeg-fade-in-and-out-from-png-generated-video)
