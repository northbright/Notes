# Force [pkg.go.dev](https://pkg.go.dev/) to Refresh Doc of Your Golang Package

## Problem
* After updated my Golang project repo hosted on Github, need [pkg.go.dev](https://pkg.go.dev/) to refresh the doc

## Solution
* Make sure and tag for the latest commit and use `--tags` when push commits to Github

  ```
  git tag -a "v1.0.1" -m "version 1.0.1"
  git push origin HEAD:master --tags
  ```
* Add `@VERSION` suffix to the URL when visit [pkg.go.dev](https://pkg.go.dev/)

  ```
  https://pkg.go.dev/github.com/YOUR_ACCOUNT/YOUR_PROJECT@v1.0.1
  ```

* It'll show a button - `Request github.com/YOUR_ACCOUNT/YOUR_PROJECT@v1.0.1`
* Click the button to force [pkg.go.dev](https://pkg.go.dev/) to refresh the doc of your Golang package
