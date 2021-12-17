# Set Description of Homepage in Hugo Clarity

## Problem
* Set `description` in `config/_default/params.toml`
* But it shows `hugo-clarity xxxxx` as description of homepage

## Root Cause
The template(`layouts/partials/opengraph.html`) reads the description from a page frontmatter. For the homepage, that would be in `content/_index.md`.

## Solution
* Set `author` and `description` in `content/_index.md` 

## Example
`content/_index.md`

```
+++
author = "My Company"
description = "My Company. Since 1984" # set your site's description here. will be use for home page content meta tags (seo).
+++
```

## References
* [home page doesn't have any meta description content](https://github.com/chipzoller/hugo-clarity/issues/34)
