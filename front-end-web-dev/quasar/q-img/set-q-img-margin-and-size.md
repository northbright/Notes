# Set q-img Margin and Size

## Problem
* Put a q-img in a q-page
* Need to specify the q-img's margin-left, margin-top, width and height

## Solution
* Make sure q-page's style NOT contain "flex flex-center" class.
* Use `style="margin-left: xx; margin-top:xx" for the margins.
* Use `width` and `height` for the size.

```vue
<q-page>
  <q-img v-if="mode === 'show_mode'"
    ref="qimgRef"
    :src="imgURL"
    fit="contain"
    style="margin-left: 10vw; margin-top: 10vh;"
    :width="qimgWidth"
    :height="qimgHeight"
    class="no-padding"
    @load="onImgLoad()"
  />
</q-page>
```
