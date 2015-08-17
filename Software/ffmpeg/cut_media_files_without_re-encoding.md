# Cut Media Files without Re-Encoding

`ffmpeg -i old.mp3 -ss 00:00:30.00 -t 25 -codec copy new.mp3`

* `-i`  
  Input File

* `-ss`  
  Start time(second)

* `-t`  
  Duration

* `-codec copy`  
  Copy the codec and there's no re-decoding / encoding.

#### References
* <https://www.ffmpeg.org/ffmpeg.html#Stream-copy>