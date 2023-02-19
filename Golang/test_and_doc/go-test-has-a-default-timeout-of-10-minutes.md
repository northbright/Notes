# `go test` Has a Default Timeout of 10 Minutes

## Problem
* Run `go test -v` for a Golang package and got error:

  > panic: test timed out after 10m0s

## Root Cause
* `go test` Has a Default Timeout of 10 Minutes

## Solution
* Make test short
* or Use `-timeout` Option
  
  ```
  // Set timeout to 20 minutes. Use 'm' for minutes.
  go test -v -timeout 20m

  // Set timeout to 1 hour. Use 'h' for hours.
  go test -v -timeout 1h
  ```

## References
* [Timeouts and logging](https://terratest.gruntwork.io/docs/testing-best-practices/timeouts-and-logging/)
