# CRF for libx264 and libx265 Encoder

## CRF
* A lower value is a higher quality
* The range of the CRF scale is 0–51, where 0 is lossless and 51 is worst quality possible.
* 23 is the default value for libx264
* 17 is the "visually-lossless" value for libx264
* A subjectively sane range is 17 – 28
* Every +6 in crf means half the bitrate 
* HEVC(H.265) is 50% more efficient than AVC(H.264)
* 28(23+5) is the default value for libx265
* 23 is the "visually-lossless" value for libx265
* A subjectively sane range is 23 – 33(28+5)

## References
* [H.264 Video Encoding Guide](https://trac.ffmpeg.org/wiki/Encode/H.264)
* [H.265/HEVC Video Encoding Guide](https://trac.ffmpeg.org/wiki/Encode/H.265)
* [In FFMPEG's H.265 encoder, which CRF value leads to "visually lossless" results?](https://video.stackexchange.com/questions/36071/in-ffmpegs-h-265-encoder-which-crf-value-leads-to-visually-lossless-results)
