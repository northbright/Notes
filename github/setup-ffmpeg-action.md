# Setup FFmpeg Action

## Solution

```yaml
    - name: Setup FFmpeg on Linux
      if: runner.os == 'Linux'
      run: |
        sudo apt-get update -q -q
        sudo apt-get install --yes ffmpeg

    - name: Setup FFmpeg on macOS
      if: runner.os == 'macOS'
      run: brew install ffmpeg

    - name: Setup FFmpeg on Windows
      if: runner.os == 'Windows'
      run: choco install ffmpeg

    - name: Run FFmpeg
      run: ffmpeg -version
```

## References
* <https://github.com/federicocarboni/setup-ffmpeg/issues/21#issuecomment-2480376403>
