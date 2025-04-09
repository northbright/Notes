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

## Make the Opening Video from a Photo

#### Create a Subtitle File(`opening.srt`)
```bash
vi opening.srt
```

```bash
1
00:00:00,000 --> 00:00:03,000
Highlights and Goals
```

#### Convert the Photo to a Video

```bash
ffmpeg -framerate 1/3 -i opening.JPG \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease, \
pad=1280:720:(ow-iw)/2:(oh-ih)/2, \
subtitles=opening.srt:force_style='Fontsize=18'", \
-pix_fmt yuv420p -r 30 opening.mp4
```

* `-framerate`

  The duration of one image, in this case it’s 3 seconds.

* `-fliter_complex`

  ```
  -fliter_complex \
  "scale=1280:720:force_original_aspect_ratio=decrease, \
  pad=1280:720:(ow-iw)/2:(oh-ih)/2, \
  subtitles=opening.srt:force_style='Fontsize=30"` 
  ```

  * Resize the Photo to 1280x720 to Create the Video Frame
  * Embed the Subtitle File(`opening.srt`) and Set the Font Size to 30

* `-pix_fmt yuv 420p`

  The pixel format. `yuv 420p` is recommended because it increases the compatibility with most of the video players.

* `-r 30`

  The frame rate of the output video. Default is 25.

#### Add Fade Out Effect
```bash
ffmpeg -i opening.mp4 -vf "fade=t=out:st=2:d=1" opening-fade-out.mp4
```

* `"fade=t=out:st=2:d=1"`

  The vides starts to fade out at the beginning of 3rd second(index=2) and the duration is 1 second.

## Make the Ending Video from a Photo

#### Create a Subtitle File(`ending.srt`)
```bash
vi ending.srt
```

```bash
1
00:00:00,000 --> 00:00:05,000
2024/04/13
```

#### Convert the Photo to a Video

```bash
ffmpeg -framerate 1/5 -i ending.JPG \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease, \
pad=1280:720:(ow-iw)/2:(oh-ih)/2, \
subtitles=ending.srt:force_style='Fontsize=18'" \
-pix_fmt yuv420p -r 30 ending.mp4
```

#### Add Fade In and Out Effect
```bash
ffmpeg -i ending.mp4 -vf "fade=t=in:st=0:d=1,fade=t=out:st=3:d=2" ending-fade-out.mp4
```

## Concat All Videos into One Video File
To avoid "Non-monotonous DTS in output stream" errors, we need to convert all videos to `.mts`.

#### Convert All Videos to `.mts`

```bash
ffmpeg -i 01.mp4 -q 0 01.mts

ffmpeg -i opening-fade-out.mp4 -q 0 opening-fade-out.mts
ffmpeg -i ending-fade-out.mp4 -q 0 ending-fade-out.mts
```

* The `-q 0` specifies the output file's quality. 0 is the hightest quality.

#### Create a List File

```bash
vi list.txt
```

```bash
file 'opening-fade-out.mts'
file '01.mts'
file '02.mts'
file '03.mts'
file 'ending-fade-out.mts'
```

#### Concat All `.mts` in the List and Output to a `.mp4`

```bash
ffmpeg -f concat -safe 0 -i list.txt \
-c:v libx264 -c:a aac -b 128k -preset slow -crf 18 \
output.mp4
```

* The `-preset slow` option specifies the encoding speed(a lower speed is a higher quality).
* The `-crf 18` option specifies the quality. See [What is -crf used for in FFmpeg?](https://superuser.com/questions/677576/what-is-crf-used-for-in-ffmpeg).

We get the complete video which consists of the openging, all the highlights, goals and the ending.

## Add Subtitles
After we get the complete video, we know the start / end time of each highlight and goal to create the subtitles.

#### Create a Subtitle File for the Highlights and Goals(`sub.srt`)

```bash
vi sub.srt
```

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

#### Add Subtitles to the Video

* Method A(NOT Recommeded)

  ```bash
  ffmpeg -i output.mp4 \
  -filter_complex \
  "subtitles=sub.srt:force_style='Fontsize=18'" \
  output-subtitled.mp4
  ```

  Please note it'll re-encoding video.

* Method B: Re-Concat All Videos into One Video File with Subtitle File(Recommended)

  ```bash
  ffmpeg -f concat -safe 0 -i list.txt \
  -c:v libx264 -c:a aac -b 128k -preset slow -crf 18 \
  -filter_complex \
  "subtitles=sub.srt:force_style='Fontsize=18'" \
  output-subtitled.mp4
  ```

  It encodes the video only once to concat all videos and rending subtitles for the output video.

## Add BGM

#### Add Audio Track

```bash
ffmpeg -i output.mp4 -i bgm.m4a -shortest -c:v copy -map 0:v:0 -map 1:a:0 output-with-bgm.mp4
```

* The `-shortest` option: cut the audio if it's longer than the video.
* The `-map 0:v:0` option: map the video stream of output.mp4(which index is 0) to the output video stream
* The `-map 1:a:0` option: map the audio stream of bgm.m4a(which index is 1) to the output audio stream

#### Fade Out the Audio

```bash
ffmpeg -i output-with-bgm.mp4 -c:v copy -af "afade=t=out:st=86:d=5" output-with-bgm-fade-out.mp4
```

* `-af "afade=t=out:st=86:d=5"`
  The audio starts to fade out at 86th seconds and the duration is 5 seconds.

## References
* [ffmpeg 给视频添加字幕，在视频的某个时间段加入声音特效和动画](https://blog.csdn.net/qq_39962403/article/details/114897352)
* [Cutting Videos Based on Start and End Time using FFmpeg](https://www.baeldung.com/linux/ffmpeg-cutting-videos)
* [Using ffmpeg to convert from MTS to mp4](https://www.escogitare.com/graphics/2016/10/22/ffmpeg_concatenation.html)
* [What is -crf used for in FFmpeg?](https://superuser.com/questions/677576/what-is-crf-used-for-in-ffmpeg)
* [Trim video and concatenate using ffmpeg - getting "Non-monotonous DTS in output stream" errors](https://superuser.com/questions/1150276/trim-video-and-concatenate-using-ffmpeg-getting-non-monotonous-dts-in-output)
* [Scaling](https://trac.ffmpeg.org/wiki/Scaling)
