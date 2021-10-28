# Merge Video and Audio Without Re-Encoding

## Problem
* [Bilibili](https://www.bilibili.com/) uses 2 m4s files for playback
  * One m4s file(e.g. 300264.m4s) contains video only
  * Another(e.g. 300280.m4s) contains audio only
* Need to merge video and audio and output a mp4 file

## Solution
Use ffmpeg to merge video and audio without re-encoding

```
ffmpeg -i video.m4s -i audio.m4s -c:v copy -c:a copy "/path/to/output.mp4"
```

## Example
```
./ffmpeg -i ~/30064.m4s -i ~/30280.m4s -c:v copy -c:a copy "output.mp4"
```

## References
* [How to merge audio and video file in ffmpeg](https://superuser.com/questions/277642/how-to-merge-audio-and-video-file-in-ffmpeg) 
