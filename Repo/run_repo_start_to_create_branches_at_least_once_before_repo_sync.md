
# Run `repo start <branch>` to create a new branch for each repo at least once before `repo sync`

We need to run `repo start <branch>` to create a new branch for each repo at least once before `repo sync` and make changes on synchronized repo.  
Otherwise, you'll see `* (no branch)` when you run `git branch -a` in your repo.