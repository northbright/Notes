# With `os/exec` Each Go String is Already One Argument and We Do Not Need Shell-Style Quoting

## Problem
* Need to use `os/exec` to run ffmpeg to concat HLS segments using ffmpeg [concat protocol](https://trac.ffmpeg.org/wiki/Concatenate#protocol)

* It succeeded to run the following command in macOS terminal:

  ```sh
  ffmpeg -i "concat:01.ts|02.ts" \
  -c copy \
  -bsf:a aac_adtstoasc \
  output.mp4
  ```

* Run the command in Golang and it failed:

  ```go
  var args []string
  args = append(args, "-i")

  // Add quote in raw string.
  concatArg := `"concat`

  files := []string{"01.ts", "02.ts"}

  for i, file := range files {
      if i != len(files) - 1 {
          concatArg += fmt.Sprintf(`%s|`, file)
      } else {
          // Add quote after last file.
          concatArg += fmt.Sprintf(`%s"`, file)
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

  // Output:

  // ffmpeg cmd:
  // ffmpeg -i "concat:01.ts|02.ts" -c copy -bsf:a aac_adtstoasc output.mp4
  // ffmpeg ....
  // Error opening input: No such file or directory
  // Error opening input file "concat:01.ts|02.ts".

  ```

## Root Cause
* When run ffmpeg in shell, shell parses the quotes before the the program runs.
  * Adding quotes for the file paths may contain spaces
    `"concat:foo bar-01.ts|foo bar-02.ts"`

* When run ffmpeg with Golang `os/exec`, ffmpeg does not recognize the `"concat:01.ts|02.ts"` concat protocl but treat it as a normal file path.
* When pass args to `exec.Command`, each go string is **ALREADY** one argument, shell-style quoting is **NO** need
  ```go
  // concatArg := `"concat:01.ts|02.ts"`
  concatArg := `concat:01.ts|02.ts`
  args = append(args, "-i", concatArg, "-c", "copy", "-bsf:a", "aac_adtstoasc", "output.mp4")
  cmd := exec.Command("ffmpeg", args...)
  ```

## Solution
Remove quotes in `exec.Command` concat arg.

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

## References
* [FFmpeg Concat Guide: Demuxer, Filter, Protocol and API](https://renderio.dev/blogs/ffmpeg-concat-guide/)
* [Golang exec Command: Run Shell Commands, Capture Output, and Handle Errors](https://www.golinuxcloud.com/golang-exec-shell-commands/)
