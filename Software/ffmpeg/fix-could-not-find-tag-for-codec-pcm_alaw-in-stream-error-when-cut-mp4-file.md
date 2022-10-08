# fix `could not find tag for codec pcm_alaw in stream` Error when Cut mp4 File

## Problem
* Use ffmpeg to cut mp4 file

  `ffmpeg -ss 00:23:00.00 -t 18:05:00 -i 01.mp4 -c:v copy -c:a copy 01_modified.mp4`

* Got error:

  > Could not find tag for codec pcm_alaw in stream #1, codec not currently supported in container

## Root Cause
* ffmpeg does not support PCM (`pcm_alaw`, `pcm_s16le`, etc) in the MP4 container.

## Solution
* Encode the audio as AAC, or use a different output container format such as MOV or MKV.

## Example
```
ffmpeg -ss 00:23:00 -i 01.mp4 -c:v copy -c:a aac 01_modified.mp4
```

## References
* [Could not find tag for codec pcm_alaw in stream #1, codec not currently supported in container when concatenating 2 files using ffmpeg](https://stackoverflow.com/questions/47495713/could-not-find-tag-for-codec-pcm-alaw-in-stream-1-codec-not-currently-supporte)
