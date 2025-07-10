# Encode a Video to H264 Format

## Examples

* Keep original scale

```bash
ffmpeg -i input.mov \
-c:v libx264 -crf 23 \
-c:a aac -b:a 128k \
-preset slow \
output.mp4
```
  
* Need to upscale or downscale

```bash
ffmpeg -i input.mov \
-vf scale=854x480:flags=lanczos \
-c:v libx264 -crf 23 \
-c:a aac -b:a 128k \
-preset slow \
output_480p.mp4
```

## References
* [Upscaling and downscaling video with FFmpeg](https://write.corbpie.com/upscaling-and-downscaling-video-with-ffmpeg/)
* [ffmpeg Documentation](https://ffmpeg.org/ffmpeg.html)
* [Optimizing FFmpeg Settings for H.264 Encoding](https://toxigon.com/optimizing-ffmpeg-settings-for-h264-encoding)
* [H.264 Video Encoding Guide](https://trac.ffmpeg.org/wiki/Encode/H.264)
