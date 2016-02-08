# Convert Specific Video and Audio Track Only with ffmpeg

## Solution

Use `-map` option

    ffmpeg -i in.mkv -c:v libx264 -c:a ac3 -crf 20 -map 0:v:0 -map 0:a:1 out.mp4

* `-map 0:v:0` - 1st video stream(0-based index)
* `-map 0:a:1` - 2nd audio stream(0-based index)

## References
* [Convert specific video and audio track only with ffmpeg](http://superuser.com/questions/639402/convert-specific-video-and-audio-track-only-with-ffmpeg)