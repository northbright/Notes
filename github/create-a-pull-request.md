# Create a Pull Request

Use Pull Request to make a bug fix for someone else's project.

#### Steps
1. Open an issue for original repo before make any bug fix

    Many authors require open an issue before create pull requests.
    You should follow CONTRIBUTING.md under repo. 
    e.g. [redigo's CONTRIBUTING.md](https://github.com/garyburd/redigo/blob/master/.github/CONTRIBUTING.md):

        Ask questions at StackOverflow.
        Open an issue to discuss your plans before doing any work on Redigo.

2. Fork the original repository

   Click the `Fork` button on the original repo.

3. Clone your fork repo to local

        git clone git@github.com:YOUR_NAME/FORK_REPO.git

4. Add **"upstream"** remote to make it possible to keep your fork repo synced

        git remote add upstream https://github.com/ORIGINAL_OWNER/ORIGINAL_REPOSITORY.git
        // check remote
        git remote -v

5. Keep your fork repo **synced** before make any bug fix

         // fetch upstream
         git fetch upstream

         // switch to local master branch
         git checkout master
         
         // merge
         git merge upstream/master

6. Make the bug fix

7. Make sure add `#ISSUE_ID`in your commit message when `git commit`

   Add `#ISSUE_ID` into the commit message that will auto generate a reference to the open issue created when you push to your fork repo. See [Notifications, @mentions, and references](https://guides.github.com/features/issues/#notifications) for more information.

        // Example Commit Message
        // #305 is the issue id
        Add missing comma in comment(#305) 

8. Push commit to remote fork repo

        git push origin HEAD:master
  
9.  Create `Pull Request`
     * Go to your fork repo, click `New Pull Request`
     * Input your open issue id and description

10. Wait author to merge the pull request if he likes it.

#### References
* [Fork A Repo](https://help.github.com/articles/fork-a-repo/)
* [working-with-forks](https://help.github.com/articles/working-with-forks/)
* [Mastering Issues](https://guides.github.com/features/issues/)
* [Github上git commit 提交注释的规范](https://segmentfault.com/q/1010000000395039)

