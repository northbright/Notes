# Include a Specific Sub Folder but Ignoring the Rest of the Folder

## Problem
* Need to Ignore All Sub Folders in `/dist/spa` but Include `/dist/spa/img` Folder

## Solution
Update `.gitignore`:

```
/dist/spa/*
!/dist/spa/img
```

## References
* [Git .gitignore: Excluding a folder but including a subfolder](https://www.slingacademy.com/article/git-gitignore-excluding-folder-including-subfolder/)
