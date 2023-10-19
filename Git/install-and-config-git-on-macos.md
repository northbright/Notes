# Install and Configure Git on macOS

## Install Git
* Install "Command Line Tools" which Contains Git

  ```
  xcode-select --install
  ```

## Configure Git
```
git config --global user.email "xx@xx.com"
git config --global user.name "My Name"
git config --global color.ui true

// Check
git config --global -l
```

## Generate SSH Key and Add it to [Github](https://github.com/)(Optional)
To clone / pull / push repos on [Github](https://github.com/) via `SSH` protocol, we need to generate SSH key and add it to Github Account Settings.
* Generate SSH Key
  ```
  ssh-keygen -t rsa -b 2048
  ```

  Copy the public key in `~/.ssh/id_rsa.pub` and go to github SSH settings to add new SSH key.

## References
* [First Run Git Will Pop up to Ask Install Command Line Tools](https://github.com/northbright/Notes/blob/master/macos/command-line-tools/first-run-git-will-pop-up-to-ask-to-install-command-line-tools.md)
