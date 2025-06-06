# Make Highlights and Goals Video for Football Game using FFmpeg

## Update(2025/05/17)
Use one-line command to generate an highlights and goals video.

* Opening image
* Ending image
* BGM
* Record duration of each clip
* Record top order of each clip
* Create SRT subtitle file for each clip
* Specify duration of openging / ending video by using loop filter 
  * set loop size=1(first frame)
  * set fps
  * set loop(loop times) for first frame = fps * duration
  * e.g. `loop=loop=90:size=1`(fps=30, duration=3 seconds, loop=30 * 3=90)

```bash
echo "y" | ffmpeg \
-i "./01.MOV" \
-i "./02.MOV" \
-i "./opening.png" \
-i "./ending.JPG" \
-i "./bgm.m4a" \
-filter_complex \
"[0:v]trim=start=08,
setpts=PTS-STARTPTS,
subtitles=01.srt:force_style='Fontsize=18'[00_v],
[0:a]atrim=start=08,
asetpts=PTS-STARTPTS[00_a];

[1:v]trim=start=00,
setpts=PTS-STARTPTS,
subtitles=02.srt:force_style='Fontsize=18'[01_v],
[1:a]atrim=start=00,
asetpts=PTS-STARTPTS[01_a];

[2]fps=30,
loop=loop=90:size=1,
scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
format=pix_fmts=yuv420p,
subtitles=opening.srt:force_style='Fontsize=18',
fade=t=out:st=2:d=1[opening_v];

aevalsrc=0:d=3[opening_a];

[3]fps=30,
loop=loop=150:size=1,
scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
format=pix_fmts=yuv420p,
subtitles=ending.srt:force_style='Fontsize=18',
fade=t=out:st=4:d=1[ending_v];

aevalsrc=0:d=5[ending_a];

[opening_v][opening_a][00_v][00_a][01_v][01_a][ending_v][ending_a]concat=4:v=1:a=1[outv][a];

[4:a:0][a]amerge=inputs=2,pan=stereo|c0<c0+c2|c1<c1+c3[outa]" \
-map "[outv]" -map "[outa]" -shortest \
./output.mp4
```

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
echo "y" | ffmpeg -framerate 30 -loop 1 -t 3 -i opening.png \
-f lavfi -i "aevalsrc=0" \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
subtitles=opening.srt:force_style='Fontsize=18',
fade=t=out:st=2:d=1[outv]," \
-pix_fmt yuv420p -r 30 \
-map "[outv]" -map 1:a -shortest \
./opening.mp4
```

* `-loop 1` and `-t 3`
  Use one image to create a video which duration is 3 seconds.

* `-f lavfi -i "aevalsrc=0"`

  Add a silence audio stream.
  FFmpeg won't initialize audio encoder if first input has no audio stream.
  
* `-fliter_complex`

  ```bash
  -filter_complex \
  "scale=1280:720:force_original_aspect_ratio=decrease,
  pad=1280:720:(ow-iw)/2:(oh-ih)/2,
  subtitles=opening.srt:force_style='Fontsize=18',
  fade=t=out:st=2:d=1[outv],"
  ```
  * Resize the Photo to 1280x720 to Create the Video Frame
  * Embed the Subtitle File(`opening.srt`) and Set the Font Size to 30
  * Apply fade out effect from 00:00:02 and duration is 1 second.
  * The video output is labeled as [outv].

* `-pix_fmt yuv 420p`

  The pixel format. `yuv 420p` is recommended because it increases the compatibility with most of the video players.

* `-r 30`

  The frame rate of the output video. Default is 25.

* `-map "[outv]" -map 1:a`

  Select the labeled output video stream from filter and the second input's audio stream(silence).

* `-shortest`

  Ensure that the output file stops when the shortest input stream ends.

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
ffmpeg -framerate 30 -loop 1 -t 5 -i ending.JPG \
-f lavfi -i "aevalsrc=0" \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease,
pad=1280:720:(ow-iw)/2:(oh-ih)/2,
subtitles=opening.srt:force_style='Fontsize=18',
fade=t=out:st=4:d=1[outv]," \
-pix_fmt yuv420p -r 30 \
-map "[outv]" -map 1:a -shortest \
./ending.mp4
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

* Method A: Use BGM as audio track only
```bash
ffmpeg -i output-subtitled.mp4 -i bgm.m4a -shortest -c:v copy -map 0:v:0 -map 1:a:0 output-subtitled-bgm.mp4
```

* Method B: Mix BGM and audio stream of original video
```bash
ffmpeg -i output-subtitled.mp4 -i bgm.m4a -c:v copy \
-filter_complex \
"[0:a:0][1:a:0]amerge=inputs=2,pan=stereo|c0<c0+c2|c1<c1+c3[a]" \
-map 0:v -map "[a]" -c:v copy -shortest \
output-subtitled-bgm.mp4
```

#### Fade Out the Audio

```bash
ffmpeg -i output-subtitled-bgm.mp4 -c:v copy -af "afade=t=out:st=86:d=5" output-subtitled-bgm-fade-out.mp4
```

* `-af "afade=t=out:st=86:d=5"`
  The audio starts to fade out at 86th seconds and the duration is 5 seconds.

#### Make File Size Small to Share it to WeChat

```bash
ffmpeg -i output-subtitled-bgm-fade-out.mp4 -vf scale=854x480:flags=lanczos -c:v h264 -b:v 800k -c:a copy output-subtitled-bgm-fade-out-480p.mp4
```

## References
* [ffmpeg 给视频添加字幕，在视频的某个时间段加入声音特效和动画](https://blog.csdn.net/qq_39962403/article/details/114897352)
* [Cutting Videos Based on Start and End Time using FFmpeg](https://www.baeldung.com/linux/ffmpeg-cutting-videos)
* [Using ffmpeg to convert from MTS to mp4](https://www.escogitare.com/graphics/2016/10/22/ffmpeg_concatenation.html)
* [What is -crf used for in FFmpeg?](https://superuser.com/questions/677576/what-is-crf-used-for-in-ffmpeg)
* [Trim video and concatenate using ffmpeg - getting "Non-monotonous DTS in output stream" errors](https://superuser.com/questions/1150276/trim-video-and-concatenate-using-ffmpeg-getting-non-monotonous-dts-in-output)
* [Scaling](https://trac.ffmpeg.org/wiki/Scaling)
* [Manipulating audio channels](https://trac.ffmpeg.org/wiki/AudioChannelManipulation)
