# Add Page Break in pdfmake

## Problem
* Need to add page break manually

## Solution
Set `pageBreak` on any element to 'after' or 'before'.

See [Adding page breaks in the doc definition #25](https://github.com/bpampuch/pdfmake/issues/25)

## Example
```js
let docDefination = {
    content: [
        {text: 'Source Han Serif - An open source Pan-CJK typeface', pageBreak: 'after'},
        {text: '思源宋体 - 开源的泛 CJK 字体', bold: true}
    ],
    defaultStyle: {
        font: 'SourceHanSansSC'
    }
}
```

## References
* [Adding page breaks in the doc definition #25](https://github.com/bpampuch/pdfmake/issues/25)
