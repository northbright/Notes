# Generate a Video Clip from an Image and Concatenate Multiple Clips to a Final Video using FFmpeg

## Problem
* Have some images, need to create a video clip(duration: 3 - 5 seconds) for each image
* Concatenate all generated clips to a final video
* Need to generate silence with the same duration of the clip

## Solution
```sh
ffmpeg -loop 1 -t 3 -i 001.jpg \
-loop 1 -t 5 -i 002.jpg \
-filter_complex "\
[0:v:0]scale=1920:1080:force_original_aspect_ratio=decrease,pad=1920:1080:(ow-iw)/2:(oh-ih)/2,setsar=1,fps=30,format=yuv420p,setpts=PTS-STARTPTS[v0]; \
aevalsrc=0:c=stereo:s=48000:d=3[a0]; \
[1:v:0]scale=1920:1080:force_original_aspect_ratio=decrease,pad=1920:1080:(ow-iw)/2:(oh-ih)/2,setsar=1,fps=30,format=yuv420p,setpts=PTS-STARTPTS[v1]; \
aevalsrc=0:c=stereo:s=48000:d=5[a1]; \
[v0][a0][v1][a1]concat=n=2:v=1:a=1[outv][outa]" \
-map "[outv]" -map "[outa]" \
-c:v libx264 \
-c:a aac \
output.mp4
```

* Use `-loop 1 -t` before `-i` for each image input to specify the duration
* Use `format` filter after `scale` filter to avoid lossing quality
* Use `aevalsrc=0:c=stereo:r=48000:d=X` to generate silence audio

