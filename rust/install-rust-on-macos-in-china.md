# Install Rust on macOS in China

## Problem
* Need to install [Rust](https://www.rust-lang.org/) on macOS in China
* Official instruction: `curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh` does not work
* Blocks at "info: downloading installer"

## Root Cause
* Network access to Rust resources may be blocked in China

## Solution
Set mirrors of Rust resources.

* Modify `.zshrc`

  ```shell
  vi ~/.zshrc
  ```

* Add mirrors for Rust

  ```shell
  # Rust
  export RUSTUP_UPDATE_ROOT=https://mirrors.ustc.edu.cn/rust-static/rustup
  export export RUSTUP_DIST_SERVER=https://mirrors.ustc.edu.cn/rust-static  
  ```

  ```shell
  source ~/.zshrc
  ```

* Run install script

  ```shell
  curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh
  ```

  Choose option 1 to install Rust(default)

  ```shell
  // Output:
  .....
  stable-x86_64-apple-darwin installed - rustc 1.85.0 (4d91de4e4 2025-02-17)
  Rust is installed now. Great! 
  ```

* Check Rust version

  Open another shell window

  ```shell
  rustc --version
  
  // Output:
  rustc 1.85.0 (4d91de4e4 2025-02-17)
  ```
    
## References
* [Install Rust](https://www.rust-lang.org/tools/install)
* [How to Install Rust in MacOS?](https://www.geeksforgeeks.org/how-to-install-rust-in-macos/)
* [国内Mac安装Rust](https://zhuanlan.zhihu.com/p/13143172984)
