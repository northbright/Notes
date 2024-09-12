# Set Color of Text in q-input

## Problem
* Set color of q-input to white and the text of input is changed to black automatically
* Need to set the color of q-input to white

## Solution
Set "input-class" to your customized CSS class.

## Example
```vue
<q-input
  ref="inputRef"
  standout outlined rounded autofocus 
  color="white"
  bg-color="green"
  style="max-width: 48vw"
  placeholder="请输入作品编码"
  v-model="text" input-class="text-center my_input" class="q-ml-md"
  maxlength=18
  @keyup.enter="searchByCode(text)"
  @focus="onInputFocus()"
  @blur="onInputLoseFocus()"
 >
   <template v-slot:append>
     <q-icon v-if="text === ''" name="search" size="6vw" />
     <q-icon v-else name="clear" class="cursor-pointer" size="6vw" @click="text = ''" />
   </template>
</q-input>

<style lang="sass">
.q-field__control
  display: flex
  align-items: center
  height: 12vh
  font-size: 10vh

.my_input
  color: white
</style>
```

## References
* [ability to set QInput text color #14715](https://github.com/quasarframework/quasar/discussions/14715)
