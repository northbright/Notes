# The Speed of Port Connected to a PC is Only 10M

## Problem
* A PC is connected to a port(access) on the H3C S5120 access switch
* Use console cable to login the switch
* Run `display interface brief` and shows the port speed is only 10M

## Root Cause
* The PC is in sleep mode and the ethernet card also works in sleep mode
* It'll be 1000M when the PC awakes
