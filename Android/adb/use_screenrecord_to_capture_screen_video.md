
# Use `screenrecord` to Capture Screen Video

#### Example:

    $ adb shell
    shell@ $ screenrecord --verbose /sdcard/demo.mp4
    (press Ctrl-C to stop)
    shell@ $ exit
    $ adb pull /sdcard/demo.mp4

#### Example with Params
    adb shell screenrecord –-size 640x480 –-bit-rate 3000000 /sdcard/my.mp4

    --size <WIDTHxHEIGHT>
    --bit-rate <RATE>

#### Stop Recording
You may press `ctrl + C` to stop recording.

#### References
<http://developer.android.com/tools/help/adb.html#screenrecord>
