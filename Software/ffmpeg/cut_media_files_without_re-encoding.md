# Cut Media Files without Re-Encoding

`ffmpeg -ss 00:00:30.00 -t 25 -i old.mp3 -codec copy new.mp3`

* `-ss`  
  Start time

* `-t`  
  Duration

* `-i`  
  Input File

* `-codec copy`  
  Copy the codec and there's no re-decoding / encoding.

#### References
* <https://www.ffmpeg.org/ffmpeg.html#Stream-copy>