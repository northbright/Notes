# Bold Text is Hidden in Vim when Edit Markdown on macOS

## Problem
* macOS
* Configure Terminal Profile(Basic)
  * Set Terminal Background Color to Black
  * Set Text Color to White
* Install [vim-prettier](https://github.com/prettier/vim-prettier) to Get JS / Markdown Support
* Bold Text in Markdown(`**SOME_TEXT**`) is Hidden when Edit Markdown in Vim

## Root Cause
Bold text color is the same as background color(both of them are black)

## Solution
* Open Terminal
* Go to Preferences > Profile > Select Profile > Text > Set Bold Text Color to a Different Color(e.g. white)

## References
* [Bold Texts Disapper in Terminal](https://github.com/northbright/Notes/blob/master/macos/terminal/bold-texts-disapper-in-terminal.md#bold-texts-disapper-in-terminal)
* [Configure macOS Terminal Font for Developer](https://github.com/northbright/Notes/blob/master/macos/terminal/configure-macos-terminal-font-for-developer.md)
