# `git clone` Specific Branch Without Fetching Other Branches

## Updated Solution B
Since Git 1.7.1, there's a new `--single-branch` option

    git clone --branch <branch> --single-branch <URL>

## Solution A
    mkdir mybranch
    cd mybranch
    git init
    git remote add -t $BRANCH -f origin $REMOTE_REPO
    git checkout $BRANCH

## References 
* [How to clone a specific Git branch?](http://stackoverflow.com/questions/1911109/clone-a-specific-git-branch)
* [How do I clone a single branch in Git?](https://stackoverflow.com/questions/1778088/how-do-i-clone-a-single-branch-in-git)
