# Set Focus on `q-input` Programmatically

## Problem
* Need to Re-Set Focus on `q-input` when It Loses Focus

## Solution
Get "ref" of the `q-input` and call [`focus`](https://quasar.dev/vue-components/input) method.

```js
<template>
  <q-page class="flex flex-center" >
      <q-input
        ref="inputRef"
        standout rounded autofocus 
        bg-color="green"
        style="max-width: 48vw"
        placeholder="please input code"
        v-model="text" input-class="text-center" class="q-ml-md"
        @keyup.enter="search(text)"
        @focus="onInputFocus()"
        @blur="onInputLoseFocus()"
      >
      </q-input>
  </q-page>
</template>

import { ref } from 'vue'

const inputRef = ref()

const onInputFocus = () => {
  console.log("onInputFocus()")
}

const onInputLoseFocus = () => {
  console.log("onInputLoseFocus()")
  inputRef.value.focus()
}
```

## References
* [How to programmatically set the focus? #12206](https://github.com/quasarframework/quasar/discussions/12206)
