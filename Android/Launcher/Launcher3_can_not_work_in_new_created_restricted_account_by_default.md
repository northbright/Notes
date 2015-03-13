
# Launcher3 Can Not Work in New Created Restricted Account by Default

#### Description

If Launcher3 is prebuilt and set as preferred launcher,  
after swtiched to the new created restricted account, Launcher3 can not be displayed(black screen).

You must enable `* HPROF` and `Show Mem` in "Settings" -> "Users" -> New Create Restricted User.  
`* HPROF` and `Show Mem` are string labels of 2 activities of Launcher3.

#### How to Fix

Modify `Launcher3/AndroidManifest.xml`:  
To make Launcher3 work in new created restricted account by default,  
We need to remove all activities with `android.intent.category.LAUNCHER`:

1. Remove `com.android.launcher3.ToggleWeightWatcher` activity which is used to debug memory
2. Remove `com.android.launcher3.MemoryDumpActivity` activity which is used to debug memory

#### References
* <http://stackoverflow.com/questions/21941894/android-restricted-profile-with-different-launcher>