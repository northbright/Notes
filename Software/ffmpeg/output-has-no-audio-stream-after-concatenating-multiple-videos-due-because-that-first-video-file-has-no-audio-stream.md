# Output has No Audio Stream after Concatenating Multiple Videos Because that First Video File has No Audio Stream

## Problem
* Use FFmpeg to create an opening video from a JPG

```bash 
ffmpeg -framerate 1/3 -i opening.JPG \ 
-filter_complex \ 
"scale=1280:720:force_original_aspect_ratio=decrease, \ 
pad=1280:720:(ow-iw)/2:(oh-ih)/2, \ 
subtitles=opening.srt:force_style='Fontsize=18'" \ 
-pix_fmt yuv420p -r 30 \ 
opening.mp4 
```

* Concat the opening video and other video files
```bash
vi list.txt
```

```bash
file 'opening.mts'
file '01.mts'
file '02.mts'
file '03.mts'
```

```bash
ffmpeg -f concat -safe 0 -i list.txt \
-c:v libx264 -c:a aac -b 128k -preset slow -crf 18 \
output.mp4
```

* Output.mp4 has no audio stream

## Root Cause
FFmpeg won't initialize the an audio encoder if the first input has no audio stream.

## Solution
Add silence audio stream in first input.
Use `-f lavfi -i "aevalsrc=0"` before `-filter_complex` and add `-map 0 -map 1 -shortest` at the end of the command.

```bash
ffmpeg -framerate 1/3 -i opening.JPG \
-f lavfi -i "aevalsrc=0" \
-filter_complex \
"scale=1280:720:force_original_aspect_ratio=decrease, \
pad=1280:720:(ow-iw)/2:(oh-ih)/2, \
subtitles=opening.srt:force_style='Fontsize=18'" \
-pix_fmt yuv420p -r 30 \
-map 0 -map 1 -shortest \
opening.mp4
```

## References
* [Concatenate videos with/without audio stream](https://superuser.com/questions/928770/concatenate-videos-with-without-audio-stream) 
* [ffmpeg complex_filter with aevalsrc results in "Invalid stream specifier"](https://stackoverflow.com/questions/69956420/ffmpeg-complex-filter-with-aevalsrc-results-in-invalid-stream-specifier)
