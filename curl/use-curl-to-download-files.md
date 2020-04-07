# Use cURL to Download Files

## Problem
* Need a tool to download files in terminal
* There's no wget on Mac by default

## Solution
Use cURL to download files

| Option | Decription |
| :--: | :--: |
| -O | use remote file name |
| -o | specify local downloaded file |
| -L | follow 301 redirects |

## Example
```
// Download aria2 from Github
curl -L -O https://github.com/aria2/aria2/releases/download/release-1.35.0/aria2-1.35.0-osx-darwin.dmg
```

## References
* [Download a file with curl on Linux / Unix command line](https://www.cyberciti.biz/faq/download-a-file-with-curl-on-linux-unix-command-line/)
