# Filter Concat Has an Unconnected Output

## Problem
* Want to concat video streams of 2 input files
* Use bgm.m4a as output's audio stream
* Run the following command:

```bash
ffmpeg \
-i "01.MP4" \
-i "02.MOV" \
-i "bgm.m4a" \
-filter_complex \
"[0:v:0][0:a:0][1:v:0][1:a:0]concat=n=2:v=1:a=1[out_v][out_a]" \
-map "[out_v]" \
-map 2:a:0 \
-shortest \
output.mp4
```

* Got error:

  > Filter concat has an unconnected output

## Root Cause
The output label `[out_a]` is not used(mapped).

## Solution
Remove unused output label and its inputs(e.g. `[X:a:0]`).
Update `concat` filter with `a=0` to set the number of output audio streams(also the number of audio streams in each segment).

```bash
ffmpeg \
-i "01.MP4" \
-i "02.MOV" \
-i "bgm.m4a" \
-filter_complex \
"[0:v:0][1:v:0]concat=n=2:v=1:a=0[out_v]" \
-map "[out_v]" \
-map 2:a:0 \
-shortest \
output.mp4
```

## References
* [concat](https://ffmpeg.org/ffmpeg-filters.html#concat)
