# Check if a Decoder or Format is Supported in Current Version of ffmpeg

## Solution

#### Check if HEVC decoder is supported:

```sh
ffmpeg -decoders | grep -i hevc --color
```

Output:
```sh
VFS..D hevc                 HEVC (High Efficiency Video Coding)
```

#### Check if MKV(matroska) container(format) is supported:

```sh
ffmpeg -formats | grep -i matroska --color
```

Output:
```sh
E matroska        Matroska
D  matroska,webm   Matroska / WebM
```

