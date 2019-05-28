# Set Static IP will Make Windows 7 Recognize Network Location Type as "Public"

## Problem
* After set static IP on Windows, network is recognized as "Unidentified Network” and network location type is recognized as "Public"
* Shared folders can not be accessed from other PCs
* Remote Desktop can not work

## Root Cause
* Setting Static IP will make Windows recognize network as "Unidentified Network"
* Network loaction type of "Unidentified Network” is "Public" by default security policies
* "Public" network location type will make firewall use more strict policies by default: 
   * Shared resources can not be accessed by other PCs
   * Remote Desktop can not work

## Soluiton
* Run "secpol.msc"
* Goto "Security Settings" -> "Network List Manager Policies" -> "Unidenfified Networks"
* Set "Network Location Type" to "Private"
