# Failed to Run BAT on Win10 Due to Windows Defender SmartScreen

## Problem
* Failed to Run BAT on Win10 Due to Windows Defender SmartScreen

## How to Reproduce
* The BAT file is used to resize all images in a folder:

       for /r %%i in (*.jpg *.jpeg *.png) do (
           magick mogrify -density 72 -resize 413x551! %%i
       )
* Send an Email with the BAT attached and download it to PC
* Got the following message when run a BAT file on Win10:

   >Windows Defender SmartScreen prevented an unrecognized app

## Solutions
Turn off "Windows Defender SmartScreen"
* Goto "Settings" -> "Windows Defender Security Center"
* In the left menu, select "App and browser control"
* Under "Check apps and files", select "Off"

## References
* [Windows Defender SmartScreen prevented an unrecognized app error](https://www.itsupportguides.com/knowledge-base/windows-10/windows-defender-smartscreen-prevented-an-unrecognized-app-error/)
