
# git commit and push to gerrit server

1.  `git add <files>`
2.  `git commit -m "commit_msg"`
3.  `git branch -r` to show current remote branch.
4.  `git fetch <remote> refs/heads/<branch>` to update remote repo's branch.
    * It will get a new `FETCH_HEAD`
5.  `git rebase -i FETCH_HEAD` to rebase local HEAD on remote repo branch HEAD(`FETCH_HEAD`).
6.  `git push <remote> HEAD:refs/for/<branch>`