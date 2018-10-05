
# Concat MP4 Files with FFMPEG without Losing Qaulity

1. Create a text file contains absolute paths of MP4 files:

        file '/home/my/input1.mp4'
        file '/home/my/input2.mp4'
        file '/home/my/input3.mp4'

2. Run ffmpeg with concat demuxer:

        ffmpeg -f concat -safe 0 -i input.txt -codec copy output.mp4

* Reference:  
  <http://superuser.com/questions/607383/concat-two-mp4-files-with-ffmpeg-without-losing-quality>
* [ffmpeg concat: “Unsafe file name”](https://stackoverflow.com/questions/38996925/ffmpeg-concat-unsafe-file-name)
