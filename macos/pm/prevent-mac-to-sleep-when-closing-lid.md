# Prevent Mac to Sleep When Closing Lid

## Problem
* Want to prevent Macbook Pro to sleep when closing lid

## Solution
Open a Terminal and run following commands to disable / enable sleep:

* Disable Sleep
  ```
  sudo pmset -a disablesleep 1
  ```

* Enable Sleep

  ```
  sudo pmset -a disablesleep 0
  ```

* Check `SleepDisabled` Status


  ```
  pmset -g

  // Output:
  // System-wide power settings:
  // SleepDisabled		1
  ```

## References
* [How to prevent your Mac to sleep when closing lid](https://yama-mac.com/en/prevent_sleep_when_lid_close/)
