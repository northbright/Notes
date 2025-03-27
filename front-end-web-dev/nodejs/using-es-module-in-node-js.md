# Using ES Module in Node.js

## Problem
* Initialized a Node.js project and created an "app.js"
* Create a "test.js" and export functions(e.g. "add")
 
  ```js
  export function add(a, b) {
    return a + b;
  };
  ```

* "app.js" imports "add" from "test.js"

  ```js
  import { add } from './test.js';
  ```

  Got error:
  > Cannot Use Import Statement Outside a Module

## Root Cause
Node.js Using CommonJS by Default.
* By default, Node.js uses CommonJS (CJS) modules, not ES modules
* This means that the `import/export` syntax is not natively supported unless specified

## Solution
* Add `"type":"module"` in `package.json`

  ```js
  {
    "type": "module",
    "dependencies": {
      "nunjucks": "^3.2.4",
      "pdfmake": "^0.2.18"
      ......
    },
    ......
  }
  ```

* Use `import` but NOT `require` to import npm modules

  ```js
  // CommonJS way
  //const fs = require('fs');
  //const { parseArgs } = require('node:util');
  //const PdfPrinter = require('pdfmake');
  //const nunjucks = require('nunjucks');

  // ES Modules way
  import fs from 'fs';
  import { parseArgs } from 'node:util';
  import PdfPrinter from 'pdfmake';
  import nunjucks from 'nunjucks';
  import { add } from './test.js';

  console.log(add(3, 4));
  ```

## References
* [Using import Statements in Node.js](https://masteringjs.io/tutorials/node/import)
* [Javascript modules - Cannot use import statement outside a module](https://stackoverflow.com/questions/62443624/javascript-modules-cannot-use-import-statement-outside-a-module)
