# Check if a String has Prefix in JS

## Solution
Use string's [startsWith](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/startsWith).

## Example
```js
const searchByPressEnter = (txt) => {
  var l = [...txt].length

  if (l < 3) {
    return
  }

  if (txt.startsWith("*") === true) {
    searchByPattern(txt)
  } else {
    searchByCode(txt)
  }     
}
```

