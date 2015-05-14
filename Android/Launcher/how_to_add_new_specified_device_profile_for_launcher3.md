
# How to Add New Specified Device Profile for Launcher3

#### Android Version
Tag: android-5.1.1_r1

#### 1. Add Device Profile in DynamicGrid() in DynamicGrid.java:

`packages/apps/Launcher3/src/com/android/launcher3/DynamicGrid.java`:

    public DynamicGrid(Context context, Resources resources,
                       int minWidthPx, int minHeightPx,
                       int widthPx, int heightPx,
                       int awPx, int ahPx) {
        ......
        deviceProfiles.add(new DeviceProfile("20-inch Tablet",
                1527, 2527,  7, 7,  100, 20,  7, 72, R.xml.default_workspace_4x4));
        // ---------------------------------------------------------------------------------------------------
        // Add our device in deviceProfiles after all default device profiles
        // We need to provide the exact min width and height in DP:
        // myDeviceMinWidthDP = dpiFromPx(minWidthPx) --> minWidthPx / (current dpi / default dpi(160))
        // myDeviceMinHeightDP = dpiFromPx(minHeightPx) --> minHeightPx / (current dpi / default dpi(160))
        // DeviceProfile() will find our profile as the closest profile by calling findClosestDeviceProfile()
        // We can get minWidthPx / minHeightPx in step 2 then calculate myDeviceMinWidthDP / myDeviceMinHeightDP
        // ---------------------------------------------------------------------------------------------------
        deviceProfiles.add(new DeviceProfile("MY_DEVICE_NAME",
                myDeviceMinWidthDP, myDeviceMinHeightDP,  5, 6,  80, 14.4f,  7, 48, R.xml.default_workspace_5x6));

        mMinWidth = dpiFromPx(minWidthPx, dm);
        mMinHeight = dpiFromPx(minHeightPx, dm);
        // ---------------------------------------------------------------------
        // DeviceProfile() will call return a closest profile in device profies
        // ---------------------------------------------------------------------
        mProfile = new DeviceProfile(context, deviceProfiles,
                mMinWidth, mMinHeight,
                widthPx, heightPx,
                awPx, ahPx,
                resources);
    }


#### 2. Get `minWidthPx` and `minHeightPx` passed to DynamicGrid()
`packages/apps/Launcher3/src/com/android/launcher3/LauncherAppState.java`:

    static DynamicGrid createDynamicGrid(Context context, DynamicGrid dynamicGrid) {
        // Determine the dynamic grid properties
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        Point realSize = new Point();
        display.getRealSize(realSize);
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);

        if (dynamicGrid == null) {
            Point smallestSize = new Point();
            Point largestSize = new Point();
            display.getCurrentSizeRange(smallestSize, largestSize);

            // ---------------------------------------------------------------
            // minWidthPx = Math.min(smallestSize.x, smallestSize.y)
            // minHeightPx = Math.min(largestSize.x, largestSize.y)
            // ---------------------------------------------------------------
            dynamicGrid = new DynamicGrid(context,
                    context.getResources(),
                    Math.min(smallestSize.x, smallestSize.y),  // minWidthPx comes from here, print this value
                    Math.min(largestSize.x, largestSize.y),  // minHeightPx comes from here, print this value
                    realSize.x, realSize.y,
                    dm.widthPixels, dm.heightPixels);
        }

        // Update the icon size
        DeviceProfile grid = dynamicGrid.getDeviceProfile();
        grid.updateFromConfiguration(context, context.getResources(),
                realSize.x, realSize.y,
                dm.widthPixels, dm.heightPixels);
        return dynamicGrid;
    }

#### 3. Finally Calculate the `myDeviceMinWidthDP` and `myDeviceMinHeightDP`

    myDeviceMinWidthDP = dpiFromPx(minWidthPx) --> minWidthPx / (current dpi / default dpi(160))
    myDeviceMinHeightDP = dpiFromPx(minHeightPx) --> minHeightPx / (current dpi / default dpi(160))

#### 4. Now we can pass the exact min width / height in DP into DeviceProfile() in Step 1:

    deviceProfiles.add(new DeviceProfile("MY_DEVICE_NAME",
                myDeviceMinWidthDP, myDeviceMinHeightDP, ....);