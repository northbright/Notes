
# Most right hotseats icons disappear(Android 4.4.4)

* Description  
The last 2 hotseats icons disappeared while default_workspace.xml and config.xml are configured properly.

* Root Cause  
In `LauncherModel.java`:

The column of occupied icon array = workspace column x cell + 1.  
If hotseats count > workspace cell x count + 1, the most right n icons will disappear. n = hotseats count(not include all apps) - workspace cell x count.  

Ex:  
hotseats = 10 + 1(all apps) = 11  
workspace cell x count = 8  
The last 2 icons of hotseats bar will disappear(10 - 8).

* How to fix:
  * Modify LauncherModel.java:
                
            final ItemInfo occupied[][][] =
                new ItemInfo[Launcher.SCREEN_COUNT + 1][mCellCountX + 1][mCellCountY + 1];

            // change mCellCountX + 1 to max(mCellCountX + 1, hotseats count).

  * or Make sure hotseats count(include all apps) <= workspace cell x count + 1.

* More info  
[Trebuchet: fix icons disappearing from the hotseat (dock).](https://gitorious.org/cyandreamproject/android_packages_apps_trebuchet/commit/d9bbfcbd622bf64d032a326fab43c47cb2f672cb)