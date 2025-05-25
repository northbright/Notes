# Show All Entries of FORMAT and STREAM Section of Input using ffprobe

## Show all entires of FORMAT section

* Method A: Use `-show_format` option

```bash
ffprobe -v error -show_format -of default=noprint_wrappers=1 input.mp4
```

Output:
```bash
filename=input.mp4
nb_streams=2
nb_programs=0
format_name=mov,mp4,m4a,3gp,3g2,mj2
format_long_name=QuickTime / MOV
start_time=0.000000
duration=25.833333
size=9511501
bit_rate=2945497
probe_score=100
TAG:major_brand=isom
TAG:minor_version=512
TAG:compatible_brands=isomiso2avc1mp41
TAG:encoder=Lavf60.16.100
```

* Method B: Use `-show_entries` with `format` section name

```bash
ffprobe -v error -show_entries format: -of default=noprint_wrappers=1 input.mp4
```

  `format` is the section name, and it's followed by no "=" will print all entries of the section(format)

Output is the same as previous method A's.

## Show specified entrie(s) of FORMAT section(e.g. duration)

```bash
ffprobe -v error -show_entries format=duration,size -of default=noprint_wrappers=1 input.mp4
```

Output:
```bash
duration=25.833333
size=9511501
```

If you don't need the prefixes("duration=" and "size="), use `-of csv=s=,:p=0` option.

```bash
ffprobe -v error -show_entries format=duration,size -of csv=s=,:p=0 input.mp4
```

Output:
```bash
25.833333,9511501
```

* `-of csv` -> use CSV output format
* `s=,` -> use "," as separator
* `p=0` -> ignore "format" prefix.

## Show all entries of STREAM section for selected streams(e.g. v:0 -> first video stream, a -> all audio streams)

* Method A: use `-show_streams` option

```bash
ffprobe -v error -show_streams -select_streams v:0 -of default=noprint_wrappers=1 input.mp4
```

Output:

```bash
index=0
codec_name=h264
codec_long_name=H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10
profile=High
codec_type=video
codec_tag_string=avc1
codec_tag=0x31637661
width=1280
height=720
coded_width=1280
coded_height=720
closed_captions=0
film_grain=0
has_b_frames=2
sample_aspect_ratio=1:1
display_aspect_ratio=16:9
pix_fmt=yuv420p
level=31
color_range=tv
color_space=unknown
color_transfer=unknown
color_primaries=bt709
chroma_location=left
field_order=progressive
refs=1
is_avc=true
nal_length_size=4
id=0x1
r_frame_rate=30/1
avg_frame_rate=30/1
time_base=1/15360
start_pts=0
start_time=0.000000
duration_ts=396800
duration=25.833333
bit_rate=2806474
max_bit_rate=N/A
bits_per_raw_sample=8
nb_frames=775
nb_read_frames=N/A
nb_read_packets=N/A
extradata_size=49
DISPOSITION:default=1
DISPOSITION:dub=0
DISPOSITION:original=0
DISPOSITION:comment=0
DISPOSITION:lyrics=0
DISPOSITION:karaoke=0
DISPOSITION:forced=0
DISPOSITION:hearing_impaired=0
DISPOSITION:visual_impaired=0
DISPOSITION:clean_effects=0
DISPOSITION:attached_pic=0
DISPOSITION:timed_thumbnails=0
DISPOSITION:non_diegetic=0
DISPOSITION:captions=0
DISPOSITION:descriptions=0
DISPOSITION:metadata=0
DISPOSITION:dependent=0
DISPOSITION:still_image=0
TAG:language=und
TAG:handler_name=VideoHandler
TAG:vendor_id=[0][0][0][0]
TAG:encoder=Lavc60.31.102 libx264
```

* Method B: use `-show_entries` option with `stream` section name

```bash
ffprobe -v error -show_entries stream: -select_streams v:0 -of default=noprint_wrappers=1 input.mp4
```

Output is the same as method A's.

## Show specified entries of stream section(e.g. width, height)

```bash
ffprobe -v error -show_entries stream=width,height -select_streams v:0 -of default=noprint_wrappers=1 input.mp4
```

Output:
```bash
width=1280
height=720
```

If you don't need "width=" and "height=", use "-of csv=s=x:p=0".

```bash
ffprobe -v error -show_entries stream=width,height -select_streams v:0 -of csv=s=x:p=0 input.mp4
```

Output:
```bash
1280x720
```

## References
* [ffprobe Documentation](https://ffmpeg.org/ffprobe.html)
* [One liner ffmpeg (or other) to get only resolution?](https://askubuntu.com/questions/577090/one-liner-ffmpeg-or-other-to-get-only-resolution)
