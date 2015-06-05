
# Add Shortcut(bookmark) for Launcher2 or 3

#### Preparation
* Icon - The icon of shortcut will be placed on Launcher home.
* Strings - The text of shortcut. If localization is need, you may need localized strings.

#### Overlay

`OVERLAY` is the overlay path for your device

* Put icon in `OVERLAY/packages/apps/Launcher3/res/drawable-xx`  
Ex: `OVERLAY/packages/apps/Launcher3/res/drawable-sw720dp-nodpi/myapp_icon.png`

* Put string in `OVERLAY/packages/apps/Launcher3/res/values/strings.xml`:

        <?xml version="1.0" encoding="utf-8"?>
        <resources xmlns:xliff="urn:oasis:names:tc:xliff:document:1.2">
            <!-- MyApp Text -->
            <add-resource type="string" name="myapp_text" />
            <string name="myapp_text">My App</string>
        </resources>

* Modify `OVERLAY/packages/apps/Launcher2/res/xml/default_workspace.xml`(Launcher2) or `OVERLAY/packages/apps/Launcher3/res/xml/default_workspace_XxX.xml`(Launcher3):

        <shortcut
            launcher:icon="@drawable/myapp_icon"
            launcher:screen="1"
            launcher:title="@string/myapp_text"
            launcher:uri="https://play.google.com/store/apps/details?id=com.mycompany.myapp"
            launcher:x="0"
            launcher:y="0" />

