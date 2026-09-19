# Use ffprobe to Get Image Information

## Solution
Use ffprobe to get the video stream of a image file.

```sh
ffprobe -v error -select_streams v:0 -show_entries format:stream -of json input.jpg
```

Output:

```sh
{
    "streams": [
        {
            "index": 0,
            "codec_name": "mjpeg",
            "codec_long_name": "Motion JPEG",
            "profile": "Baseline",
            "codec_type": "video",
            "codec_tag_string": "[0][0][0][0]",
            "codec_tag": "0x0000",
            "width": 3024,
            "height": 4032,
            "coded_width": 3024,
            "coded_height": 4032,
            "closed_captions": 0,
            "film_grain": 0,
            "has_b_frames": 0,
            "sample_aspect_ratio": "1:1",
            "display_aspect_ratio": "3:4",
            "pix_fmt": "yuvj420p",
            "level": -99,
            "color_range": "pc",
            "color_space": "bt470bg",
            "chroma_location": "center",
            "refs": 1,
            "r_frame_rate": "25/1",
            "avg_frame_rate": "25/1",
            "time_base": "1/25",
            "start_pts": 0,
            "start_time": "0.000000",
            "duration_ts": 1,
            "duration": "0.040000",
            "bits_per_raw_sample": "8",
            "disposition": {
                "default": 0,
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
            }
        }
    ],
    "format": {
        "filename": "input.jpg",
        "nb_streams": 1,
        "nb_programs": 0,
        "format_name": "image2",
        "format_long_name": "image2 sequence",
        "start_time": "0.000000",
        "duration": "0.040000",
        "size": "2719490",
        "bit_rate": "543898000",
        "probe_score": 50
    }
}
```

## Codec Names

| Image Format | `codec_name` | Description |
| :--: | :--: | :--: |
| JPEG / JPG | mjpeg | 最常见，ffprobe 把 JPEG 当作 Motion JPEG 处理 |
| PNG | png | 无损，带 Alpha 通道 |
| BMP | bmp | Windows 位图 |
| GIF | gif 支持动画，256 色 |
| TIFF / TIF | tiff | 印刷、扫描常见 |
| WebP | webp | 网页常用，支持有损/无损/动画 |
| AVIF | av1 基于 AV1 帧内编码 |
| JPEG XL | jpegxl | 较新格式，需要 FFmpeg 带 libjxl 支持 |
| HEIC / HEIF | hevc 或其他 取决于内部编码，常见是 HEVC；FFmpeg 原生支持取决于版本和库 |
