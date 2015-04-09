
# `FLAG_SHOW_WHEN_LOCKED` makes `FLAG_DISMISS_KEYGUARD` ineffective on Android_5.0L

* For Secure Lock(Ex: PIN, Password, Pattern)

    `FLAG_SHOW_WHEN_LOCKED` works well.

* For Insecure Lock(Ex: Swipe)

    `FLAG_SHOW_WHEN_LOCKED` | `FLAG_DISMISS_KEYGUARD` will make `FLAG_DISMISS_KEYGUARD` ineffective.  
    So we need remove `FLAG_SHOW_WHEN_LOCKED` for insecure lock: 

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            KeyguardManager km = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);

            int flags = WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;

            if (!km.isKeyguardSecure()) {  // for insecure lock(Ex: Swipe)
                flags |= WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD;
            } else {  // for secure lock(Ex: PIN, Password, Pattern)
                flags |= WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
            }

            getWindow().addFlags(flags);
        }

#### References:

* [Document](http://developer.android.com/reference/android/view/WindowManager.LayoutParams.html):

        int	FLAG_SHOW_WHEN_LOCKED
            Window flag: special flag to let windows be shown when the screen is locked.

        int	FLAG_DISMISS_KEYGUARD
            Window flag: when set the window will cause the keyguard to be dismissed, only if it is not a secure lock keyguard.

* <https://code.google.com/p/android-developer-preview/issues/detail?id=1902>