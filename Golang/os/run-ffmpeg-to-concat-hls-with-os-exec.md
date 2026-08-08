# Run FFmpeg to Concat HLS with `os.exec`

## Solution
```go
var args []string
args = append(args, "-i")
  
// No need to add quotes.
concatArg := `concat`
  
files := []string{"01.ts", "02.ts"}

for i, file := range files {
    if i != len(files) - 1 {
        concatArg += fmt.Sprintf(`%s|`, file)
    } else {
        // No need to add quote after last file.
        concatArg += fmt.Sprintf(`%s`, file)
    }
} 

args = append(args, concatArg)
args = append(args, "-c", "copy", "-bsf:a", "aac_adtstoasc")
args = append(args, "output.mp4"
      
cmd := exec.Command("ffmpeg", args...)
      
log.Printf("ffmpeg cmd:\n%s", cmd.String())
          
// Run the command.
stdoutStderr, err := cmd.CombinedOutput()
if err != nil {
   return 0, fmt.Errorf("ffmpeg command error: %s, output: %s", err, stdoutStderr)
} 
```

* When run ffmpeg in shell, shell parses the quotes before the the program runs.
  * Adding quotes for the file paths may contain spaces
    `"concat:foo bar-01.ts|foo bar-02.ts"`

* When pass args to `exec.Command`, each go string is **ALREADY** one argument, shell-style quoting is **NO** need 

  ```go
  // Incorrect
  args = append(args, `"concat:01.ts|02.ts"`)
  ```

  // Correct
  args = append(args, `concat:01.ts|02.ts`)
  ```

## References
* [FFmpeg Concat Guide: Demuxer, Filter, Protocol and API](https://renderio.dev/blogs/ffmpeg-concat-guide/)
* [Golang exec Command: Run Shell Commands, Capture Output, and Handle Errors](https://www.golinuxcloud.com/golang-exec-shell-commands/)
