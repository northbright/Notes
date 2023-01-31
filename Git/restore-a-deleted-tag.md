# Restore a Deleted Tag

## Problem
* Deleted a tag by running `git tag -d`(e.g. `git tag -d v0.0.1`)
* Need to restore the tag

## Solution
* List unreachable tags with KEYS

  ```
  git fsck --unreachable | grep tag
  ```

  The output looks like:

  ```
  unreachable tag b7fe18117b594a9de93f05bac560641b23d53839
  unreachable tag 5c4d1b09a60aa72b23a8c96e2df092d07159d07b
  ```

* Use `git show KEY` to find out the tag NAME you want to restore

  e.g.
  ```
  git show b7fe18117b594a9de93f05bac560641b23d53839
  ```

  Output:
  ```
  tag v0.0.1
  ......
  ```

  So b7fe18117b594a9de93f05bac560641b23d53839 is the key of v0.0.1


* Restore the tag

  ```
  git update-ref refs/tags/NAME KEY
  ```

  e.g.
  ```
  git update-ref refs/tags/v0.0.1 b7fe18117b594a9de93f05bac560641b23d53839
  ```

## References
* [Git Tip : Restore a deleted tag](https://baptiste-wicht.com/posts/2011/06/git-tip-restore-a-deleted-tag.html)

