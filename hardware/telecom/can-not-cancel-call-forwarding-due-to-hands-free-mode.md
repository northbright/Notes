# Can Not Cancel Call Forwarding due to Hands Free Mode

## Problem
* Raisecom gateway line port 6 - 8 are used for 3 outline numbers
* Connect line cable from port 6 to a phone
* Set call forwarding by pressing `*57*PHONE_NUMBER`
* Failed to cancel call forwarding by presing `#57#`
* Can not dial from line port 8

## Root Cause
Use Hands-Free mode to dial the number may fail to set / cancel call forwarding in some cases.

## Solution
Pick up the receiver to dial the number to set / cancel call. 
