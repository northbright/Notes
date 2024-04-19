# Make Highlights and Goals Video for Football Game using FFmpeg

## Cut the Original Recorded Videos
Some highlighs and goals videos are too long, need to cut.

* Cut Video File Start from 00:00:10 to 00:00:25

  ```bash
  ffmpeg -ss 00:00:10 -to 00:00:25 -i 01.mp4 -async -1 -c copy 01-short.mp4
  ```

* Cut Video File Start from 00:00:10 to the End

  ```bash
  ffmpeg -ss 00:00:10 -i 01.mp4 -async -1 -c copy 01-short.mp4
  ```

## Concat Multiple Videos into One Video File
To avoid "Non-monotonous DTS in output stream" errors, we need to convert all videos to `.mts`.

* Convert All Videos to `.mts`

  ```bash
  ffmpeg -i 01.mp4 -q 0 01.mts
  ```

  * The `-q 0` specifies the output file's quality. 0 is the hightest quality.

* Create a List File

  ```bash
  vi list.txt
  ```

  ```bash
  file '01.mts'
  file '02.mts'
  file '03.mts'
  ```

* Concat All `.mts` in the List and Output to a `.mp4`

  ```bash
  ffmpeg -f concat -safe 0 -i list.txt -c:v libx264 -c:a aac -b 128k -preset slow -crf 18 output.mp4
  ```

  * The `-preset slow` option specifies the encoding speed(a lower speed is a higher quality).
  * The `-crf 18` option specifies the quality. See [What is -crf used for in FFmpeg?](https://superuser.com/questions/677576/what-is-crf-used-for-in-ffmpeg).

## Add BGM

```bash
ffmpeg -i output.mp4 -i bgm.m4a -shortest -c:v copy -map 0:v:0 -map 1:a:0 output-with-bgm.mp4
```

* The `-shortest` option: cut the audio if it's longer than the video.
* The `-map 0:v:0` option: map the video stream of output.mp4(which index is 0) to the output video stream
* The `-map 1:a:0` option: map the audio stream of bgm.m4a(which index is 1) to the output audio stream

## Add Subtitles
* Make a `.srt` Subtitle File

  ```bash
  1
  00:00:00,000 --> 00:00:11,000
  No.3
  Jacky(Team A)

  2
  00:00:12,000 --> 00:00:24,000
  No.2
  Wild Cat(Team A)

  3
  00:00:25,000 --> 00:00:37,000
  No.1
  Tomas(Team B)
  ```

## References
* [ffmpeg 给视频添加字幕，在视频的某个时间段加入声音特效和动画](https://blog.csdn.net/qq_39962403/article/details/114897352)
* [Cutting Videos Based on Start and End Time using FFmpeg](https://www.baeldung.com/linux/ffmpeg-cutting-videos)
* [Using ffmpeg to convert from MTS to mp4](https://www.escogitare.com/graphics/2016/10/22/ffmpeg_concatenation.html)
* [What is -crf used for in FFmpeg?](https://superuser.com/questions/677576/what-is-crf-used-for-in-ffmpeg)
* [Trim video and concatenate using ffmpeg - getting "Non-monotonous DTS in output stream" errors](https://superuser.com/questions/1150276/trim-video-and-concatenate-using-ffmpeg-getting-non-monotonous-dts-in-output)
