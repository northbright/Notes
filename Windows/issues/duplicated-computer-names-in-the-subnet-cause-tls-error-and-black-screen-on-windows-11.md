# Duplicated Computer Names in the Subnet Cause TLS Error and Black Screen on Windows 11

## Problem
* A PC named "yang" shares its printer in the subnet
* Other PCs connect to the shared printer provided by "yang" PC
* Clean install Windows 11 on a new PC
* The new PC is also named "yang"
* The new PC crashes and get black screen suddenly

## Root Cause
* Go to Windows Events Viewer
* Found TLS Error
* Duplicated Computer Names May Cause the Problem

## Solution
* Rename New PC
