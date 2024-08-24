# Add Github Action to Build Quasar Project

## Solution

#### Check Supported nodejs Version in `package.json`

```bash
vi package.json
```

```json
......
"engines": {
  "node": "^20 || ^18 || ^16",
  "npm": ">= 6.13.4",
  "yarn": ">= 1.21.1"
}
......
```

You may find it requires nodejs v20, v18 or v16 in this `package.json` of the quasar project.

#### Create the `build.yml`

```bash
vi .github/workflows/build.yml
```

```yml
# https://help.github.com/en/articles/workflow-syntax-for-github-actions

name: Build

on:
- push

jobs:
  build:
    name: Build
    runs-on: ${{ matrix.os }}
    strategy:
      matrix:
        os:
        - macos-12
        - macos-latest
        - ubuntu-22.04
        - ubuntu-latest
        node:
        - 18
        - 20

      fail-fast: false
    steps:
    - name: Checkout source codes
      uses: actions/checkout@v4

    - name: Set up Node
      uses: actions/setup-node@v4
      with:
        node-version: ${{ matrix.node }}

    - name: Install Yarn
      run: npm install --global yarn

    - name: Install Quasar
      run: yarn global add @quasar/cli

    - name: Install Dependencies
      run: yarn install

    - name: Build
      run: quasar build
```
