
# Can not Find Method in External Jar when Integrate Jar in AOSP

#### Description
Some times, we need to integrate external jar in our project and build it in AOSP envorionment.  

After build, flash the system image and reboot, the app crashes and the seems it can't find the method of the class in the jar.  
The log looks like:  

    F/art     ( 5562): art/runtime/thread.cc:1116] Throwing new exception 'no non-static method
    "Lcom/xx/xx/a/a/b;.stusCb([CIII[B)V"' with unexpected pending exception:
    java.lang.NoSuchMethodError: no non-static method "Lcom/xx/xx/a/a/b;.rsltCb([C[BII)V"

#### How to Fix:  
* Need to config proguard(`proguard.flags`) to keep all classes in the external jar

  * `proguard.flags`:  

            -keep class com.xx.**{*;}

            -verbose

  * `Android.mk`:  

            LOCAL_PROGUARD_FLAG_FILES := proguard.flags