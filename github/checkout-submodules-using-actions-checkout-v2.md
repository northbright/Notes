# Checkout Submodules Using [actions/checkout@v2](https://github.com/actions/checkout)

## Problem
* A repo contains Hugo site
* This hugo site uses a customized theme(`themes/my-theme`) which is a git submodule hosted on github
* Use `SSH` protocal to initialize the theme submodule(`git@github.com:xx/my-theme`)
* Use [Github Actions](https://github.com/features/actions) to build and deploy the Hugo site
* Github action failed to update the submodule with the `git submodule update` command in action(`deploy.yml`):

  ```
  name: Deploy

  on:
    push:
      branches: [ dev, master ]
    pull_request:
      branches: [ dev, master ]

  jobs:

    build:
      runs-on: ubuntu-latest
      steps:
      - uses: actions/checkout@master

      - name: Update Theme
        run: git submodule update --init --recursive --force

      - name: Setup Hugo
        uses: peaceiris/actions-hugo@v2
        with:
          hugo-version: 'latest'
          extended: true

      - name: Build
        run: hugo --gc --minify --cleanDestinationDir
  ```

## Root Cause
* Because submodule use SSH, it needs to set public key for the authentication

## Solution
Replace `git@github.com:` with `https://github.com/` when run `git submodule update`

Fortunately, [actions/checkout@v2](https://github.com/actions/checkout) provides the `submodules` input to checkout submodules.

* Set `submodules` to `true` or `recursive`
* Leave `ssh-key` empty

>  - uses: actions/checkout@v2
     with:   
     ......
     # Whether to checkout submodules: `true` to checkout submodules or `recursive` to
     # recursively checkout submodules.
     #
     # When the `ssh-key` input is not provided, SSH URLs beginning with
     # `git@github.com:` are converted to HTTPS.
     #
     # Default: false
     submodules: ''

You can check the source code in <https://github.com/actions/checkout/blob/v2.3.4/src/git-auth-helper.ts#L64> :
```
  constructor(
    ......
    // Instead of SSH URL
    this.insteadOfKey = `url.${serverUrl.origin}/.insteadOf` // "origin" is SCHEME://HOSTNAME[:PORT]
    this.insteadOfValue = `git@${serverUrl.hostname}:`
  }
```

and <https://github.com/actions/checkout/blob/v2.3.4/src/git-auth-helper.ts#L154>:
```
  async configureSubmoduleAuth(): Promise<void> {
      ......
      if (this.settings.sshKey) {
        // Configure core.sshCommand
        await this.git.submoduleForeach(
          `git config --local '${SSH_COMMAND_KEY}' '${this.sshCommand}'`,
          this.settings.nestedSubmodules
        )
      } else {
        // Configure HTTPS instead of SSH
        await this.git.submoduleForeach(
          `git config --local '${this.insteadOfKey}' '${this.insteadOfValue}'`,
          this.settings.nestedSubmodules
        )
      }
      ......
  }
```

## Example Github Action
* `.github/workflows/deploy.yml`

```
name: Deploy

on:
  push:
    branches: [ dev, master ]
  pull_request:
    branches: [ dev, master ]

jobs:

  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v2
      with:
        submodules: 'recursive'

    - name: Setup Hugo
      uses: peaceiris/actions-hugo@v2
      with:
        hugo-version: 'latest'
        extended: true

    - name: Build
      run: hugo --gc --minify --cleanDestinationDir
```

## References
* <https://github.com/actions/checkout>
* [How to clone public submodule in "Github Actions"](https://stackoverflow.com/questions/59271919/how-to-clone-public-submodule-in-github-actions)
* [Git Submodules equivalent for url.insteadof](https://stackoverflow.com/questions/44788335/git-submodules-equivalent-for-url-insteadof)
* [`url.<base>.insteadOf`](https://git-scm.com/docs/git-config#Documentation/git-config.txt-urlltbasegtinsteadOf)
