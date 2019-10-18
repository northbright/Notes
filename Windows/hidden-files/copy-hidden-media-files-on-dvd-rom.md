# Copy Hidden Media Files on DVD-ROM

## Problem
* A DVD-ROM contains some media files
* There's no files can be found in the browser
* The media files can be only viewed in a customized browser(**without** copy menu) by running the `autorun.exe` under root


## Root Cause
* Folders and Media Files are **Hidden**

## Solution
Open a `CMD` window to copy it from DVD to local disk

* Need to find the path of the media file
  * Option A: Get folder / file name by checking customized browser by running `autorun.exe`
    * Check title bar to get the folder name
    * Concat drive letter, folder name and file name to get full path(e.g. `e:\videos\01.mp4`
  * Option B(recommended): Get the full path of file by using 3rd party player
    * Right click the media file > "Open with..."
    * Select a 3rd party player(e.g. [MPC HC](https://mpc-hc.org/))  to play the media
    * Goto [MPC HC](https://mpc-hc.org/) menu > "File" > "Properties" > "Media Info" > "Complete File Name" to get the full path of the media file(e.g. `e:\videos\02.mp4`)
  * Option C: Use [Sysinternals Suit](https://docs.microsoft.com/en-us/sysinternals/downloads/sysinternals-suite) to monitor file system to get the full path
    * [Process Monitor](https://docs.microsoft.com/en-us/sysinternals/downloads/procmon)

* Press "Windows" Key + "R" to open a `CMD` Window
* Run `copy` command
   
       // e: is drive letter of DVD-Rom, d: is the local partition letter you want to store files
       copy e:\videos\01.mp4 d:\01.mp4

