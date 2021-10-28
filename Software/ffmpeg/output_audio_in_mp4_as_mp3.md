# Output Audio in MP4 as MP3

## Generic Way
```
ffmpeg -i in.mp4 -f mp3 out.mp3
```

## Start at xx:xx:xx(`-ss`) and duration = xx seconds(`-t`):

`ffmpeg -i in.mp4 -f mp3 -ss 00:03:00 -t 10 out.mp3`
