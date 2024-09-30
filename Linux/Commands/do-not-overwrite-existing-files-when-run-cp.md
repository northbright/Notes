# Do Not Overwrite Existing Files when Run `cp`

## Problem
* Batch resize images in "~/img" dir and ouput resized images to "/resized" using `sips`
* `sips` failed to output the resized image due to webp format is not supported
* Need the images failed to resize copied to "resized" dir

## Solution
Use `cp` with `-n` option to copy the left images in "~/img" to "~/resized" dir without overwirting existing resized images.

e.g.
```bash
cp -n -v ~/img/*.jpg ~/resized
```
