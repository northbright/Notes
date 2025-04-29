# Use FFmpeg to Mix Original Audio Stream in Video File and BGM

## Solution
```bash
ffmpeg -i input.mp4 -i bgm.m4a -c:v copy \
-filter_complex \
"[0:a:0][1:a:0]amerge=inputs=2,pan=stereo|c0<c0+c2|c1<c1+c3[a]" \
-map 0:v -map "[a]" -c:v copy -shortest \
output-with-bgm-mixed.mp4
```

## References
* [Manipulating audio channels](https://trac.ffmpeg.org/wiki/AudioChannelManipulation)
