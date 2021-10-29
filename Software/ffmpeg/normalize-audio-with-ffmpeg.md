# Normalize Audio with ffmpeg

## Solution
1. Find out the gain to apply

   ```
   ffmpeg -i "input.m4a" -af "volumedetect" -vn -sn -dn -f null /dev/null
   ```

   ```
   // Record the max_volume in the output:
   ......
   mean_volume: -25.4 dB
   max_volume: -10.9 dB   // <- record this for peak normalization
   ......

   // Record the audio encoder and bitrate in the output:
   ......
   Stream #0:0(und): Audio: aac (LC) (mp4a / 0x6134706D), 48000 Hz, stereo, fltp, 317 kb/s (default)
   ......
   ```

2. Apply the volume filter according to the `"max_volume"`, "audio encoder" and "audio bitrate"

   * Volume filter usage: "volume=xxdB"
     * `xx` = abs(`"max_volume"`)
       e.g. "volume=10dB" for last example
       
       Make sure `'B'` is captialized or the command will fail     
 
   * Volume filter can not be used with "-c:a copy" at the same time.
       
       We can use original audio encoder and audio bitrate to re-encode the audio.


   ```
   ffmpeg -i "input.m4a" -af "volume=10dB" -c:v copy -c:a aac -b:a 320k "Output(normalized).m4a"
   ```

## References
* [How can I normalize audio using ffmpeg?](https://superuser.com/questions/323119/how-can-i-normalize-audio-using-ffmpeg)
