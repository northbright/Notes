# Get Video Information with ffmpeg

## Solution

```
ffmpeg -i filename
```

You may add `-hide_banner` option to hide build / copyright infomation.
```
ffmpeg -i filename -hide_banner
```

## Example

```
ffmpeg -i ~/1.mp4 -hide_banner
```

## References
* [15 Useful ‘FFmpeg’ Commands for Video, Audio and Image Conversion in Linux – Part 2](https://www.tecmint.com/ffmpeg-commands-for-video-audio-and-image-conversion-in-linux/)



