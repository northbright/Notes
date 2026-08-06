# Concat HLS Segments via FFmpeg

## Problem
Have `.ts` segments from an HLS stream, need a fastest way to rejoin them.

## Solution
Use the concat protocol.

```sh
ffmpeg -i "concat:001.ts|002.ts" \
-c copy \
-bsf:a aac_adtstoasc \
output.mp4
```

* The `-bsf:a aac_adtstoasc` flag converts the ADTS-formatted AAC headers that MPEG-TS uses into the MPEG-4 format that MP4 containers expect. Skip it and the audio won't play.

## References
* [FFmpeg Concat Guide: Demuxer, Filter, Protocol and API](https://renderio.dev/blogs/ffmpeg-concat-guide/)
