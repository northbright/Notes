
# `git clone` Specific Branch Without Fetching Other Branches

    mkdir mybranch
    cd mybranch
    git init
    git remote add -t $BRANCH -f origin $REMOTE_REPO
    git checkout $BRANCH

For more, see:  
<http://stackoverflow.com/questions/1911109/clone-a-specific-git-branch>