# Get Video Info via ffprobe

Use `-show_entries` option in `ffprobe`

```sh
-show_entries <section>=<field1>,<field2>,...
```

| Section | Description |
| :--: | :--: |
| format | container info: duration, size... |
| stream | stream info: codec name, frame rate... |

## Get Video Duration in Seconds

```bash
ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 input.mp4

// Output:
31.880998
```

## Get Video Resolution

```sh
ffprobe -v error -select_streams v:0 -show_entries stream=width,height -of csv=s=x:p=0 input.mp4

// Output:
854x480
```

## Get Codec Name

```sh
ffprobe -v error -select_streams v:0 -show_entries stream=codec_name -of default=noprint_wrappers=1:nokey=1 input.mp4

// Output:
h264
```

```sh
ffprobe -v error -select_streams a:0 -show_entries stream=codec_name -of default=noprint_wrappers=1:nokey=1 input.mp4

// Output:
aac
```

## Show Info in JSON format

Use `-of json` option.


* Show all format info and the info of 1st video stream in JSON format.

```sh
ffprobe -v error -select_streams v:0 -show_entries format:stream -of json input.mp4
```

Output:

```json
{
    "programs": [

    ],
    "streams": [
        {
            "index": 0,
            "codec_name": "h264",
            "codec_long_name": "H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10",
            "profile": "High",
            "codec_type": "video",
            "codec_tag_string": "avc1",
            "codec_tag": "0x31637661",
            "width": 854,
            "height": 480,
            "coded_width": 854,
            "coded_height": 480,
            "closed_captions": 0,
            "film_grain": 0,
            "has_b_frames": 2,
            "sample_aspect_ratio": "1:1",
            "display_aspect_ratio": "427:240",
            "pix_fmt": "yuv420p",
            "level": 31,
            "chroma_location": "left",
            "field_order": "progressive",
            "refs": 1,
            "is_avc": "true",
            "nal_length_size": "4",
            "id": "0x1",
            "r_frame_rate": "30000/1001",
            "avg_frame_rate": "13088000/436703",
            "time_base": "1/16000",
            "start_pts": 0,
            "start_time": "0.000000",
            "duration_ts": 4803733,
            "duration": "300.233313",
            "bit_rate": "186495",
            "bits_per_raw_sample": "8",
            "nb_frames": "8998",
            "extradata_size": 44,
            "disposition": {
                "default": 1,
                "dub": 0,
                "original": 0,
                "comment": 0,
                "lyrics": 0,
                "karaoke": 0,
                "forced": 0,
                "hearing_impaired": 0,
                "visual_impaired": 0,
                "clean_effects": 0,
                "attached_pic": 0,
                "timed_thumbnails": 0,
                "non_diegetic": 0,
                "captions": 0,
                "descriptions": 0,
                "metadata": 0,
                "dependent": 0,
                "still_image": 0
            },
            "tags": {
                "language": "und",
                "handler_name": "VideoHandler",
                "vendor_id": "[0][0][0][0]"
            }
        }
    ],
    "format": {
        "filename": "input.mp4",
        "nb_streams": 2,
        "nb_programs": 0,
        "format_name": "mov,mp4,m4a,3gp,3g2,mj2",
        "format_long_name": "QuickTime / MOV",
        "start_time": "0.000000",
        "duration": "300.288167",
        "size": "9843059",
        "bit_rate": "262229",
        "probe_score": 100,
        "tags": {
            "major_brand": "isom",
            "minor_version": "512",
            "compatible_brands": "isomiso2avc1mp41",
            "encoder": "Lavf60.16.100",
            "description": "Packed by Bilibili XCoder v2.0.2"
        }
    }
}
```

## References
* [How to get video duration in seconds?](https://superuser.com/questions/650291/how-to-get-video-duration-in-seconds)
* [ffprobe Documentation](https://ffmpeg.org/ffprobe.html)
* [千问: 输入"ffprobe -show_entries 参数"](https://www.qianwen.com/)
