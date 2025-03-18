# Build Source Han Serif Font from Source on macOS for China User

## Problem
* Want to get the [Source Han Serif](https://github.com/adobe-fonts/source-han-serif)(思源宋体) by downloading Github release
* It'll encounter problem when download Github release in China
  * Very slow download speed
  * Network connection may be reset
* You don't want to use Github proxy / mirrors or tools to accelarate the Github download

## Solution
Build Source Han Serif font from source.

* Install Python on macOS
  * [Install Python 3 on macOS](https://github.com/northbright/Notes/blob/master/python/install-python3-on-macos.md)

* Set pip mirror in China
  * [Set Mirror of pip on macOS for China Users](https://github.com/northbright/Notes/blob/master/python/set-mirror-of-pip-on-macos-for-china-users.md)

* Install afdko on macOS
  * [Install afdko on macOS for China User](https://github.com/northbright/Notes/blob/master/font/install-afdko-on-macos-for-china-user.md)

* Fork [Source Han Serif](https://github.com/adobe-fonts/source-han-serif)

  To make it fast, fork [Source Han Serif](https://github.com/adobe-fonts/source-han-serif) and use SSH protocol to git clone the repo.

* Activate Python virtual env for `afdko_env` in last step
    
  ```shell
  source ~/download/afdko_env/bin/activate
  ```

* Build language-specific OTFs

  Follow [COMMANDS.txt](https://github.com/adobe-fonts/source-han-serif/blob/master/COMMANDS.txt)
 to run build command in the specific **WEIGHT**/OTC dir

  e.g. To build regular and bold font of Simplified Chinese

  ```shell
  // Go to Regular/OTC dir
  cd ~/download/source-han-serif/Masters/Regular/OTC

  // Run command
  makeotf -f cidfont.ps.OTC.SC -omitMacNames -ff features.OTC.SC -fi cidfontinfo.OTC.SC \
  -mf ../../../FontMenuNameDB -r -nS -cs 25 \
  -ch ../../../UniSourceHanSerifCN-UTF32-H \
  -ci ../../../SourceHanSerif_CN_sequences.txt ; \
  tx -cff +S cidfont.ps.OTC.SC CFF.OTC.SC ; \
  sfntedit -a CFF=CFF.OTC.SC \
  SourceHanSerifSC-Regular.otf
  ```

  ```shell
  // Go to Bold/OTC dir
  cd ~/download/source-han-serif/Masters/Bold/OTC

  // Run command
  makeotf -f cidfont.ps.OTC.SC -omitMacNames -ff features.OTC.SC -fi cidfontinfo.OTC.SC \
  -mf ../../../FontMenuNameDB -r -nS -cs 25 \
  -ch ../../../UniSourceHanSerifCN-UTF32-H \
  -ci ../../../SourceHanSerif_CN_sequences.txt ; \
  tx -cff +S cidfont.ps.OTC.SC CFF.OTC.SC ; \
  sfntedit -a CFF=CFF.OTC.SC \
  SourceHanSerifSC-Bold.otf
  ```

  * Build OpenType Collection(.ttc) from OTFs

    ```shell
    otf2otc -o ~/download/source-han-serif/Masters/SourceHanSerifSC.ttc \
    ~/download/source-han-serif/Masters/Regular/OTC/SourceHanSerifSC-Regular.otf \
    ~/download/source-han-serif/Masters/Bold/OTC/SourceHanSerifSC-Bold.otf
    ```
 
    It'll generate a "SourceHanSerifSC.ttc" under `~/download/source-han-serif/Masters`.

* Build all variable fonts(VF OTF)(optional)

  * Run build scripts

    ```shell
    cd ~/download/source-han-serif

    ./build/build-source-otfs.sh
    ./buildVFs.sh
    ```

    It'll generate `XX-VF.otf` files(e.g. `./Masters/designspaces/SourceHanSerifSC-VF.otf`).

* Deactivate Python virtual env after use

  ```shell
  deactivate
  ```

## References
* [Source Han Serif 思源宋体](https://source.typekit.com/source-han-sans/cn/)
* [Source Han Serif](https://github.com/adobe-fonts/source-han-serif)
