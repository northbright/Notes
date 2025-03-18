# Build Source Han Sans Font from Source on macOS for China User

## Steps
* Follow [Build Source Han Serif Font from Source on macOS for China User](https://github.com/northbright/Notes/blob/master/font/build-source-han-serif-font-from-source-on-macos-for-china-user.md)
* To build language-specific OTFs, follow [COMMAND.txt](https://github.com/adobe-fonts/source-han-sans/blob/master/COMMANDS.txt)

  e.g. build SourceHanSansSC-Regular and SourceHanSansSC-Bold OTF

  ```shell
  cd ~/download/source-han-sans/Regular/OTC

  makeotf -f cidfont.ps.OTC.SC -omitMacNames -ff features.OTC.SC -fi cidfontinfo.OTC.SC -mf ../../FontMenuNameDB -r -nS -cs 25 -ch ../../UniSourceHanSansCN-UTF32-H -ci ../../SourceHanSans_CN_sequences.txt ; tx -cff +S -no_futile cidfont.ps.OTC.SC CFF.OTC.SC ; sfntedit -a CFF=CFF.OTC.SC SourceHanSansSC-Regular.otf
  ```

  ```shell
  cd ~/download/source-han-sans/Bold/OTC/

  makeotf -f cidfont.ps.OTC.SC -omitMacNames -ff features.OTC.SC -fi cidfontinfo.OTC.SC -mf ../../FontMenuNameDB -r -nS -cs 25 -ch ../../UniSourceHanSansCN-UTF32-H -ci ../../SourceHanSans_CN_sequences.txt ; tx -cff +S -no_futile cidfont.ps.OTC.SC CFF.OTC.SC ; sfntedit -a CFF=CFF.OTC.SC SourceHanSansSC-Bold.otf
  ```

  * Build OpenType Collection(.ttc)

    ```shell
    otf2otc -o ~/download/source-han-sans/SourceHanSansSC.ttc \
    ~/download/source-han-sans/Regular/OTC/SourceHanSansSC-Regular.otf \
    ~/download/source-han-sans/Bold/OTC/SourceHanSansSC-Bold.otf
    ```

    Font names are "SourceHanSansSC-Regular" and "SourceHanSansSC-Bold".

## References
* [Source Han Sans](https://github.com/adobe-fonts/source-han-sans)
* [Get Font Name in CIDFont File](https://github.com/northbright/Notes/blob/master/font/get-font-name-in-cidfont-file.md)
* [Build Source Han Serif Font from Source on macOS for China User](https://github.com/northbright/Notes/blob/master/font/build-source-han-serif-font-from-source-on-macos-for-china-user.md)
