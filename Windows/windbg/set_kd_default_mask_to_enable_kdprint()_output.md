
# Set `Kd_DEFAULT_Mask` to Enable `KdPrint()` Output

If you add `KdPrint()` in your drivers to output debug messages, you need to set `Kd_DEFAULT_Mask` to `f` in WinDbg to enable the output.

#### "MyDrv.c":  

    ......
    KdPrint(("my value = %d", v));

#### WinDbg Command

    ed nt!Kd_DEFAULT_Mask f

    // To search the variable, you may use
    x nt!*def*mask

#### Reference

[Reading and Filtering Debugging Messages](msdn.microsoft.com/en-us/library/windows/hardware/ff551519(v=vs.85).aspx)

[Kernel trace Windows 7 WinDbg](http://stackoverflow.com/questions/4734335/kernel-trace-windows-7-windbg)