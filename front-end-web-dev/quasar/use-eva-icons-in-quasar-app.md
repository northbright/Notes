# Use Eva Icons in Quasar App

## Steps

#### Install [Eva Icons](https://akveo.github.io/eva-icons) for Quasar App
* Add `eva-icons` in `extras` section of `quasar.config.js`

  ```js
  extras: [
    'eva-icons',
  ],
  ```

#### Use Eva Icons
Add `eva-` prefix to the Eva Icon name and set it to "name" of "q-icon" or "icon" in "q-btn".

```vue
<q-btn
  flat
  icon="eva-plus-circle-outline" 
  size="xl"
  :label="text"
/>
```

## References
* [Eva Icons](https://akveo.github.io/eva-icons/)
* [Installing Icon Libraries](https://quasar.dev/options/installing-icon-libraries)
* [Icon](https://quasar.dev/vue-components/icon)
