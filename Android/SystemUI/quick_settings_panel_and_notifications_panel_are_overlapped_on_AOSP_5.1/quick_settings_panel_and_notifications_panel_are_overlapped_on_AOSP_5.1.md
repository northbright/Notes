
# Quick Settings Panel and Notifications Panel are Overlapped on AOSP 5.1

#### Screenshots:
![](./quick_settings_panel_and_notifications_panel_are_overlapped_on_AOSP_5.1.png)

#### Root Cause:  
`frameworks/base/packages/SystemUI/src/com/android/systemui/statusbar/phone/NotificationPanelView.java:`

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ......
        // It won't work if users click "wifi ap list" arrow and expand the qs panel with detail
        requestPanelHeightUpdate();
    }

#### How to Fix:
It's already fixe in latest AOSP 5.1 master branch(2015/04/30), we can follow this solution:

`frameworks/base/packages/SystemUI/src/com/android/systemui/statusbar/phone/NotificationPanelView.java:`

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ......
        //requestPanelHeightUpdate();  // comment this line

        // If we are running a size change animation, the animation takes care of the height of
        // the container. However, if we are not animating, we always need to make the QS container
        // the desired height so when closing the QS detail, it stays smaller after the size change
        // animation is finished but the detail view is still being animated away (this animation
        // takes longer than the size change animation).
        if (mQsSizeChangeAnimator == null) {
            mQsContainer.setHeightOverride(mQsContainer.getDesiredHeight());
        }
    }