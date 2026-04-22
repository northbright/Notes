# Encode a Video to H.265 Format

## Example
* Resize to 480P

```sh
ffmpeg -i input.mp4 -c:v libx265 \
-vf scale=854x480:flags=lanczos \
-crf 32 \
-preset fast \
-c:a aac -b:a 128k \
output.mp4
```

## CRF Resolution-Specific Guidelines
* Standard Definition (480p/576p): CRF 23–27 to counter artifacts on larger displays
* 720p HD: CRF 24–28, with 25 for balanced streaming
* 1080p Full HD: CRF 25–29, versatile for most consumer setups
* 4K UHD (2160p): CRF 26–32, leveraging HEVC's strengths; lower (22–26) for HDR/10-bit content

## References
* [x265 (HEVC) Encoder Guide](https://ffmpeg.party/guides/x265/)
* [H.265/HEVC Video Encoding Guide](https://trac.ffmpeg.org/wiki/Encode/H.265)
