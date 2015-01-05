
# Run CTS under Windows

1. Make sure adb-bundle / jdk were installed.
2. Download CTS and unzip
3. Create a new folder: `d:\cts`
4. Copy unzipped `android-cts` folder under `d:\cts`.  
5. Create a `run_cts.bat`:  

        set SDK_ROOT=D:\adt-bundle\sdk
        java -Xmx512M -cp d:\cts\android-cts\tools\cts-tradefed.jar;d:\cts\android-cts\tools\hosttestlib.jar;d:\cts\android-cts\tools\ddmlib-prebuilt.jar;d:\cts\android-cts\tools\tradefed-prebuilt.jar -DCTS_ROOT=d:\cts com.android.cts.tradefed.command.CtsConsole
6. Open a CMD window and run `run_cts.bat`:
7. Run CTS test. Ex:

        cts-tf > run cts -c android.accessibilityservice.cts.AccessibilityTextTraversalTest -m testActionNextAndPreviousAtGranularityPageOverText