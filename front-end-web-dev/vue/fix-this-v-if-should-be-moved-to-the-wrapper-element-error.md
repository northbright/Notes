# Fix "This 'v-if' should be moved to the wrapper element" Error

## Problem
* A Quasar Project with eslint
* Show some images for conditional rending
* Use `v-if` and `v-for` on the same QImg

  ```vue
  <q-img v-if="mode === 'select_mode'"
    v-for="item in items"
    :key="item.id"
    :src="item.img_url"
    fit="contain"
    width="30vw"
    height="30vh"
  />
  ```
* Run `quasar build` and got error:

  > "This 'v-if' should be moved to the wrapper element"

## Root Cause
* It's not recommended to use v-if and v-for on the same element due to implicit precedence.
* [vue/no-use-v-if-with-v-for](https://eslint.vuejs.org/rules/no-use-v-if-with-v-for.html)
  > This rule is aimed at preventing the use of v-for directives together with v-if directives on the same element.

## References
* [v-if with v-for](https://vuejs.org/guide/essentials/conditional.html#v-if-with-v-for)
* [vue/no-use-v-if-with-v-for](https://eslint.vuejs.org/rules/no-use-v-if-with-v-for.html)
