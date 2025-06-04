# Got "Operation not permitted" Error when Add Subtitle to Video due to Incorrect SRT File

## Problem
* Use a PNG image to generate an opening video
* Need to add subtitle to the opening video
* Write an `opening.srt` file
* ffmpeg command:

  ```bash
  ffmpeg \
  -i "./opening.png" \
  -filter_complex \
  "[0]fps=30,
  loop=loop=90:size=1,
  scale=1280:720:force_original_aspect_ratio=decrease,
  pad=1280:720:(ow-iw)/2:(oh-ih)/2,
  format=pix_fmts=yuv420p,
  subtitles=opening.srt:force_style='Fontsize=18',
  fade=t=out:st=2:d=1[out_v],
  aevalsrc=0:d=3[out_a]" \
  -map "[outv]" -map "[outa]" -shortest \
  ./output.mp4  
  ```
* Got "Error initializing filters"

  > Error parsing global options: Operation not permitted

## Root Cause
* Incorrect data in .SRT file

  No text but only timestamp in `opening.srt`

  ```srt
  1
  00:00:00,100 --> 00:00:02,900
  ```

## Solution
Fix the SRT file and it works

```srt
1
00:00:00,100 --> 00:00:02,900
Highlights and goals of 2025/05/10
```
