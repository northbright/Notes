# List Item Can Be Stack in pdfmake

List item in [pdfmake](https://github.com/bpampuch/pdfmake) can be not only text but also [STACK](https://pdfmake.github.io/docs/0.1/document-definition-object/stack/)

## Example
```js
var dd = {
  content: [
    { text: "My Tasks", fontSize: 18, bold: true, alignment: "center" },
    {
      ul: [
        {
          text: "Task A", bold: true, marginTop: 10
        },
        {
          stack: [
            { text: "Task B", bold: true, marginTop: 10 },
            { text: "This is description of Task B.", marginTop: 2}
          ]
        },
        {
          stack: [
            { text: "Task C", bold: true, marginTop: 10 },
            { 
              ol: [
                {
                  text: "Sub Task 1 of Task C"
                },
                {
                  text: "Sub Task 1 of Task C"
                },            
              ]
            }
          ]
        }
      ]
    },
  ]
}
```

Try to run the code on [pdfmake playground](http://pdfmake.org/playground.html)

## References
* [pdfmake-example](https://github.com/northbright/pdfmake-example)
* <https://github.com/bpampuch/pdfmake/tree/0.1/examples>
* [STACK OF PARAGRAPHS](https://pdfmake.github.io/docs/0.1/document-definition-object/stack/)
* [Generating Complex PDF files with Node.js and PDFMake](https://www.appgambit.com/blog/nodejs-with-pdfmake)
