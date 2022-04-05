# Encode a Video to H264 Format

## Solution
* Use ffmpeg to encode

```
// Keep original scale
./ffmpeg -i ~/videos/01.mov -c:v h264 -b:v 800k -c:a aac -b:a 64k ~/videos/01.mp4

// Need to upscale or downscale
./ffmpeg -i ~/videos/01.mov -vf scale=854x480:flags=lanczos -c:v h264 -b:v 800k -c:a aac -b:a 64k ~/videos/01_480p.mp4
```

## References
* [Upscaling and downscaling video with FFmpeg](https://write.corbpie.com/upscaling-and-downscaling-video-with-ffmpeg/)
* [ffmpeg Documentation](https://ffmpeg.org/ffmpeg.html)
