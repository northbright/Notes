# Set q-dialog Width

## Problem
* A q-dialog contains a q-card which contains q-imgs
* Need to set q-dialog width
* Use <q-dialog style="width=XXvw"> does not work

## Solution
Set "width" and "max-width" in "style" of q-card in the q-dialog.

```vue
      <q-dialog v-model="showDialog">
      <q-card style="width: 33vw; max-width: 33vw;">
        <q-card-section>
          <div class="text-h2">{{ text }}</div>
        </q-card-section>
        <q-card-section
          v-for="c in matchedCodes"
          :key="c"
        >
          <q-img
            :src="genImageURL(c)"
            style="max-width: 30vw"
            fit="contain"
            @click="selectMatchedCode(c)"
          >
            <div> {{ c }}</div>
          </q-img>
        </q-card-section>
        <q-card-actions align="right">
          <q-btn flat label="OK" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
```
