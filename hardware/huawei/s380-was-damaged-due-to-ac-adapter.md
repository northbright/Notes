# S380 was Damaged due to Damaged DC Adapter

## Problem
* Can not manage S380 L4T1T via web(`https://192.168.112.1`)
* LAN led indicators are off even ethernet cables are connected

## Root Cause
* It used a damaged DC adapter
  * The adaper(12V 2A) plugged into S380 was used for Telecom gateway(Huawei HN8145XR)
  * S380 L4T1T use a 12V 1A DC adaper which was plugged into Huawei HN8145XR
  * Plugged adapter(12V 2A) to Huawei HN8145XR and can not power on the device
* S380 was damaged by the damaged DC adapter

## Solution
* Call Huawei service(`400 822 9999`)
