# F5 Key of Thinkpad E14 Does NOT Refresh Pages in Browser

## Problem
* Thinkpad E14 laptop
* Pressing F5 will not refresh web pages but adjust monitor brightness instead

## Root Cause
* F1 - F12 keys are set to execute special function printed as and icon on each key in BIOS

## Solution
* Method A: Set F1 - F2 to execute F1 - F12 function in BIOS

  * Press F1 to enter BIOS settings
  * Select Keyboard / Mouse > F1 - F12 key as Primary Funciton > Enabled

* Method B: Use Lock / Unlock `FnLock`

  * Press `Fn` + `Esc(FnLock)`

