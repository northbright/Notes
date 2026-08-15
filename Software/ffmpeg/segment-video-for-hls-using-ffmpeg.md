# Segment Video for HLS Using ffmpeg

## Problem
* Need to segment video to HLS segments(HLS)
* Create HLS segments of exact length: e.g. 4 seconds

## Solution
Use ffmpeg's `hls` muxer.

```sh
ffmpeg -i input.mov \
-force_key_frames "expr:gte(t,n_forced*4)" \
-c:v libx264 -c:a aac \
-f hls \
-hls_time 4 \
-hls_segment_filename "%05d.ts" \
"playlist.m3u8"
```

* `-force_key_frames "expr:gte(t,n_forced*4)"`

  Force one key frame in every 4 seconds.

* `-f hls`

  Use `hls` muxer.

* `-hls_time 4`

  HLS segments length: 4 seconds.

* `-hls_segment_filename "%05d.ts"`

  * filename template for segment files

* `"playlist.m3u8"`

  Output `.m3u8` file

## Show HLS Muxer help
```sh
ffmpeg -h muxer=hls
```

## References
* [使用FFmpeg命令进行hls切片，得到的ts文件时长不准确](https://blog.csdn.net/u014552102/article/details/103302731)
* [FFmpeg hls设置hls_time切片时间不准确的解决方案-ts流强制gop](https://blog.csdn.net/u010029439/article/details/111186133)
* [Segmenting Video with ffmpeg – Part 2](https://hlsbook.net/segmenting-video-with-ffmpeg-part-2/)
