# Command to Build Hugo Site

## Solution
```
cd ~/YOUR_SITE
hugo --gc --minify --cleanDestinationDir
```

| Option | Desc |
| :--: | :--: |
| --gc | Remove unused cache files after the build |
| --minify | Minify any supported output format (HTML, XML etc.) |
| --cleanDestinationDir | Remove files from destination not found in static directories |

Run `hugo --help` to see more details.

## References
* [搭建个人blog](https://vinurs.me/posts/1a329bf3-fbb7-4006-9714-d3b072826376/)
