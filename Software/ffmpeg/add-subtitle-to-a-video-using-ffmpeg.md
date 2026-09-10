# Add Subtitle to a Video using FFmpeg

## Create 2 SRT files

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
<b>
```

## Hard Coding Subtitles
Burn the SRT into the video using video fiter.

```sh
ffmpeg -i input.mp4 -vf "subtitles=eng.srt" output.mp4
```

You may add styles with the `force_style` option.

```sh
ffmpeg -i input.mp4 -vf "subtitles=subs.srt:force_style='FontName=Arial,FontSize=24,PrimaryColour=&H00FFFFFF,OutlineColour=&H00000000,Outline=2,Shadow=1'" output.mp4
```

Common style parameters:

| Parameter | Example | Description |
| :-- :| :--: | :--: |
| FontName | Arial | Font face |
| FontSize | 24 | Size in points |
| PrimaryColour | &H00FFFFFF | Text color (ABGR hex) |
| OutlineColour | &H00000000 | Outline color |
| BackColour | &H80000000 | Shadow/background color |
| Outline | 2 | Outline thickness |
| Shadow | 1 | Shadow depth |
| Bold | 1 | Bold text (0 or 1) |
| Alignment | 2 | Position (2=bottom center) |
| MarginV | 30 | Vertical margin from edge |

## Soft Coding Subtitles
Add subtitle streams(tracks) to a video.

#### Add subtitle streams to `.MKV` format

The Matroska (MKV) container natively supports SubRip (SRT) subtitles.

* Add a subtitle stream(original video has NO subtitle stream)
```sh
ffmpeg -i input.mkv -i eng.srt -c copy -map 0 -map 1 output.mkv
```

  * `-c copy`: do not recording video / audio, just copy the streams
  * `-map 0`: select all streams of input #1(input.mkv): video and audio streams
  * `-map 1`: select all streams of input #2(eng.srt): one subtitle stream
  * if no `-map 0` nor `-map 1`, ffmpeg will select only 1 stream for each type(video, audio, stream) automatically: select the highest quality stream in all streams of all inputs.
  * Adding `-map 0`, `-map 1` for mulitiple inputs in ffmpeg command is **recommended**

* Add multiple subtitle streams(English and Localized, original video has NO subtitle stream)
```sh
ffmpeg -i input.mkv -i eng.srt -i chi.srt \
-map 0 -map 1 -map 2 \
-c copy \
-metadata:s:s:0 language=eng -metadata:s:s:0 title="English" \
-metadata:s:s:1 language=chi -metadata:s:s:1 title="中文" \
output.mkv
```

  * `-map 0`: maps all the streams from the first input(video, audio)
  * `-map 1`: maps the second input(English subtitle) as the first subtitle stream(s:s:0)
  * `-map 2`: maps the third input(Chinese subtitle) as the second subtitle stream(s:s:1)
  * `-c copy`: just copy tha video / audio stream without re-encoding
  * `-metadata:s:s:x language=<CODE>`: set subtitle language to 3-letter ISO 639-2 code.
    * e.g. eng, spa, fra, chi
  * `-metadata:s:s:x title="TITLE"`: set menu title to select subtitle

#### Add subtitle streams for `.MP4` format

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
* [ISO 639-2 Code](https://www.loc.gov/standards/iso639-2/php/code_list.php)
* [How to Add Subtitles to Video with FFmpeg](https://ffhub.io/blog/how-to-add-subtitles-to-video-with-ffmpeg)
