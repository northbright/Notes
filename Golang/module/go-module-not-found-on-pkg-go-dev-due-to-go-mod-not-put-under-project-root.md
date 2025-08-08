# Go Module Not Found on pkg.go.dev due to "go.mod" not Put under Project Root

## Problem
* Create a repo for Go project on Github
* Git clone the repo

  ```sh
  my-project
  ```
* Create a sub dir for Go package

  ```sh
  my-project/my-package
  ```

* Run `go init github.com/xx/my-project/my-package` under `my-project/my-package`

  ```sh
  cd my-project/my-package
  go init github.com/xx/my-project/my-package
  ```

* Commit, add tag and push to Github

  ```sh
  git tag -a v0.0.1 -m v0.0.1
  git push origin HEAD:master --tags
  ```

* Visit `https://pkg.go.dev/github.com/xx/my-project@v0.0.1` and got "module not found" error

## Root Cause
* Run `go mod init`(put go.mod) under sub dir of project but NOT ROOT dir.

## Solution
* Remove `go.mod`, `go.sum` under sub dir.
* Run `go init` command under project ROOT.
* Commit, add tag and push to github.

## References
* [Adding a package](https://pkg.go.dev/about#adding-a-package)
* [The go.mod file](https://pkg.go.dev/cmd/go#hdr-The_go_mod_file)
