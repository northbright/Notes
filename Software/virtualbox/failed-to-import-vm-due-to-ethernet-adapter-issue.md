# Failed to Import VM due to Ethernet Adapter Issue

## Problem
* VirtualBox was installed on iMac and MacBook Pro
* Exported one VM on iMac as an `.OVA` file
* Copy the `.OVA` file to MacBook
* Imported the `.OVA` and started it
* Got the "Etherenet Adapter Error"

## Root Cause
* Different ethernet adapters between iMac and MacBook

## Solution
* Go to network settings and configure the ethernet adapter using the one on MacBook
