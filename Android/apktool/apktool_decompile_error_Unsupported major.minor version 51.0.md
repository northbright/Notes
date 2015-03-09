
# How to Fix apktool Decomile Error: Unsupported major.minor version 51.0

#### Root Cause

* That happens when your main system version java is older than version 7.  
See <http://blog.csdn.net/zangcf/article/details/8930758>

#### How to Fix:

* Install apktool 2.x(need jdk 7 or later):  

  * Download apktool jar(Linux)  
    <https://bitbucket.org/iBotPeaches/apktool/downloads>  
    `cd apktool`  
    `wget https://bitbucket.org/iBotPeaches/apktool/downloads/apktool_2.0.0rc4.jar`  
    
   * Rename `apktool_x.x.jar` to `apktool.jar`(It'll be invoke by script: `apktool`):  
   `mv apktool_2.0.0rc4.jar apktool.jar`

  * Download apktool script(Linux)  
    `wget https://raw.githubusercontent.com/iBotPeaches/Apktool/master/scripts/linux/apktool`

* Install open jdk 7 or later(java-7-openjdk):

  * Ubuntu:  
    `sudo apt-get install openjdk-7-jre`

  * Redhat / Centos:
    `su yum install java-1.7.0-openjdk`

* If you don't re-configure java path to open jdk 7,  
you need to make a bash file(Ex: `export_java7.sh`) to export Java 7 Bin  / Home Path:

        ## Ex: export_java7.sh  
        export PATH=/usr/lib/jvm/java-7-openjdk-amd64/bin:$PATH
        export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
* Run:  

        cd apktool
        chmod a+x ./export_java7.sh
        source ./export_java7.sh
        ./apktool d xx.apk

* Reference:  
  * [installing-openjdk-7-jdk-does-not-update-java-which-is-still-version-1-6](<http://unix.stackexchange.com/questions/35185/installing-openjdk-7-jdk-does-not-update-java-which-is-still-version-1-6>)
  * [apktool](https://code.google.com/p/android-apktool/wiki/Install)