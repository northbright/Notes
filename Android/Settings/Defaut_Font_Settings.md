
# Default Font Setting

`framework/base/core/java/android/content/res/Configuration.java`

    public void setToDefaults() {
        fontScale = 1.15f; // Set font size to large
                           // Small - 0.85
                           // Normal - 1
                           // Large - 1.15
                           // Huge - 1.30


After user changed the default font size，the new font will be stored in
`/data/data/com.android.providers.settings/databases/settings.db`
(table = system and key = font_scale).