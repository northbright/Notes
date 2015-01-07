
# Resolve git cherry-pick Conflict and Continue

Sometimes, after `git fetch ssh:/xx refs/changes/xx && cherry-pick FETCH_HEAD`,  
you'll meet conflict like: `error: could not apply xx`

###### How to Fix:
* Open the conflict file and find `>>>>` and `<<<<`
* Check if there's real conflict between these two flags. Fix it if needed.  
  Most of conflicts caused by:

    * Commit A insert some lines
    * Commit B insert some lines at the same position of file, too.
    * Just adjust the line position of commit A and B should fix the conflict.
* Remove the `>>>>` and `<<<<`
* run `git add` to add changes
* run `git cherry-pick continue` to commit and merge
