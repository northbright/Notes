# Download bilibili Videos via Firefox and cURL

## Problem
* Play video on bilibili via Firefox
* Wanna download video
* Press `F12` to inspect the network traffic and only found many `m4s` requests / responses

## Solution
* Press `F12` to open the "Developer Tools"
* Refresh the page to play the video
* Select `XHR` tag on the top right
* Find out the `.m4s` requests
  
  bilibili use separated video and audio FLV streams for playback.

  Example:

  | URL | Size | Type | Comment |
  | :--: | :--: : :--: |
  | 124978976-1-30032.m4s | 556.18 KB | Video | The larger one is video file |
  | 124978976-1-30280.m4s | 194.38 KB | Audio | The smaller one is the audio file |

* Get the total size for video / audio FLV files
  * Click the video / audio request
  * Select "HTTP Headers"
  * Find "Content-Range" in "Response Headers"
    * The last number behind `/` is the total size
    * e.g. `bytes 887133-1456659/41623189` -> Total size is 41623189
  * Record the total size

* Edit and re-send the request of both video and audio FLV files
  * Right click the video / audio request
  * Select "HTTP Headers" > "HTTP Request Headers"
  * Find "Range" and set the range to `0` - `total size`

    e.g. `Range: bytes=0-416231890`
  * Click "Send" button to re-send the HTTP request for full size video / audio FLV
  * You'll get the response with full video / audio FLV
  * Right click the re-sent request, select "Copy" > "Copy as cURL command"
  * Open a shell and paste the cURL command
  * Append `> video.flv` or `> audio.flv` for the command to get audio and video FLV files

* Use ffmpeg to combine the video and audio stream to a single FLV file
  * e.g. `ffmpeg -i "01-video.flv" -i "01-audio.flv" -c:v copy -c:a copy 01-final.flv`

## References
* [爬取B站视频 - m4s文件的相关研究](https://blog.csdn.net/Enderman_xiaohei/article/details/94718494)
* [爬取B站视频 - m4s与flv文件的那些事](https://blog.csdn.net/Enderman_xiaohei/article/details/100598003)
* [B站缓存文件格式m4s简易处理](https://www.jianshu.com/p/e44e9e54619a)

---------------

# 使用火狐浏览器和cURL下载bilibili的视频

## 问题
* 使用火狐播放bilibili的视频
* 希望下载视频
* 按下`F12`来查看网络通信，只发现`m4s`的请求和响应

## 解决方法
* 按下`F12`打开"Developer Tools"
* 刷新页面来重新播放视频
* 选择右上角的`XHR`标签
* 找到`.m4s`的请求

  bilibili使用单独的FLV文件来播放音频和视频

  例子：
  | URL | 大小 | 类型 | 备注 |
  | :--: | :--: : :--: |
  | 124978976-1-30032.m4s | 556.18 KB | Video | 较大的文件是视频文件 |
  | 124978976-1-30280.m4s | 194.38 KB | Audio | 较小的文件是音频文件 |

* 获取视频/音频文件的总大小
  * 点击视频/音频的请求
  * 选择"消息头"
  * 在“响应头”中，找到"Content-Range"
    * 最后面的数字就是文件的总大小
    * e.g. `bytes 887133-1456659/41623189` -> 总大小为 41623189
  * 复制记下这个总大小

* 编辑并重发请求来下载完整的视频/音频文件
  * 右键点击视频/音频的请求
  * 选择"消息头" > "请求消息头"
  * 找到"Range",修改成`0` - `总大小`

    e.g. `Range: bytes=0-41623189`
  * 点击“发送”来重新发送HTTP请求来获取完整的视频/音频FLV文件
  * 获得响应(查看response body大小是否正确)
  * 右键点击刚才的完整的请求，选择“复制” > "复制成cCURL命令"
  * 打开一个shell, 粘贴cURL命令
  * 在最后增加 `> video.flv` 或者 `audio.flv`，回车，来下载整个视频/音频文件

* 使用ffmpeg来合成视频/音频到一个FLV文件
  * e.g. `ffmpeg -i "01-video.flv" -i "01-audio.flv" -c:v copy -c:a copy 01-final.flv`

## 参考
* [爬取B站视频 - m4s文件的相关研究](https://blog.csdn.net/Enderman_xiaohei/article/details/94718494)
* [爬取B站视频 - m4s与flv文件的那些事](https://blog.csdn.net/Enderman_xiaohei/article/details/100598003)
* [B站缓存文件格式m4s简易处理](https://www.jianshu.com/p/e44e9e54619a)
