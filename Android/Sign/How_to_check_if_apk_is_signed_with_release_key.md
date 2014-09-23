
# How to check if apk is signed with release key

`jarsigner -verify -verbose -certs my_application.apk`
  
If there's `CN=Android Debug` means it's signed with Android debug key.
