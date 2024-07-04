# Create a New Local Repo and Push It to Github

## Problem
* Run `sudo yarn create quasar` to Create a Quasar Project Dir
* Need to Push the New Created Dir(repo) to Github

## Solution
* Create a New Empty Repo(NO `README.md`, `.gitignore`, LICENSE)
* After the Repo was Created Successfully, You'll See the Instruction

  > …or create a new repository on the command line

* Go to the Dir

  ```
  git init
  git branch -M master
  git remote add origin git@github.com:MY-USER/MY-REPO.git
  git add -i
  git commit -m "first commit"
  git push -u origin master
  ```

## References
* [Adding a local repository to GitHub using Git](https://docs.github.com/en/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github#adding-a-local-repository-to-github-using-git)
