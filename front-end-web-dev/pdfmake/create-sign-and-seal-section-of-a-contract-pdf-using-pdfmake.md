# Create "Sign and Seal" Section of a Contract PDF Using pdfmake

## Problem
* Use [pdfmake](https://github.com/bpampuch/pdfmake) to create contract PDFs on server side
* Need to create the "Sign and Seal" section at the end of the PDF

## Solution
Use [Tables](https://pdfmake.github.io/docs/0.1/document-definition-object/tables/).

## Examples

```js
var dd = {
  content: [
    { text: "Contract", fontSize: 18, bold: true, alignment: "center" },
    {
      layout: 'noBorders',
      table: {
        widths: ['*','*'],
        body: [
          [
            { text: 'Party A(seal):', alignment: "center" }, 
            { text: 'Party B(seal):', alignment: "center" },
          ],
        ],
      },
      marginTop: 400,
    },
    {
      layout: 'noBorders',
      table: {
        widths: ['*','*'],
        body: [
          [
            { text: 'Party A(sign):', alignment: "center" }, 
            { text: 'party B(sign):', alignment: "center" },
          ],
        ],
      },
      marginTop: 200,
    },    
  ]
}
``` 

You may run the example code on the [playground](http://pdfmake.org/playground.html)

## References
* [Tables](https://pdfmake.github.io/docs/0.1/document-definition-object/tables/)
* [playground](http://pdfmake.org/playground.html)
* [Generating Complex PDF files with Node.js and PDFMake](https://www.appgambit.com/blog/nodejs-with-pdfmake)
