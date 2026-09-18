# `-disposition` is Used in Output Streams

## Problem
* input video has 2 subtitle streams(s:0 -> English, s:1 -> Chinese)
* `s:0` is set as default
* Need to unset s:0 as the default subtitle
* Run the following command

  ```sh
  ffmpeg -i input -disposition:s:0 none -c copy output
  ```
* 2nd subtitle stream was removed in output

## Root Cause
* Without `-map 0` for input, ffmpeg will select only **ONE** stream for each stream type 

## Solution
Add `-map 0` to select all streams(include all subtitle streams) of input.

* Unset English as the default subtitle stream

```sh
ffmpeg -i input -map 0 -disposition:s:0 none -c copy output
```

* Set Chinese as the default subtitle stream

```sh
ffmpeg -i input -map 0 -disposition:s:1 default -c copy output
```
