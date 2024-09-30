# Use SIPS to Batch Resize Images on macOS

## Problem
* Need to resize images on macOS via command line

## Solution
Run "sips" to batch resize images.

* Batch Resize Images(`*.jpg`) with Max Height Set to 2160 and keep the aspect ratio(`-Z` option) in a Dir

```bash
cd ~/images

sips -Z 2160 *.jpg
```

* Output Resized Images to another Dir
We need to create a bash script.

```bash
vi batch-resize.sh
```

```bash
#!/bin/sh

# Get 1st arg as max height passed to SIPS
maxheight="$1"

# Make a dir to store resized images.
mkdir -p "./resized"

# Use default max height if max height is not set.
if [ "$maxheight" = "" ]; then
    maxheight="1080"
fi

echo "resize images with max height = $maxheight"

for file in *.jpg; 
  do
    echo "run sips -Z ${maxheight}";
    sips -Z "$maxheight" "$file" --out "resized/${file}";
done
```

```bash
chmod a+x batch-resize.sh
```

e.g. Resize all images with max height set to 2160 and keep the aspect ratio.
The resized images are output under "./resized" dir.
```bash
cd ~/images

./batch-resize.sh 2160
```

## References
* [How to Use macOS SIPS to Batch Resize Images](https://havecamerawilltravel.com/macos-sips-batch-resize-images/)
