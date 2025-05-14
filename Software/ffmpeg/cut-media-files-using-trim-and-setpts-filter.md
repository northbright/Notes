# Cut Media Files using `trim` and `setpts` Filter

## Problem
* Need to make clips by cutting videos
* Output(clips) may be the input of next filter in the filter chain

## Solution
* Use [trim](https://ffmpeg.org/ffmpeg-filters.html#trim) / [atrim](https://ffmpeg.org/ffmpeg-filters.html#atrim) to trim the video / audio.
* Use [setpts/asetpts](https://ffmpeg.org/ffmpeg-filters.html#setpts) to reset the PTS of clip to start from 0.

## Example

Cut input.MOV from 00:01:00 to 00:01:05.

```bash
ffmpeg \
-i "./input.mp4" \
-filter_complex \
"[0:v:0]trim=60:65[00v],[0:a:0]atrim=60:65[00a],
[00v]setpts=PTS-STARTPTS[outv],
[00a]asetpts=PTS-STARTPTS[outa]," \
-map "[outv]" -map "[outa]" \
./output.mp4
```
