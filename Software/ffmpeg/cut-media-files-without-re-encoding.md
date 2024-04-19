# Cut Media Files without Re-Encoding

## Solution
Use ffmpeg to cut audio / video file.

```bash
ffmpeg -ss 00:00:10 -to 00:00:25 -i "input.mp4" -async 1 -c copy "output.mp4"
```

* The `-ss` argument seeks to the timestamp specified as the argument.
* The `-to` option specifies the end of the clip(e.g. the video will be cut from 00:00:10 to 00:00:25).
* The `-i` argument is used for specifying input files.
* The `-async` option specifies whether to contract or stretch the audio to match the timestamp. The value 1 will correct the start of the stream without any later correction.
* The `-c` option tells FFmpeg to copy both audio and video codecs to the output.mp4 container.

## References
* [Cutting Videos Based on Start and End Time using FFmpeg](https://www.baeldung.com/linux/ffmpeg-cutting-videos)
