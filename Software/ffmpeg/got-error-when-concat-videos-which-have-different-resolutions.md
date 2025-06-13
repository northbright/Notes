# Got Error when Concat Videos which Have Different Resolutions

## Problem
Concat image video clip and multiple videos useing `trim` filter:

```bash
ffmpeg \
-i "op.jpg" \
-i "ed.jpg" \
-i "01.MP4" \
-i "02.MOV" \
-i "03.MOV" \
-i "bgm.m4a" \
-filter_complex " \
[0:v:0]fps=30,loop=loop=90:size=1,scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,format=pix_fmts=yuv420p,subtitles='op.srt',fade=t=out:st=2:d=1[op_v];
aevalsrc=0:d=3[op_a];
[1:v:0]fps=30,loop=loop=90:size=1,scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,format=pix_fmts=yuv420p,subtitles='ed.srt',fade=t=out:st=2:d=1[ed_v];
aevalsrc=0:d=3[ed_a];
[2:v:0]trim=end=5.000,setpts=PTS-STARTPTS,subtitles='01.srt'[clip_00_v];
[2:a:0]atrim=end=5.000,asetpts=PTS-STARTPTS[clip_00_a];
[3:v:0]subtitles='02.srt'[clip_01_v];
[4:v:0]trim=start=1.000:end=9.000,setpts=PTS-STARTPTS,subtitles='03.srt'[clip_02_v];
[4:a:0]atrim=start=1.000:end=9.000,asetpts=PTS-STARTPTS[clip_02_a];
[op_v][op_a][clip_00_v][clip_00_a][clip_01_v][3:a:0][clip_02_v][clip_02_a][ed_v][ed_a]concat=n=5:v=1:a=1[outv][outa];
[5:a:0][outa]amerge=inputs=2,pan=stereo|c0<c0+c2|c1<c1+c3[outa_merged_bgm]" \
-map "[outv]" \
-map "[outa_merged_bgm]" \
output.mp4
```

Got errors:
> Input link in0:v0 parameters (size 720x1280, SAR 0:1) do not match the corresponding output link in0:v0 parameters (720x960, SAR 1:1)

## Root Cause
Video streams have different reslutions and SAR values.

## Solution
Use `scale` filter to resize the video streams and `setsar` filter to set SAR before concatenating the video streams using `concat` filter.

* Use `scale` filter only may still fail(SAR are different).
* `setsar` is usually set to `1:1`
* Put `scale` and `setsar` filters at the **Beginning** of the video filterchain or it may fail.

## Example

```bash
ffmpeg \
-i "op.jpg" \
-i "ed.jpg" \
-i "01.MP4" \
-i "02.MOV" \
-i "03.MOV" \
-i "bgm.m4a" \
-filter_complex " \
[0:v:0]fps=30,loop=loop=90:size=1,scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,setsar=1:1,format=pix_fmts=yuv420p,subtitles='op.srt',fade=t=out:st=2:d=1[op_v];
aevalsrc=0:d=3[op_a];
[1:v:0]fps=30,loop=loop=90:size=1,scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,setsar=1:1,format=pix_fmts=yuv420p,subtitles='ed.srt',fade=t=out:st=2:d=1[ed_v];
aevalsrc=0:d=3[ed_a];
[2:v:0]scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,setsar=1:1,trim=end=5.000,setpts=PTS-STARTPTS,subtitles='01.srt'[clip_00_v];
[2:a:0]atrim=end=5.000,asetpts=PTS-STARTPTS[clip_00_a];
[3:v:0]scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,setsar=1:1,subtitles='02.srt'[clip_01_v];
[4:v:0]scale=720:960:force_original_aspect_ratio=decrease,pad=720:960:(ow-iw)/2:(oh-ih)/2,setsar=1:1,trim=start=1.000:end=9.000,setpts=PTS-STARTPTS,subtitles='03.srt'[clip_02_v];
[4:a:0]atrim=start=1.000:end=9.000,asetpts=PTS-STARTPTS[clip_02_a];
[op_v][op_a][clip_00_v][clip_00_a][clip_01_v][3:a:0][clip_02_v][clip_02_a][ed_v][ed_a]concat=n=5:v=1:a=1[outv][outa];
[5:a:0][outa]amerge=inputs=2,pan=stereo|c0<c0+c2|c1<c1+c3[outa_merged_bgm]" \
-map "[outv]" \
-map "[outa_merged_bgm]" \
output.mp4
```

## References
* [ffmpeg error Input link parameters do not match the corresponding output link parameters](https://video.stackexchange.com/questions/36797/ffmpeg-error-input-link-parameters-do-not-match-the-corresponding-output-link-pa)
