# Got "Initializing Filters" Error when Adding Subtitle using FFmpeg due to incorrect SRT

## Problem
* Use golang to generate a SRT file
* Run ffmpeg to add hard subtitles to a video from an image

  ```sh
  ffmpeg -i input.mp4 -vf "subtitles='op.srt'" -c:v libx264 -c:a aac output.mp4
  ```

* Got error:

  > [AVFilterGraph @ 0x7fe2f2204b80] Error initializing filters
  > Error : Operation not permitted

## Root Cause
Incorrect SRT file content:

```srt
1
00:00:00,000 --> 00:00:05,090
```

* No subtitle text
* Incorrect format

## Solutition
Fix the SRT file and it works.

```srt
1
00:00:00,000 --> 00:00:05,090
Hello World!
```
