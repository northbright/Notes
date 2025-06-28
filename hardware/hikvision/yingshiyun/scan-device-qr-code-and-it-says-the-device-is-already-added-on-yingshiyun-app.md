# Scan Device's QR Code and It Says the Device is Already Added on Yingshiyun App

## Problem
* Logon web portal of Hikvision NVR
* Go to System Preferences > Network Preferences > Yingshiyun
* Open Yingshiyun App and scan the QR code > Next
* It prompts a message that streams are encoded and need to input password
* Want to disable stream encryption on NVR and tap "Cancel" on Yingshiyun App
* Go to NVR's yingshiyun settings > more settings > Turn Off Stream Encrption > Save
* Refresh the QR code > Use Yingshiyun App scan again
* It says the device is already added

## Root Cause
* When click cancel to input password, the NVR is already added to default "Group" of default "Home" on Yingshiyun App

## Solution
* Go to Default(recent) Home > Default Group to find the devices
* Select the NVR device(the last one) and cameras > move them to the group you want
