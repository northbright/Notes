# Bulk Set Original Date and Time of Photos using ExifTool

## Problem
Need to bulk set original date and time of all photos in a dir to a fixed timestamp.

## Solution
Use [ExifTool](https://exiftool.org/) to change original date / time of photos.

```bash
exiftool -DateTimeOriginal="YYYY:MM:DD HH:MM:SS" -overwrite_original <DIR>
```

## Example
* Set original date / time of all photos in `~/my_photos` to `2024/11/12 20:00:00`.

  ```bash
  exiftool -DateTimeOriginal="2024:11:12 20:00:00" -overwrite_original ~/my_photos
  ```

* Check original date / time of one photo.

  ```bash
  exiftool ~/my_photos/01.heic | grep -i "original"

  // Output:
  Date/Time Original              : 2024:11:12 20:00:00
  ```

## References
* [How to modify image EXIF metadata - Date Created / Date Modified [Command line tool]](https://yarnaudov.com/modify-image-exif-metadata-dates.html)
