# Download All Videos of an URL on Bilibili Using [you-get](https://github.com/soimort/you-get)

## Solution
* Use `-l`(`--playlist`) option

## Example
```
// Use -i option to get extracted information of all videos
you-get -i -l "https://www.bilibili.com/video/xxxx"

// Download all videos
you-get -l -o ~/videos "https://www.bilibili.com/video/xxxx"

// Download specified part of the videos
// You may click part on the page and copy the URL which has suffix: `?p=xx`
you-get -l -o ~/videos "https://www.bilibili.com/video/xxxx?p=xx"
```

## References
* [如何使用you-get下载整个视频列表?](https://www.zhihu.com/question/335881282)
