# Build a Regexp from Variables

## Solution
Use `RegExp()` and `${VAR_NAME}`.

```js
var name = "frank"
var regexp = new RegExp(`^[A-Z]+\\d+${name}$`)
console.log("regexp: " + regexp)
// Ouput: /^[A-Z]\d+frank$/
}
```
