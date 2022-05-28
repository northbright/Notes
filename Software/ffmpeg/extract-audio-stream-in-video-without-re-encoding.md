# Extract Audio Stream in Video Without Re-Encoding

## Solution
* Use `-vn` to disable video
* Use `-c:a copy` to keep the original audio stream

## Example
```
./ffmpeg -i "input.mp4" -vn -c:a copy "output.m4a"
```

```
// Copy audio from 00:30:54 and the duration is 24 seconds.
ffmpeg -ss 00:39:54.00 -t 00:00:24 -i input.mp4  -vn -c:a copy output.m4a
```

## References
* [How can I extract audio from video with ffmpeg?](https://stackoverflow.com/questions/9913032/how-can-i-extract-audio-from-video-with-ffmpeg)
