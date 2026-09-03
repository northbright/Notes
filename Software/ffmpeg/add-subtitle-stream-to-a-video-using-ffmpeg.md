# Add Subtitle Stream to a Video using FFmpeg

## Solution
* Create a SRT file.
```sh
1
00:00:00,000 --> 00:00:05,090
<b>What's mimao's playing?</b>

2
00:00:05,100 --> 00:00:08,200
<b>Does he realy like it?</b>
```

```sh
ffmpeg -i input.mp4 -i 01.srt -c copy -c:s mov_text -metadata:s:s:0 language=eng input-subtitled.mp4
```

## Warning
* You may need to enable subtitle track manually when playing .mp4 using VLC player
* IINA can show subtitle track automatically

## References
* [How to Embed Subtitles into a Video Using FFmpeg](https://www.baeldung.com/linux/subtitles-ffmpeg)
