# Install Quasar on macOS

## Steps
#### Install Yarn on macOS
* [Install Yarn on macOS](https://github.com/northbright/Notes/blob/master/front-end-web-dev/yarn/install-yarn-on-macos.md)

#### Install Quasar via Yarn
```
sudo yarn global add @quasar/cli
```

#### check
```
quasar -v
```

#### Create Quasar Project Dir

```
yarn create quasar
```

#### Push the Project to Github(Optional)
* Create a New Empty Repo(NO `README.md`, `.gitignore`, LICENSE) on Github

```
cd ~/my-project

git init
git branch -M master
git remote add origin git@github.com:MY-USER/MY-REPO.git
git add -i
git commit -m "first commit"
git push -u origin master
```

## References
* [Quick Start](https://quasar.dev/start/quick-start)
* [Create a New Local Repo and Push It to Github](https://github.com/northbright/Notes/blob/master/github/create-a-new-local-repo-and-push-it-to-github.md)
