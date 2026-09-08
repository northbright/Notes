# Links in Go Comment

## Problem
* Need to add a link in go doc comment

## Solution
* Define a link target in go doc comment

```go
// [Text]: URL
```

* Use [Text] in the same go doc comment to represents the link

## Example

```go
// AddSoftSubtitleCommand returns the command to adds a soft subtitle track to the video.
// input: input video.
// srtFile: srt file.
// lang: three-letter [ISO 639-2 Code](e.g. "eng", "spa", "chi").
// title: a user-friendly name for the subtitle track selection menu(e.g. "English", "Spanish", "Chinese").
// [ISO 639-2 Code]: https://www.loc.gov/standards/iso639-2/php/code_list.php
func AddSoftSubtitlesCommand(input, srtFile, lang, title, output string) (*exec.Cmd, error) {
    return nil, nil
}
```

## References
* [Links](https://go.dev/doc/comment#links)
