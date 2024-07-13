# Add Global Key Event Listener for Vue 3

## Problem
* One [Quasar](https://quasar.dev/) Project Needs to Do Something when ESC is Pressed
* Add `@keyup.esc="onEsc"` on `q-page` Does NOT Work

## Solution
Use `document.addEventListener()`.

```js

onMounted(() => {
  document.addEventListener("keyup", function(e) {
    console.log("e.keyCode: " + e.keyCode)
    // Check if ESC is pressed.
    if (e.keyCode === 27) {
      onEsc()
    }
  })
})
```

## References
* [vue 全局响应键盘按键/监听键盘事件（含 js 获取键盘keyCode值的方法）](https://blog.51cto.com/u_15715491/5464634)
