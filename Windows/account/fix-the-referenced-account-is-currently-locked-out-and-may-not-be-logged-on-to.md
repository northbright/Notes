# Fix "the referenced account is currently locked out and may not be logged on to"

## Problem
* Restart PC via pressing power button
* Input correct passsword on Window login screen
* Got ""the referenced account is currently locked out and may not be logged on to" message

## Root Cause
* User input incorrect password for several times

## Solution A
Reboot PC and wait 10 - 30 minutes and input correct password.

## Solution B
Reset password.
* Click "Reset password" button(press enter if you don't see the "Reset password" button).
* Provide answers to the security questions and create a new password.

## Set "invalid logon attempts" to `0`(Optional) 
* Type `gpedit.msc` in search box
* Go to Local Computer Policy > Computer Configuration
* Windows Settings > Security Settings > Account Policies > Account Lockout Policy
* Double click "Account lockout threshold"
* Set "invalid logon attempts" to `0`

## References
* [How to Fix “The Referenced Account Is Currently Locked Out” Error in Windows](https://helpdeskgeek.com/windows-11/how-to-fix-the-referenced-account-is-currently-locked-out-error-in-windows/)
* [The referenced account is currently locked out and may not be logged into](https://www.thewindowsclub.com/the-referenced-account-is-currently-locked-out)
