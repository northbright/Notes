# Vue Can Not Detect Changes when Directly Set an Item with Index to Array

## Problem
* Can not detect changes when set an item with index to array
  
  ```
  arr[index] = newValue;

  ```

## Root Cause
> Vue cannot detect the following changes to an array:

    1. When you directly set an item with the index, e.g. vm.items[indexOfItem] = newValue
    2. When you modify the length of the array, e.g. vm.items.length = newLength

## Solution
* Use `Array.prototype.splice` which can be detected by vue

  ```
  // 1st param is the index of value to remove
  // 2nd param is number of value to remove
  // 3rd param is new value to add
  // 
  arr.splice(index, 1, newValue);
  ```

## References
* [Reactivity in Depth](https://vuejs.org/v2/guide/reactivity.html#For-Arrays)
* [Array.prototype.splice()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice)
