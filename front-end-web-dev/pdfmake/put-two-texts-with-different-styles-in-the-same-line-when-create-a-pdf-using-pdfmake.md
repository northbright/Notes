# Put Two Texts with Different Styles in the Same Line when Create a PDF Using pdfmake

## Problem
* Using [pdfmake](https://github.com/bpampuch/pdfmake) to create a PDF
* Need to put two texts with different styles in the same line

## Solution
Set the value of 'text' to an array instead of a string.

```js
var dd = {
  content: [
    {
      text: [
        { text: 'normal part', style: 'normal'},
        { text: ' big and bold part', style: 'big'}
      ]
    }
  ],
  styles: {
    normal: {
      fontSize: 11
    },
    big: {
      fontSize: 16,
      bold: true
    }
  }
};
```

Try it on the [Playground](http://pdfmake.org/playground.html)

## References
* [STYLING](https://pdfmake.github.io/docs/0.1/document-definition-object/styling/)
* [Inline Style for Textcolors #1994](https://github.com/bpampuch/pdfmake/issues/1994)
