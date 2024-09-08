# Stack Multiple Background Images

## Problem
* We need to use 2 background images for a [q-page](https://quasar.dev/layout/page) of a Quasar SPA
* The bottom background image
  * Image URL is fixed.
  * Fill the page.
* The top background image
  * Image URL can be changed dynamically by using axios.
  * Keep its aspect ratio while fitting within the page.

## Solution
Use multiple background images and stack them correctly.
The first("url(imageURL)") is on top and the next("bk.jpg") go down from there.

```vue
  <q-page class="flex flex-center"
          :style="{ 'background': 'url(' + imgURL + '), url(img/bk.jpg)',
                    'background-size': 'contain, cover',
                    'background-repeat': 'no-repeat, no-repeat',
                    'background-position': 'center, center'
                  }" @click="onPageClick" >
  ......
```

## References
* [Stacking Order of Multiple Backgrounds](https://css-tricks.com/stacking-order-of-multiple-backgrounds/)
