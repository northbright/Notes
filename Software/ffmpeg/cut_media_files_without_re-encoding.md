# Cut Media Files without Re-Encoding

## Solution
Use ffmpeg to cut audio / video file.

```
// Cut audio file: start from 00:00:30, duration: 10 seconds
ffmpeg -ss 00:00:30.00 -t 00:00:10 -i old.mp3 -codec copy new.mp3

// Cut video file: start from 00:00:00, duration 5 minutes
 ./ffmpeg -ss 00:00:00.00 -t 00:05:00 -i 01.mp4 -c:v copy -c:a copy 01_part_1.mp4

```

## Options
* `-ss`  
  Start time(second)

* `-t`  
  Duration(HH:MM:SS)

* `-i`
  Input File

* `-codec copy`  
  Copy the codec and there's no re-decoding / encoding.

## References
* <https://www.ffmpeg.org/ffmpeg.html#Stream-copy>
* [Cutting the videos based on start and end time using ffmpeg](https://stackoverflow.com/questions/18444194/cutting-the-videos-based-on-start-and-end-time-using-ffmpeg)
