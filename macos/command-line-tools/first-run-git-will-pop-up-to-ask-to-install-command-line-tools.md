# First Run Git Will Pop up to Ask Install Command Line Tools

## Mac OS X Version
* 10.15.4(Catalina)

## Problem
* Want to run `git` command in terminal
* Pop up a window to install "Command Line Tools"

## Root Cause
* Mac OS X includes git which locates in `/usr/bin/git`
* `/usr/bin/git` is a STUB script which will invoke `xcode-select --install` to install "Command Line Tools"
* "Command Line Tools" includes SDKs and developer tools(git, python...)

## Solution
* Accept the agreement and download, install "Command Line Tools"
* After installed successfully, the developer tools will be installed to

  ```
  /Library/Developer/CommandLineTools/usr/bin/
  ```
* Check if `git` is installed

  ```
  git --version

  // Output:
  git version 2.24.1 (Apple Git-126)
  ```

## Which `git` is used 
```
which git

// Output:
/usr/bin/git
```
* You may find there're 2 `git`
  * `/usr/bin/git`
  * `/Library/Developer/CommandLineTools/usr/bin/git`

* Use `otool` to get linked libraries

  ```
  otool -L /usr/bin/git

  // Output:
  /usr/lib/libxcselect.dylib
  /usr/lib/libSystem.B.dylib
  ```

  ```
  otool -L /Library/Developer/CommandLineTools/usr/bin/git

  // Output:
  /usr/lib/libpcre.0.dylib
  /usr/lib/libz.1.dylib
  /usr/lib/libiconv.2.dylib
  /usr/lib/libSystem.B.dylib
  ```

* Conclusion
  * `/Library/Developer/CommandLineTools/usr/bin/git` is the real binary of installed git binary
  * `/usr/bin/git` will call `/Library/Developer/CommandLineTools/usr/bin/git` if it's installed or will ask user to download Command Line Tools

## References
* [Is /usr/bin/python3 provided with macOS Catalina?](https://apple.stackexchange.com/questions/376077/is-usr-bin-python3-provided-with-macos-catalina)
* [Install Command Line Tools (no Xcode) in Mac OS X](https://developpaper.com/install-command-line-tools-no-xcode-in-mac-os-x/)

