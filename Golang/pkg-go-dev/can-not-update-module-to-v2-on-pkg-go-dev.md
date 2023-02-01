# Can NOT Update Module to V2 on pkg.go.dev

## Problem
* Add v2.0.0 tag and push the commit to `github.com/USER/REPO`
* Visit `pkg.go.dev/github.com/USER/REPO@v2.0.0` and click "request github.com/USER/REPO@v2.0.0"
* Failed to update module on pkg.go.dev

## Root Cause
* Major Version > 1(V2, V3...) should follow the [rules](https://go.dev/blog/v2-go-modules)

## References
* [Go Modules: v2 and Beyond](https://go.dev/blog/v2-go-modules)
