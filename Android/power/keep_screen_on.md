
# Keep Screen On

#### Method 1 - Use `WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON`

    public void keepScreenOn(boolean on) {
        KeyguardManager manager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        int flags = WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        if (on) {
            getWindow().addFlags(flags);
        } else {
            getWindow().clearFlags(flags);
        }
    }

This is recommended but it has one limitation: it does not work if users leave this app(goes background).

#### Method 2 - Use `PowerManager.SCREEN_BRIGHT_WAKE_LOCK`

    static WakeLock wl;

    public void keepScreenOn2(boolean on) {
        if (on) {
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            wl = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, "==KeepScreenOn==");
            wl.acquire();
        }else {
            wl.release();
            wl = null;
        }
    }

`PowerManager.SCREEN_BRIGHT_WAKE_LOCK` is deprecated and not recommended.

#### Sample App

* <https://github.com/northbright/keepscreenon>