# Set q-input Height to Fit Large Font Size

## Problem
* Need to Set Large Font for `q-input`
  ```
  <q-input style="font-size: 20vh">
  ```

* The Size(height) of `q-input` is NOT Increased Automatically to Fit the Large Font Size

## Solution
Add style for `q-input` to increase the height.

```
.q-field__control {
  display: flex;
  align-items: center;
  height: 22vh;
  font-size: 20vh;
}
```

## References
* [Is a q-input ready for size changes? #16059](https://github.com/quasarframework/quasar/discussions/16059)
