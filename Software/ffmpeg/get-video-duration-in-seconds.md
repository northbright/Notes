# Get Video Duration in Seconds

## Problem
* Need to get video duration using ffmpeg

## Solution
Using `ffprobe`.


```bash
ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 input.mp4

// Output:
31.880998
```

## References
* [How to get video duration in seconds?](https://superuser.com/questions/650291/how-to-get-video-duration-in-seconds)
