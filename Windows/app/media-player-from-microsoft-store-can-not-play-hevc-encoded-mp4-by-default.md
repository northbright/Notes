# Media Player from Microsoft Store Can Not Play HEVC Encoded MP4 by Default

## Problem
* Windows 11 Home
* Double clicks on an HEVC encoded MP4 and it'll open Media Player(installed automatically from Microsoft Store)
* Prompt a window to ask users to pay 7 Chinese Yuan($1) to get HEVC decoder

## Solution
Install MPC-BE.

* Go to Microsoft Store and type "MPC-BE" and install it.
* Right click the MP4 file > Open with > Choose another app  > Check "Always use this app to open .MP4 files" > Select MPC-BE > OK


