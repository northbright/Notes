# Install [Microsoft Edge](https://www.microsoft.com/zh-cn/edge) on macOS

## Steps
* Open Safari and visit [Microsoft Edge Download Page](https://www.microsoft.com/zh-cn/edge)
* Select "masOS" version > Select "Intel Chip" or "Apple Chip" and download the pkg file
* If the download speed is very slow or it fails many times, you may use [aria2](https://github.com/aria2/aria2/) to download it. See [Install aria2 from Source on Mac OS X](https://github.com/northbright/Notes/blob/master/aria2/install-aria2-from-source-on-mac-os-x.md) for more

  ```
  cd ~/download
  aria2c "https://officecdnmac.microsoft.com/pr/C1297A47-86C4-4C1F-97FA-950631F94777/MacAutoupdate/MicrosoftEdge-105.0.1343.33.pkg?platform=Mac&Consent=0&channel=Stable"
  ```

* Open Finder and click the package to install Microsoft Edge
