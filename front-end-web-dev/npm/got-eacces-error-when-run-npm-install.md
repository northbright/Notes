# Got EACCES Error when Run `npm install`

## Problem
* Clone the repo: [Wails + Svelte Pokemon Example](https://github.com/refactor-gremlin/wails-svelte)
* Run the commands

  ```sh
  cd PATH/to/wails-svelte/frontend
  npm install
  ```
* Got error:

  ```sh
  npm error code EEXIST
  npm error syscall mkdir
  npm error path /Users/xx/.npm/_cacache/content-v2/sha512/a6/2d
  npm error errno -13
  npm error EACCES: permission denied, mkdir '/Users/xx/.npm/_cacache/content-v2/sha512/a6/2d'
  npm error File exists: /Users/xx/.npm/_cacache/content-v2/sha512/a6/2d
  npm error Remove the existing file and try again, or run npm
  npm error with --force to overwrite files recklessly.
  npm error A complete log of this run can be found in: /Users/xx/.npm/_logs/2025-12-30T04_14_27_624Z-debug-0.log
  ```

## Root Cause
* `/Users/xx/.npm/_cacache/content-v2/sha512`'s owner is `root`
* `mkdir` under `/Users/xx/.npm/_cacache/content-v2/sha512` failed due to permission issue when run `npm install`

## Solution
* Method A: change owner of `sha512` to current user

  ```sh
  sudo chown -R xx /Users/xx/.npm/_cacache/content-v2/sha512
  ```

* Method B: remove entire `_cacache` dir

  ```sh
  sudo rm -rf /Users/xx/.npm/_cacache/
  ```

Run `npm install` again and it works.

## References
* [Your cache folder contains root-owned files](https://support.deploybot.com/build-tools/your-cache-folder-contains-root-owned-files)
