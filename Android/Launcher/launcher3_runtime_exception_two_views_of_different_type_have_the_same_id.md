
# Launcher3 Runtime Exception - Two Views of Different Type Have the Same id

#### How to Reproduce

* Android AOSP 5.1.1 + GMS 5.1.1
* AOSP's `QuickSearchBox` is overridden by GMS's `Velvet`(include Google Search Bar widget)
* Launcher3(not Google Now Launcher)
* Long press on home screen -> select "Widgets" -> put a new "Google Search Bar" widget on home screen
* Rotate the device(landscape <-> portrait)
* Launcher3 Crashed

#### Logcat

    W/System.err( 1611): java.lang.IllegalArgumentException: 
    Wrong state class, expecting View State but received class 
    android.appwidget.AppWidgetHostView$ParcelableSparseArray instead. 
    This usually happens when two views of different type have the same id in the same hierarchy. 
    This view's id is id/0x3. Make sure other views do not use the same id.

    W/System.err( 1611): 	at android.view.View.onRestoreInstanceState(View.java:13772)
    W/System.err( 1611): 	at android.widget.TextView.onRestoreInstanceState(TextView.java:3784)
    W/System.err( 1611): 	at android.view.View.dispatchRestoreInstanceState(View.java:13748)
    W/System.err( 1611): 	at android.view.ViewGroup.dispatchRestoreInstanceState(ViewGroup.java:2894)
    W/System.err( 1611): 	at android.view.ViewGroup.dispatchRestoreInstanceState(ViewGroup.java:2894)
    W/System.err( 1611): 	at android.view.ViewGroup.dispatchRestoreInstanceState(ViewGroup.java:2894)
    W/System.err( 1611): 	at android.view.ViewGroup.dispatchRestoreInstanceState(ViewGroup.java:2894)
    W/System.err( 1611): 	at android.view.ViewGroup.dispatchRestoreInstanceState(ViewGroup.java:2894)
    W/System.err( 1611): 	at android.view.ViewGroup.dispatchRestoreInstanceState(ViewGroup.java:2894)
    W/System.err( 1611): 	at android.view.View.restoreHierarchyState(View.java:13726)
    W/System.err( 1611): 	at com.android.internal.policy.impl.PhoneWindow.restoreHierarchyState(PhoneWindow.java:2009)
    W/System.err( 1611): 	at android.app.Activity.onRestoreInstanceState(Activity.java:1074)
    W/System.err( 1611): 	at com.android.launcher3.Launcher.onRestoreInstanceState(Launcher.java:2013)

#### How to Fix

`packages/apps/Launcher3/src/com/android/launcher3/Launcher.java:`

    public void onRestoreInstanceState(Bundle state) {
        // Wrap the code block will throw runtinme exception in try / catch block
        // ----------------------------------------------------------------------
        //super.onRestoreInstanceState(state);
        //for (int page: mSynchronouslyBoundPages) {
        //    mWorkspace.restoreInstanceStateForChild(page);
        //}

        try {
            super.onRestoreInstanceState(state);
            for (int page: mSynchronouslyBoundPages) {
                mWorkspace.restoreInstanceStateForChild(page);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception in onRestoreInstanceState():");
            e.printStackTrace();
        }
    }

#### References

* <http://blog.csdn.net/xiaoxiaobian3310903/article/details/7291476>
* <http://www.eoeandroid.com/blog-110365-21177.html>