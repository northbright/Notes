# Got Build Errors for Target Mac OS 10.15 on XCode 12

## Problem
* Create a empty MacOS App project using XCode 12
* Got errors:

  > @main, 'Scene' and WindowGroup is only available in macOS 11.0 or newer

## Root Cause
* Life Cycle: `SwiftUI App` is not supported on Mac OS 10.15(require macOS 11.0 or newer)

## Solution
* Change the Life Cycle to `AppKit App Delegate` 

## References
* [Using Xcode 12 build errors for target macOS 10.15](https://stackoverflow.com/questions/65362789/using-xcode-12-build-errors-for-target-macos-10-15)
