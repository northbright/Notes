# Can Not Create New Post(Generate HTML) Due to Incorrect Date

## Problem
* Copy an existed post(`2021-xx.md`) to a new one(`2022-xx.md`) to create a new post manually but not using [`hugo new`](https://gohugo.io/commands/hugo_new/)
* Modify the content
* Replace `2021` with `2022`
* Run `hugo server` or `hugo`
* The new post is not build or published, the html file is not generated


## Root Cause
* `Date` is incorrect
* When replace `2021` with `2022`
  The `Date` is set to `2022/xx/xx` which is yet to come

## Solution
* Using [`hugo new`](https://gohugo.io/commands/hugo_new/) or set the `Date` correctly 
