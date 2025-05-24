# Convert DVD / VCD to MP4 using FFmpeg

## Solution
* Copy `.vob`(DVD) or `.dat`(VCD) file to local disk
* Convert `.vob` or `.dat` to `.mp4` using FFmpeg

```bash
ffmpeg -i input.VOB \
-c:v libx264 -crf 23 \
output.mp4
```

For multiple `.vob` files, use `concat` protocol. This methods is suitable for formats that support file-level concatenation(e.g., MPEG-1, MPEG-2 PS, DV).

```bash
ffmpeg -i "concat:1.vob|2.vob|3.vob" \
-c:v libx264 -crf 23 \
output.mp4
```

## References
* [H.264 Video Encoding Guide](https://trac.ffmpeg.org/wiki/Encode/H.264)
* [Optimizing FFmpeg Settings for H.264 Encoding](https://toxigon.com/optimizing-ffmpeg-settings-for-h264-encoding)
* [How to concatenate two MP4 files using FFmpeg?](https://stackoverflow.com/questions/7333232/how-to-concatenate-two-mp4-files-using-ffmpeg)
