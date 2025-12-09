# Git is Broken after Upgrade macOS to 15

## Problem
* Upgrade macOS from 14 to 15
* Run `git` command and got error

  ```sh
  Library not loaded: /System/Library/PrivateFrameworks/CoreChart.framework/Versions/A/CoreChart
  Referenced from: <1BA720BC-33B3-393E-A824-7F1A42394116> /Applications/Xcode.app/Contents/Frameworks/IDEKit.framework/Versions/A/IDEKit

  git: error: sh -c '/Applications/Xcode.app/Contents/Developer/usr/bin/xcodebuild -sdk /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk -find git 2> /dev/null' failed with exit code 17920: (null) (errno=Invalid argument)
  xcode-select: Failed to locate 'git', requesting installation of command line developer tools.
  ```

## Root Cause
* Git is broken after upgrade macOS to 15
* Developer tools path is set to using full Xcode but not Command Line Tools

## Solution
Set Developer tools path to use Command Line Tools without full Xcode. 

```sh
sudo xcode-select -switch /Library/Developer/CommandLineTools
```

## References
* <https://cn.bing.com/search?q=git+broken+macos+xcode&form=QBLHCN&sp=-1&lq=0&pq=git+broken+macos+xcode&sc=0-22&qs=n&sk=&cvid=50F74E447A2D498CAD4A4CB5557547CE>
