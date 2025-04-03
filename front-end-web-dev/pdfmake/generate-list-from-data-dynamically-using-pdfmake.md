# Generate List from Data Dynamically using pdfmake

## Problem
* Use [pdfmake](https://github.com/bpampuch/pdfmake) to create PDF on server side
* Need to generate list(unordered / ordered) dynamically

## Solution
```js
import fs from 'fs';
import PdfPrinter from 'pdfmake';

const tasks = [
  { name: "Task A", desc: "Description of Task A"},
  { name: "Task B", desc: "Description of Task B"},
  {
    name: "Task C",
    desc: "Description of Task C",
    subTasks: [
      "Sub Task 1 of Task C",
      "Sub Task 2 of Task C",
      "Sub Task 3 of Task C"
    ],
  }
];

function genList(tasks) {
  let content = { ul: [] };

  tasks.forEach((task) => {
    let taskContent = {
      stack: [
        { text: task.name, bold: true, marginTop: 5 },
        { text: task.desc, marginBotton: 2 }
      ]
    }

    if (typeof task.subTasks === 'undefined') {
      // No sub tasks.
      //console.log('subTasks not defined');
    } else {
      // Show sub tasks using ordered list.
      let subTaskContent = { ol: [] };

      task.subTasks.forEach((item) => {
        subTaskContent.ol.push({ text: item });
      });

      // Append sub tasks to task content.
      taskContent.stack.push(subTaskContent);
    }

    content.ul.push(taskContent);
  });

  return content;
}

let docDefination = {
  'content': [
    { text: 'My Tasks', fontSize: 18, bold: true, alignment: "center" },
    genList(tasks)
  ],
  defaultStyle: {
    fontSize: 12,
  }
}

var fonts = {
  Roboto: {
    normal: 'fonts/Roboto/Roboto-Regular.ttf',
    bold: 'fonts/Roboto/Roboto-Medium.ttf',
    italics: 'fonts/Roboto/Roboto-Italic.ttf',
    bolditalics: 'fonts/Roboto/Roboto-MediumItalic.ttf'
  }
};

let printer = new PdfPrinter(fonts);
let pdfDoc = printer.createPdfKitDocument(docDefination, {});
pdfDoc.pipe(fs.createWriteStream('test.pdf'));
pdfDoc.end();
``` 

## References
* [pdfmake-example](https://github.com/northbright/pdfmake-example)
* <https://github.com/bpampuch/pdfmake/tree/0.1/examples>
* [STACK OF PARAGRAPHS](https://pdfmake.github.io/docs/0.1/document-definition-object/stack/)
* [Generating Complex PDF files with Node.js and PDFMake](https://www.appgambit.com/blog/nodejs-with-pdfmake)
