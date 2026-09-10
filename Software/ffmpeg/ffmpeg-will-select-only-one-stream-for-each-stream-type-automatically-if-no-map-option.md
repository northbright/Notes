# FFmpeg will Select Only One Stream for Each Stream Type Automatically if No Map Option

## Problem
* Add 2 subtitle streams(English and Chinese) to "input.mkv"
* "input.mkv" has only 1 video stream and 1 audio stream
* "input.mkv" has NO subtitle stream
* Add English subtitle successfully:

  ```sh
  ffmpeg -i input.mkv -i eng.srt -c copy output-eng.mkv
  ```

  * Use ffprobe to get subtitle streams. It returns one stream(English).
  
    ```sh
    ffprobe -v error -select_streams s -show_entries format:stream -of json output-eng.mkv
    ```

    ```sh
    // Output
    "streams": [
        {
            "index": 2,
            "codec_name": "subrip",
            "codec_long_name": "SubRip subtitle",
            "codec_type": "subtitle",
            ......
        }
    ]
    ```
* Failed to add Chinese subtitle to "output-eng.mkv":

  ```sh
  ffmpeg -i output-eng.mkv -i chi.srt -c copy output-eng-chi.mkv
  ```

  * Use ffprobe to get subtitle streams. It still returns one stream(English) but not two.

    ```sh
    ffprobe -v error -select_streams s -show_entries format:stream -of json output-eng.mkv
    ```
    
    ```sh
    // Output
    "streams": [
        {
            "index": 2,
            "codec_name": "subrip",
            "codec_long_name": "SubRip subtitle",
            "codec_type": "subtitle",
            ......
        }
    ]
    ```

## Root Cause

If `-map` option is not set, ffmpeg will select(pick) only **ONE** stream for each stream type automatically.
* For video stream: the most resolution(best quality)
* For audio stream: the most channels
* For audio stream: the first subtitle stream

#### The 1st command to add English subtitle works because that input.mkv has no subtitle stream.

```sh
ffmpeg -i input.mkv -i eng.srt -c copy output.mkv
```

* The command works.
* If no `-map', ffmpeg will select only 1 stream for each type(video, audio, stream) automatically
  * Select the video / audio stream in input.mkv
  * Because "input.mkv" has only 1 video / audio stream, there's no other choice
  * It select the only SRT stream in "eng.srt"

* The command above equals to:

  ```sh
  ffmpeg -i input.mkv -i eng.srt -c copy -map 0 -map 1 output.mkv
  ```

  * `-map 0`: select all streams in input #1("input.mkv")
  * `-map 1`: select all streams in input #2("eng.srt")
    * equals to `-map 1:s` or `-map 1:s:0` because that `eng.srt` has the only subtitle stream

#### The 2nd command to add Chinese subtitle fails because that output-eng.mkv has one subtitle stream and no `-map` option

```sh
ffmpeg -i output-eng.mkv -i chi.srt -c copy output-eng-chi.mkv 
```

ffmpeg will select the first subtitle stream(output-eng.mkv's s:s:0) as the final subtitle stream and the subtitle stream in chi.srt is discarded.

## Solution

**ALWAYS** use `-map` option in ffmpeg when it has multiple inputs.

* Add English Subtitle

  ```sh
  ffmpeg -i input.mkv -i eng.srt -c copy -map 0 -map 1 output-eng.mkv
  ```

* Add Chinese Subtitle

  ```sh
  ffmpeg -i output-eng.mkv -i chi.srt -c copy -map 0 -map 1 output-eng-chi.mkv
  ```

# References
* [ffmpeg-map](https://blog.csdn.net/feiyu5323/article/details/118262806)
* [Stream selection](https://ffmpeg.org/ffmpeg.html#Stream-selection)
* [Automatic stream selection](https://ffmpeg.org/ffmpeg.html#Automatic-stream-selection)
* [Advanced options](https://ffmpeg.org/ffmpeg.html#Advanced-options)
* [Streamcopy](https://ffmpeg.org/ffmpeg.html#Streamcopy)
