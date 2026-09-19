# Get Width and Height of HEIC with ffprobe

## Problem
* Use ffprobe 9.0.2 to get information of an HEIC image
 
  ```sh
  ffprobe -v error -select_streams v:0 -show_entries format:stream -of json input.HEIC
  ```

  Output:

  ```sh
  {
        "streams": [
            {      
                "index": 0,
                "codec_name": "hevc",
                "width": 512,
                "height": 512,
                ......
            }
        ]
  } 
  ```
* Width and Height are always 512 x 512

## Root Cause
* HEIC's type is "Tile Grid".
* It contains many tiles(512 x 512).
* ffprobe returns the incorrect width / height in video stream

## Solution
Use `-select_stream_groups` option.

```sh
ffprobe -v error \
-show_entries 'stream_group=index,id,type:stream_group_component=width,height,nb_tiles,coded_width,coded_height' \
-of default=noprint_wrappers=1 \
~/Downloads/mimao.HEIC
```

Output:
```sh
index=0
id=0x31
type=Tile Grid
nb_tiles=48
coded_width=4096
coded_height=3072
width=4032
height=3024
```

## References
* [【FFmpeg】ffprobeでHEICのサイズが違う件](https://mohhh-ok.github.io/blog/posts/2026/05-22-ffmpegffprobe%E3%81%A7heic%E3%81%AE%E3%82%B5%E3%82%A4%E3%82%BA%E3%81%8C%E9%81%95%E3%81%86%E4%BB%B6/)
