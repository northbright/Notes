# Use `yum provides` to Find the Package That Provides The Feature / File You Want

    yum provides <Feature or File>
    // Ex:
    yum provides go

    // For a file <systemd/sd-daemon.h>
    // Use file-glob-syntax wildcards 
    yum provides "*/sd-daemon.h"

    // output:
    systemd-devel-219-30.el7_3.7.x86_64 

#### References
* [Locate RPM packages which contain a certain file](https://major.io/2010/12/08/locate-rpm-packages-which-contain-a-certain-file/)
