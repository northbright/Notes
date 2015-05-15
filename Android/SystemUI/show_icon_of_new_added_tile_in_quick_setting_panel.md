
# Show Icon of New Added Tile in Quick Setting Panel

#### Android Version
Tag: android-5.1.1_r1

#### How to Show Tile Icon
We can follow `frameworks/base/packages/SystemUI/src/com/android/systemui/qs/tiles/BluetoothTile.java`:  
Set `state.icon` to the value returned by `ResourceIcon.get()`:

    public class BluetoothTile extends QSTile<QSTile.BooleanState>  {

        protected void handleUpdateState(BooleanState state, Object arg) {
            ......
            // -----------------------------------------------------------
            // Set state.icon to the value returned by ResourceIcon.get()
            // -----------------------------------------------------------
            state.icon = ResourceIcon.get(R.drawable.ic_qs_bluetooth_off);
            ......
        }
    }