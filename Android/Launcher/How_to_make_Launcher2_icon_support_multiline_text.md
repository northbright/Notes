
# How to make Launcher2 icon support multiline text

* Modify `packages/apps/Launcher2/res/values/styles.xml` or overlay `styles.xml`:  
  set "android:singleLine" to false and "android:maxLines" in `<style name="xx">`:  

        <style name="XX">
            ......
            <item name="android:singleLine">false</item>
            <item name="android:maxLines">2</item>
            ......
        </style>

* "XX" can be one or more of these values:
    * `"WorkspaceIcon.Portrait.AppsCustomize"`  -> "All Apps" screen in portrait mode
    * `"WorkspaceIcon.Landscape.AppsCustomize"`  -> "All Apps" screen in landscape mode
    * `"WorkspaceIcon.Portrait"`  -> portrait mode
    * `"WorkspaceIcon.Landscape"` -> landscape mode
    * `"WorkspaceIcon.Portrait.Folder"` -> folder icons in portrait mode
    * `"WorkspaceIcon.Landscape.Folder"` -> folder icons in landscape mode



