# Network Location of One SMB Share on a Server Overrides the Saved Credential of Desktop Shortcut of Another SMB Share on the Same Server

## Problem
* A Samba server(Ubuntu) has only 1 interface(IP: `10.0.3.3`)
* There 2 smb shares for 2 users
  * "share" for user: "my"
  * "ppt" for user: "ppt"
* Need to access these smb shares from Windows 11 PC
* Created a desktop shortcut of "share"(`\\10.0.3.3\share`) and saved the credential
* Created a network location of "ppt"(`\\10.0.3.3\ppt`) and saved the credential
* Click the desktop shortcut to access "share" and it prompts a window to input password and the user is changed to "ppt"

## Root Cause
* The later added network location credential overrides the previous one

## Solution
* Remove the desktop shortcut of "share"
* Create a network location of "share" too
* It can access each network location successfully
