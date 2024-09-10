# Use Qimg to Show Image to Fit QPage

## Problem
* QPage has a background image
* Put a QImg in the center of QPage
* QImg should take max-width or max-height of the screen(QPage) while maitain its aspect ratio depend on its src image

## Solution
Use [Flex Grid](https://quasar.dev/layout/grid/introduction-to-flexbox) to make QImg center of the QPage.
Set QImg's [Fit Mode](https://quasar.dev/vue-components/img/#fit-mode) to [contain](https://developer.mozilla.org/en-US/docs/Web/CSS/object-fit#contain).
Add "max-height: 98vh;" to QImg's style to make QImg use 98% of the total screen height.

```vue
<template>
  <q-page
    class="flex flex-center"
    :style="{
      'background': 'url(img/bk.jpg)',
      'background-size': 'cover',
      'background-repeat': 'no-repeat',
      'background-position': 'center'
    }"
    @click="onPageClick"
  >
    <q-img
      src="img/J115GYX.jpg"
      fit="contain"
      style="max-height: 98vh;"
    />
  </q-page>
</template>
```
