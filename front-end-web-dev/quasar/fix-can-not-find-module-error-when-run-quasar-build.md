# Fix "Can not find module" Error when Run `quasar build`

## Problem
* Have a [Quasar](https://quasar.dev/) project(has been pushed to Github)
  * Dir: `/Users/xx/quasar_project`
* Need to Upgrade Quasar from `v2.6.0` to Latest Version Include Its Dependencies(e.g. vue...) for the Project
* Use `yarn create quasar` to Create a New Project(dir)
  * New Project Dir: `/Users/xx/quasar_project_new`
* Copy Source Code New Project Dir

  ```bash
  cp -rf /Users/xx/quasar_project/src /Users/xx/quasar_project_new/src
  ```  
* Do Some Modification to Make `quasar build` in `/Users/xx/quasar_project_new` Successful
* Copy All Files from New Project Dir to Old Project Dir

  ```bash
  cp -rf /Users/xx/quasar_project_new /Users/xx/quasar_project
  ```

* Run `quasar build` in Old Project Dir and Got Error
  
  > node:internal/modules/cjs/loader:1148
  > throw err;
  > Error: Cannot find module '../package.json'
  > Require stack:
  > - /Users/xx/projects-quasar/node_modules/.bin/eslint
  >   ...
  >   code: 'MODULE_NOT_FOUND',
  >   requireStack: [
  >     '/Users/xxu/projects-quasar/zb2-front-end/node_modules/.bin/eslint'
  >   ]
  > }

## Solution
Remove `node_modules` in the project dir and run `yarn install`.

* Remove `node_modules`

  ```bash
  rm -rf node_modules
  ```

* Run `yarn install`

  ```bash
  yarn install
  ```

* Quasar Build Works Now

  ```bash
  quasar build
  ```

* Git Commit and Push

  ```
  git add -i
  git commit -m "Bump Quasar to latest version(v2.16.0)"
  git push origin HEAD:master
  ```

## References
* [Upgrade Guide](https://quasar.dev/start/upgrade-guide)
* [Cannot find module error in Node.js (Fixed)](https://www.decodingweb.dev/cannot-find-module-error-in-node-js-fixed)
