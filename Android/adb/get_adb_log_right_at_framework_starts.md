
# Get adb log right at framework starts

To get the adb log right at reboot(framework startup),  
We need to write a script or command to run `adb logcat` after `adb reboot`

    Ex: On Windows
    adb reboot & adb logcat > 1.txt

You will find the following lines in log indicate that framework startup:  

    AndroidRuntime: >>>>>> START com.android.internal.os.ZygoteInit uid 0 <<<<<<

#### References
* <https://code.google.com/p/android/issues/detail?id=76004>