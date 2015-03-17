
# Run `repo start <branch> <project_list>` to create a new topic branch for specified projects before `repo sync`

We need to run `repo start <branch> <project_list>` to create a new topic branch for specified projects before `repo sync` and make changes on synchronized repo.   

Ex:  

    repo start test_branch packages/apps/Launcher2 packages/apps/Launcher3
    repo sync -c --no-tags -j 4
 
Otherwise, you'll see `* (no branch)` when you run `git branch -a` in your repo.

#### References
* <https://source.android.com/source/using-repo.html>
* <http://wiki.cyanogenmod.org/w/Doc:_using_gerrit>