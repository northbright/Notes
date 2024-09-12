# Bind Style for Quasar Dialog

## Problem
* Need to load the style(e.g. `min-width`) of `q-dialog` from config file(back-end)
* The `config.json` looks like:

  ```
  {
    "addr":":8080",
    "lottery_name":"New Year's Party Lottery",
    "img_dialog_width_vw":65
  }
  ```

## Solution
Use Vue `v-bind:style` on `q-dialog`
```
<template>
   ......
    <q-dialog v-model="showDialog" persistent>
      <q-card v-bind:style="[ dialogStyle ]">

        <q-card-section>
          <q-img
            :src="imageURL"
          />
        </q-card-section>
        <q-card-actions align="right" class="bg-white text-teal">
          <q-btn flat label="OK" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
    ......
</template>

<script>
import axios from "axios";

export default {
  name: "MyLayout",

  data() {
    return {
      config: {},
      dialogStyle: {
              // default min-width of image dialog
              'min-width': '70vw'
      },
    };
  }

  ......

  methods: {
     getConfig() {
      axios
        .get("/config")
        .then((response) => {
          if (response.data.success) {
            this.config = response.data.config;
            this.dialogStyle = {
                  'min-width': this.config.img_dialog_width_vw + 'vw'
            };
          } else {
            var errMsg = "/config error: " + response.data.err_msg;
            this.notify(errMsg);
          }
        })
        .catch((e) => {
          var errMsg = "/config axios error: " + e;
          this.notify(errMsg);
        });
    },
    ......
  }
};
</script>
```
