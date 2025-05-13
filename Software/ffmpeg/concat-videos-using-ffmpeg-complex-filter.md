# Concat Videos using FFmpeg Complex Filter

## Problem
Concat clips of 01.MOV and 02.MOV.

* 01.MOV: 1280x720
* 02.MOV: 1920x1080
* Trim 01.MOV from 00:00:08 to end
* Trim 02.MOV from 00:01:02 to 00:01:12

## Solution
* Use complex filters(`-filter_complex`) for multiple inputs
* Use [trim](https://ffmpeg.org/ffmpeg-filters.html#trim) and [atrim](https://ffmpeg.org/ffmpeg-filters.html#atrim) to make video and audio clip streams.
* To make [concat](https://ffmpeg.org/ffmpeg-filters.html#concat) filter work, inputs dimensions should be same
  * Scale 02.MOV to 1280x720 before concat using [scale](https://ffmpeg.org/ffmpeg-filters.html#scale) filter
* Concat video and audio clip streams to one video / audio stream using [concat](https://ffmpeg.org/ffmpeg-filters.html#concat) filter.

```bash
ffmpeg \
-i "./01.MOV" \
-i "./02.MOV" \
-filter_complex \
"[0:v:0]trim=start=08[00v],[0:a:0]atrim=start=08[00a],
[1:v:0]trim=start=00[01v],[1:a:0]atrim=start=02[01a],
[00v]setpts=PTS-STARTPTS[00v1],
[00a]asetpts=PTS-STARTPTS[00a1],
[01v]setpts=PTS-STARTPTS[01v1],
[01v1]scale=w=1280:h=720[01v2],
[01a]asetpts=PTS-STARTPTS[01a1],
[00v1][00a1][01v2][01a1]concat=2:v=1:a=1[outv][outa]" \
-map "[outv]" -map "[outa]" \
./output.MOV
```

## References
* [Concatenating media files](https://trac.ffmpeg.org/wiki/Concatenate)
* [concat](https://ffmpeg.org/ffmpeg-filters.html#concat) 
* [trim](https://ffmpeg.org/ffmpeg-filters.html#trim)
* [scale](https://ffmpeg.org/ffmpeg-filters.html#scale)
