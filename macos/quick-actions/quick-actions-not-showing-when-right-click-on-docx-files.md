# Quick Actions Not Showing when Right Click on .docx Files

## Problem
* Try to use Quick Actions to create a PDF from multiple .docx files
* Select mutiple .docx files and right click > select Quick Actions
* It just shows "Customize..."
* Click "Customize..." and "Create PDF" is selected to show in Finder
* Right click and select Quick Actions agian, it still shows "Customize..."

## Root Cause
* Create PDF Quick Action is for image files.
* Document files are not supported.

## References
* [Quick Actions not showing in Finder Window](https://discussions.apple.com/thread/251399773?sortBy=rank) 
