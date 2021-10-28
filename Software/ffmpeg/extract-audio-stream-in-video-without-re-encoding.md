# Extract Audio Stream in Video Without Re-Encoding

## Solution
* Use `-vn` to disable video
* Use `-c:a copy` to keep the original audio stream

## Example
```
./ffmpeg -i "input.mp4" -vn -c:a copy "output.m4a"
```

## References
* [How can I extract audio from video with ffmpeg?](https://stackoverflow.com/questions/9913032/how-can-i-extract-audio-from-video-with-ffmpeg)
