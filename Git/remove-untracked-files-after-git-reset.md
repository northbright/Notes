# Remove Untracked Files after git reset --hard

#### Problem
We can see untracked files after running `git reset --hard`.

#### Solution
* Use `git clean -df` to clean all untracked files.

#### References
* [git reset --hard HEAD leaves untracked files behind](http://stackoverflow.com/questions/4327708/git-reset-hard-head-leaves-untracked-files-behind)
