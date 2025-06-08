# Fix "Can not allocate memory" Error when Run ffmpeg

## Problem
* Run ffmpeg to generate video and audio streams and concat them to generate a video.
* Use `aevalsrc` to generate silence audio stream
* ffmpeg command

```bash
ffmpeg \
-i "opening.png" \
-i "ending.JPG" \
-filter_complex " \
[0]fps=30,loop=loop=90:size=1,scale=w=1280:h=720,fade=t=out:st=2:d=1[op_v];aevalsrc=d=3[op_a],
[1]fps=30,loop=loop=150:size=1,scale=w=1280:h=720,fade=t=out:st=4:d=1[ed_v],aevalsrc=d=5[ed_a],
[op_v][op_a][ed_v][ed_a]concat=n=2:v=1:a=1[outv][outa]" \
-map "[outv]" \
-map "[outa]" \
output.mp4
```

* Got error

  > Error initializing filters
  > ......
  > Error parsing global options: Cannot allocate memory

## Root Cause
* Incorrect option for "aevalsrc" filter to generate silence(missing first option: `exprs`)
  
  ```bash
  // wrong
  aevalsrc=d=3

  // correct
  aevalsrc=0:d=3
  ```

* Most "Cannot allocate memory" are caused by incorrect numbers(e.g. "ss", "setpts"...)

## Solution
Generate silence using `aevalsrc` correctly.

`aevalsrc=0:d=3` or `aevalsrc=exprs=0:d=3`

* Fixed command

```bash
ffmpeg \
-i "opening.png" \
-i "ending.JPG" \
-filter_complex " \
[0]fps=30,loop=loop=90:size=1,scale=w=1280:h=720,fade=t=out:st=2:d=1[op_v];aevalsrc=exprs=0:d=3[op_a],
[1]fps=30,loop=loop=150:size=1,scale=w=1280:h=720,fade=t=out:st=4:d=1[ed_v],aevalsrc=exprs=0:d=5[ed_a],
[op_v][op_a][ed_v][ed_a]concat=n=2:v=1:a=1[outv][outa]" \
-map "[outv]" \
-map "[outa]" \
output.mp4
```

## References
* ["Cannot allocate memory" error when crossfading](https://superuser.com/questions/1671061/cannot-allocate-memory-error-when-crossfading)
* [aevalsrc](https://ffmpeg.org/ffmpeg-filters.html#aevalsrc)
