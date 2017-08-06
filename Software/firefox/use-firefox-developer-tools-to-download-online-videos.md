# Use Firefox Developer Tools to Download Online Videos

#### Problem
* Need to download online videos(e.g. bilibili.com)

#### Solution
* Open Firefox and naviate to the page to watch online video(Do NOT play the video).
* Press `F12` to Open Firefox Developer Tools.
* Click "Network" tab to monitor network traffic.
* Click "reload" icon or `F5` to reload the page.
* Play the video on the page.
* Click the "Size" column to sort URLs by desc order to find the video URL resource(the largest in most case).
* Right click on this row and select "Copy as cURL".
  * Select "Copy URL" and paste it to download the video may fail for some site because the HTTP header data is missing which will be check by the server side.
  * "Copy as cURL" will copy not only the URL but also HTTP header info to reproduce the HTTP Request).
* Open a shell and paste the [cURL](https://curl.haxx.se/) command and append `> ~/xx.mp4` to download the video file.

        // For example
        curl 'https://ws.acgvideo.com/a/a3/XX.flv?wsTime=XX&platform=pc&wsSecret2=XX&oi=XX&rate=1280' -H 'Host: ws.acgvideo.com' -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:54.0) Gecko/20100101 Firefox/54.0' -H 'Accept: */*' -H 'Accept-Language: zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3' --compressed -H 'Referer: https://www.bilibili.com/video/avXX/?from=search&seid=XX' -H 'Origin: https://www.bilibili.com' -H 'Connection: keep-alive' -H 'Pragma: no-cache' -H 'Cache-Control: no-cache' > ~/01.flv 
