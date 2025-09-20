# Got Bad Token stdin:1 Error when Using `echo` and `bc` to Do Calculation due to One Input Has Not been Initialized

## Problem
* Run following command

  ```sh
  a=2 && total=$(echo $total + $a | bc)
  ```

* Got Error

  > Parse error: bad token
  >  <stdin>:1

## Root Cause
"total" is not initialized and it's empty.
`echo $total + $a` will output ` + 2` and the expression will be parsed failed in `bc`.

## Solution
Initialize total before run `bc`.

```sh
total=0 && a=2 && total=$(echo $total + $a | bc)
```

