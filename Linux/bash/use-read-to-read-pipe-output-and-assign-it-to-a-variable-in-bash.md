# Use `read` to Read Pipe Output and Assign It to a Variable in Bash

## Example
Use `ffprobe` to get the duration of a video file in `xx.xx` seconds format and convert the duration to a timestamp in HH:MM:SS format.

```bash
ffprobe -v error -select_streams v:0 -show_entries stream=duration -of csv=s=,:p=0 "01.MOV" | awk -F. '{ print $1 } ' | read sec; hh=$((sec / 3600)); mm=$((sec % 3600 / 60)); ss=$((sec % 3600 % 60)); printf -v timestamp "%02d:%02d:%02d" hh mm ss; echo $timestamp
```

Output:
```bash
00:00:22
```

## References
* [How to Read From Pipe in Bash [5 Cases]](https://linuxsimply.com/bash-scripting-tutorial/redirection-and-piping/piping/read-from-pipe/)
