# Sync a Fork with Upstream Repo

## Solution
* Fork a repo on Github(`https://github.com/ORIGINAL_OWNER/ORIGINAL_REPO`)
* `git clone https://github.com/ME/MY_REPO`
* Add a new remote(upstream) for the fork repo

  ```
  git remote add upstream https://github.com/ORIGINAL_OWNER/ORIGINAL_REPO.git
  ```
* Show remote

  ```
  git remote -v
  origin git@github.com:ME/MY_REPO.git (fetch)
  origin git@github.com:ME/MY_REPO.git (push)
  upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (fetch)
  upstream  https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git (push)
  ```

* Update Upstream Remote

  ```
  git fetch upstream
  ```

* Merge

  ```
  git merge upstream/master
  ```

## References
* [Syncing a fork](https://docs.github.com/en/github/collaborating-with-pull-requests/working-with-forks/syncing-a-fork)
* [Configuring a remote for a fork](https://docs.github.com/en/github/collaborating-with-pull-requests/working-with-forks/configuring-a-remote-for-a-fork)
* [GitHub: How to make a fork of public repository private?](https://stackoverflow.com/questions/10065526/github-how-to-make-a-fork-of-public-repository-private)
