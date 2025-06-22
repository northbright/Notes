# Specify Output FPS when Concatenate Multiple Videos

## Problem
* Concatenate 2 or more videos to one output video
* Need to set the output FPS

## Solution
Use `-r FPS` option for `ffmpeg`

```bash
ffmpeg \
-i "FILE_1"
-i "FILE_N"
-filter_complex \
"
[0:v]FILTER_1,FILTER_2,...FILTER_N[0_v];
[0:a]FILTER_1,FILTER_2,...FILTER_N[0_a];
[1:v]FILTER_1,FILTER_2,...FILTER_N[1_v];
[1:a]FILTER_1,FILTER_2,...FILTER_N[1_a];
......
[N:v]FILTER_1,FILTER_2,...FILTER_N[N_v];
[N:a]FILTER_1,FILTER_2,...FILTER_N[N_a];
[0_v][0_a][1_v][1_a]...[n_v][n_a]FILTER_HAS_MULTI_INPUT_AND_OUTPUT[out_v][out_a]" \
-map "[out_v]" -map "[out_a]" \
-r FPS \
output.mp4
```

## References
* [How to concatenate two or more videos with different framerates in FFMpeg?](https://stackoverflow.com/questions/55794240/how-to-concatenate-two-or-more-videos-with-different-framerates-in-ffmpeg)
