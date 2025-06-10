# Can Not Cancel Call Forwarding due to Raisecom Gateway Runs into Problem

## Problem
* Raisecom gateway line port 6 - 8 are used for 3 outline numbers
* Connect line cable from port 6 to a phone
* Set call forwarding by pressing `*57*PHONE_NUMBER`
* Failed to cancel call forwarding by presing `#57#`
* Can not dial from line port 8

## Root Cause
Raisecom gateway ran into problem

## Solution
Reboot Raisecom gateway.

1. Power off the device by switching the power button to "O".
2. Power on the device by switching the power button to "I".

## References
* [Raisecom Gateway was Damaged after Power Outage](https://github.com/northbright/Notes/blob/master/hardware/telecom/raisecom-gateway-was-damaged-after-power-outage.md)
