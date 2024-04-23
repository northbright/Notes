# Install FFmpeg on macOS

## Download Static Build of FFmpeg
* Visit [FFmpeg Download for mac](https://ffmpeg.org/download.html#build-mac)
* Click macOS > Static builds for macOS 64-bit
* It'll redirect to <https://evermeet.cx/ffmpeg/>
* Download `ffmpeg`, `ffprobe` as zip to `/Users/xx/Downloads/`


## Create `/usr/local/ffmpeg/bin`
```bash
sudo mkdir -p /usr/local/ffmpeg/bin
```

* Unzip and Move `ffmpeg`, `ffprobe` to `/usr/local/ffmpeg/bin`
```bash
cd /Users/xx/Downloads
unzip ffmpeg-6.1.1.zip
unzip ffprobe-6.1.1.zip
```

```bash
sudo mv /Users/xx/Downloads/ffmpeg /usr/local/ffmpeg/bin/
sudo mv /Users/xx/Downloads/ffprobe /usr/local/ffmpeg/bin/
```

## Add Binary Path to `~/.zprofile`

```bash
vi ~/.zprofile
```

```bash
# FFmpeg
export PATH=$PATH:/usr/local/ffmpeg/bin
```

```
source ~/.zprofile
```

## Check
```bash
which ffmpeg
which ffprobe
```
