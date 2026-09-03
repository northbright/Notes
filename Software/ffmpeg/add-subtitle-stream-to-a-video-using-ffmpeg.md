# Add Subtitle Streams to a Video using FFmpeg

## Solution

#### Create 2 SRT file.

```sh
vi eng.srt
```

```srt
1
00:00:00,000 --> 00:00:05,090
<b>What's mimao's playing?</b>

2
00:00:05,100 --> 00:00:08,200
<b>Does he realy like it?</b>
```

```sh
vi chi.srt
```

```srt
1
00:00:00,000 --> 00:00:05,090
<b>咪毛在玩啥？</b>

2
00:00:05,100 --> 00:00:08,200
<b>他真的喜欢玩这个？</b>
```

#### For `.MKV` format

The Matroska (MKV) container natively supports SubRip (SRT) subtitles.

* Add English Subtitle
```sh
ffmpeg -i input.mkv -i eng.srt -c copy output.mkv
```

* Add English and Localized Subtitles
```sh
ffmpeg -i input.mkv -i eng.srt -i chi.srt \
-map 0 -map 1 -map 2 \
-c copy \
-metadata:s:s:0 language=eng -metadata:s:s:0 title="English" \
-metadata:s:s:1 language=chi -metadata:s:s:1 title="中文" \
output.mkv
```

  * `-map 0` maps all the streams from the first input(video)
  * `-map 1` maps the second input(English subtitle) as the first subtitle stream(s:s:0)
  * `-map 2` maps the third input(Chinese subtitle) as the second subtitle stream(s:s:1)
  * language=`<ISO 639-2 Code>`


#### For `.MP4` format

Unlike MKV, the MP4 container does not natively support raw SRT text format.
To add subtitles to an MP4 container without re-encoding the video or audio, you must convert the SRT subtitle stream to the MP4-compatible Timed Text format (`mov_text`).

```sh
ffmpeg -i input.mkv -i eng.srt -i chi.srt \
-map 0 -map 1 -map 2 \
-c copy \
-c:s mov_text \
-metadata:s:s:0 language=eng -metadata:s:s:0 title="English" \
-metadata:s:s:1 language=chi -metadata:s:s:1 title="中文" \
output.mp4
```

* You may need to enable subtitle track manually when playing `.mp4` using VLC player
* IINA can show subtitle track automatically

## References
* [How to Embed Subtitles into a Video Using FFmpeg](https://www.baeldung.com/linux/subtitles-ffmpeg)
* [How to Use FFMpeg to Add Subtitles to Videos](https://cloudinary.com/guides/video-effects/ffmpeg-subtitles)
* [How to Add Subtitles to Video with FFmpeg](https://ffhub.io/blog/how-to-add-subtitles-to-video-with-ffmpeg)
* [How to Add SRT to Video Without Encoding Using FFmpeg](https://salivity.github.io/ffmpeg/article/how-to-add-srt-to-video-without-encoding-using-ffmpeg)
