# Extract File Name and Extension in Bat

## Problem
* Need to extract file name only and extension only of filename variable in Bat

## Solution
* Use `%~nI` to extract file name only
* Use `%~xI` to extract extension only

## Example
```bat
for /r %%i in (*.jpg *.jpeg *.png) do (
    ffmpeg -i "%%i" -vf scale=-1:2160 "%%~ni"_2k."%%~xi"
)
```

## References
* [How can I get the name of a windows .bat script from within the script itself?](https://serverfault.com/questions/65675/how-can-i-get-the-name-of-a-windows-bat-script-from-within-the-script-itself)
