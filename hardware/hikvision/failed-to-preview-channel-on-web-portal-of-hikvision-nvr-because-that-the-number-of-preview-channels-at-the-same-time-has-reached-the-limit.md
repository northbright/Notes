# Failed to Preview Channel on Web Portal of Hikvision NVR Because that the Number of Preview Channels at the Same Time Has Reached the Limit

## Problem
* Hikvision NVR(64 channels)
* Open a browser window and preview some channels via web portal
* Set grid layout to 16
* Click the grid of preview windows and select a channel to preview
* It's OK to preview channels on all 16 grids(channels)
* Open another browser window to preview more channels
* It's OK to preview 4 more channels
* Failed to preview 5th channel

## Root Cause
* The number of preview channels at the same time has reached the limit(e.g. 20 in this case)

## Workaround
* Re-select the channel for a grid to preview a new channel
