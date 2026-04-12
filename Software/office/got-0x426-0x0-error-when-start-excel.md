# Got "0x426-0x0" Error when Start Execel

## Problem
* Got "0x426-0x0" Error when Start Execel

## Root Cause
* Run [Autoruns](https://learn.microsoft.com/en-us/sysinternals/downloads/autoruns) of [Sysinternals](https://learn.microsoft.com/en-us/sysinternals/)
* Remove "Microsoft Office Click-to-Run Service" in "Services"
* It fails to start office without "Microsoft Office Click-to-Run Service" running

## Solution
Enable "Microsoft Office Click-to-Run Service" and start it.

* Method A: Use Autoruns
  Select "Microsoft Office Click-to-Run Service" in "Services" and reboot PC

* Method B: Use "services.msc"

  * Run "services.msc" > Services
  * Set "Microsoft Office Click-to-Run Service" to Auto and start it
