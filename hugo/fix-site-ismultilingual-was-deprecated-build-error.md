# Fix ".Site.IsMultiLingual was deprecated" Build Error

## Problem
* Build a Hugo site with a theme which forked from [Hugo-Clarity](https://github.com/chipzoller/hugo-clarity)
* Github Action use latest Hugo(0.139.2) to build the site

  ```
  - name: Setup Hugo
    uses: peaceiris/actions-hugo@v2
    with:
      hugo-version: 'latest'
      extended: true
  ```
* Got errror when build the site

  > ERROR deprecated: .Site.IsMultiLingual was deprecated in Hugo v0.124.0 and will be removed in Hugo 0.140.0. Use hugo.IsMultilingual instead.

## Root Cause
* The forked repo use ".Site.IsMultiLingual" which is deprecated in latest Hugo.

## Solution
Find `.Site.IsMultiLingual` and replace them with `hugo.IsMultilingual`.

```
cd ~/my_site
find . -name "*.*" | xargs grep -i "IsMultiLingual" -rn --color
```

Replace `.Site.IsMultiLingual` with `hugo.IsMultilingual`.

## References
* [IsMultiLingual](https://gohugo.io/methods/site/ismultilingual/)
* [WARN deprecated: .Site.IsMultiLingual was deprecated..Use hugo.IsMultilingual instead](https://discourse.gohugo.io/t/warn-deprecated-site-ismultilingual-was-deprecated-use-hugo-ismultilingual-instead/51007)
