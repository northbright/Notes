# `-crf` Option of FFmpeg

## `-crf` Option
* `-crf` refers to the Constant Rate Factor.
* The value depends on which encoder you're using
  * Valid range for `x264` is `0`  - `51`
  * A lower value is a higher quality
  * `0`is lossless, `23` is default, `51` is worst

## Example
```bash
ffmpeg -f concat -safe 0 -i list.txt -c:v libx264 -c:a aac -b 128k -preset slow -crf 18 output.mp4
```

## References
* [What is -crf used for in FFmpeg?](https://superuser.com/questions/677576/what-is-crf-used-for-in-ffmpeg)
* [CRF Guide (Constant Rate Factor in x264, x265 and libvpx)](https://slhck.info/video/2017/02/24/crf-guide.html)
