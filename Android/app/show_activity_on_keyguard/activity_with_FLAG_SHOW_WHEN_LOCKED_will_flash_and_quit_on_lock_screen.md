
# Activity with `FLAG_SHOW_WHEN_LOCKED` will Flash and Quit on Lock Screen

#### Root Cause

When `FLAG_SHOW_WHEN_LOCKED` is set to show activity on lock screen for secure lock(Ex: PIN), the activity life cycle looks like:  

onCreate -> onStart -> onPause -> onStop -> onRestart -> onStart -> onResume  

* You can see `onPause()` and `onStop()` will be called immediately after activity is created.  
* If you put `finish()` in `onStop()`, your activity will flash and quit.

#### Solution

* Do NOT call `finish()` in `onStop()`  
* If you start a task in `onCreate()`, do NOT stop it in `onStop()`, stop it in `onDestroy()`

#### References

* <http://stackoverflow.com/questions/25369909/onpause-and-onstop-called-immediately-after-starting-activity>

