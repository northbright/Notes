# Use Github Actions to Build Hugo Site

## Solution
Add `.github/workflows/build.yml` under your site repo

```
name: Build

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
* [Github Actions](https://github.com/features/actions) 
* [使用 Hugo 搭建个人网站（博客、个人主页）并发布到 Github 上](https://zhuanlan.zhihu.com/p/417259374)
* [Checkout Submodules Using actions/checkout@v2](../github/checkout-submodules-using-actions-checkout-v2.md)
