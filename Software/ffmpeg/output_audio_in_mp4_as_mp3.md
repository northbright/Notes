# Output Audio in MP4 as MP3

## Generic Way
```
ffmpeg -i in.mp4 -f mp3 out.mp3
```

## If you want to extract the audio without re-encoding, check this:
* [Extract Audio Stream in Video Without Re-Encoding](extract-audio-stream-in-video-without-re-encoding.md)


## Start at xx:xx:xx(`-ss`) and duration = xx seconds(`-t`):

`ffmpeg -i in.mp4 -f mp3 -ss 00:03:00 -t 10 out.mp3`
