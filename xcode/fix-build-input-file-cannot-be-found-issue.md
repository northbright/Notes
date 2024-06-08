Fix "build input file cannot be found" Issue

## Problem
* XCode 15
* Clone the [go-swift](https://github.com/youngdynasty/go-swift) Repo
* Got Error while Build the Project:

  > Build input file cannot be found: '/Users/xx/projects-xcode/go-swift/go-swift/go_swift.entitlements'. Did you forget to declare this file as an output of a script phase or custom build rule which produces it?

## Root Cause
An entitlements file is one of a small group of project files that are not identified to the compiler/build utilities via the normal project file list (what you see in the navigator panel on the left). Instead, they're identified in **Build Settings**, with an absolute or relative path.

## Solution
* Go to Project > Build Settings > Search "entitlements"
* Enter a Correct Path of .entitlements for Debug and Release or Remove It
* Build Again

## References
* [Build input file cannot be found: Did you forget to declare this file as an output of a script phase or custom build rule which produces it?](https://forums.developer.apple.com/forums/thread/728087)
