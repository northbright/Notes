# Remove Local and Remote Tags

## Problem
* Add a tag to local repo and push to remote repo

  ```
  git tag -a v1.0.0 -m "v1.0.0"
  git push origin master --tags
  ```

* Want to remove v1.0.0 for local / remote tag

## Solution
```
// Remove local tag
git tag -d v1.0.0

// Remove remote tag
git push --delete origin v1.0.0
```

## References
* [How to delete a remote tag?](https://stackoverflow.com/questions/5480258/how-to-delete-a-remote-tag)


