# It is Not Necessary to Check if a Slice is Not nil before Checking that Its Length is Not Zero

## Problem
* Check if a slice is not nil and then check if its length is not zero

  ```
  func f(s []string) {
        // Check slice
        if s == nil || len(s) == 0 {
                log.Printf("nil slice or slice length is zero")
                return
        }
  }
  ```

* Run [staticcheck](https://staticcheck.io/) and got warnning:

  > should omit nil check; len() for []string is defined as zero (S1009)

## Root Cause
* Found [S1009 - Omit redundant nil check on slices](https://staticcheck.io/docs/checks#S1009)

  > The len function is defined for all slices, even nil ones, which have a length of zero. It is not necessary to check if a slice is not nil before checking that its length is not zero.

## Solution
* Remove the code to check if a slice is not nil

  ```
  func f(s []string) {
        // Check slice
        if len(s) == 0 {
                log.Printf("nil slice or slice length is zero")
                return
        }
  }
  ```

## References
* [S1009 - Omit redundant nil check on slices](https://staticcheck.io/docs/checks#S1009)
