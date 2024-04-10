# Add and Update a Submodule

## Add a Submodule
* Git Repo: `/home/xx/a`
* Added a Submodule via `git submodule add <remote_url> <destination_folder>`

  e.g. add submodule to `/home/xx/a/b`

  ```
  e.g. add submodule to /home/xx/a/b
  cd /home/xx/a
  git submodule add git@github.com:xx/b.git b
  ```

* Initialize(Pull) the Submodule

  ```
  git submodule update --init --recursive
  ```

## Update a Submodule
```
cd /home/xx/a
git submodule update --remote --merge
```

## Commit the Submodule Changes
```
git add .
git commit -m "Added new commits from the submodule repository"
git push
```

## References
* [How To Add and Update Git Submodules](https://devconnected.com/how-to-add-and-update-git-submodules/)
