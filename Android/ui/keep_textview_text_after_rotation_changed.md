
# Keep TextView Text after Rotation Changed

Add `android:freezesText="true"` in `<TextView />`:  

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentLeft="true"
        android:layout_below="@id/button_start"
        android:scrollbars="vertical"
        android:id="@+id/output_text_view"
        android:freezesText="true" />

#### References
* <http://stackoverflow.com/questions/5179686/restoring-state-of-textview-after-screen-rotation>