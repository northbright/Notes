# Use pdfmake to Create PDF on macOS for China User

## Problem
* Need to create PDFs from JSON data on macOS
* PDF may contain CJK characters

## Solution
Use [pdfmake](https://github.com/bpampuch/pdfmake) to create PDF on macOS in server-side mode. 

#### Install Node.js
* [Install Node.js and npm on macOS](https://github.com/northbright/Notes/blob/master/front-end-web-dev/nodejs/install-nodejs-and-npm-on-macos.md)

#### Install Yarn
* [Install Yarn on macOS](https://github.com/northbright/Notes/blob/master/front-end-web-dev/yarn/install-yarn-on-macos.md)

#### Create and Initialize Project
* Create project dir

  ```shell
  mkdir -p ~/pdf-test
  cd ~/pdf-test
  ```

* Initialize project

  ```shell
  yarn init -y
  ```

* Add pdfmake as dependency

  ```shell
  yarn add pdfmake
  ```

#### Prepare Fonts
To use pdfmake to create a PDF, need to get the font files which are used to embeded into the PDF.
* Create fonts dir

  ```shell
  mkdir ~/pdf-test/fonts
  ```

* For personal use, just get PingFang(苹方) font file
  * [Get PingFang(苹方) Font File on macOS](https://github.com/northbright/Notes/blob/master/font/get-pingfang-font-file-on-macos.md)
  * Copy font file to the fonts dir
    
    ```shell
    mkdir -p ~/pdf-test/fonts/PingFang
    cp /System/Library/Fonts/PingFang.ttc ~/pdf-test/fonts/PingFang
    ```

* For commerial use, [Source Han Serif（思源宋体）](https://github.com/adobe-fonts/source-han-serif) and [Source Han Sans（思源黑体）](https://github.com/adobe-fonts/source-han-sans/) are recommended

  * [Build Source Han Serif Font from Source on macOS for China User](https://github.com/northbright/Notes/blob/master/font/build-source-han-serif-font-from-source-on-macos-for-china-user.md)
  * [Build Source Han Sans Font from Source on macOS for China User](https://github.com/northbright/Notes/blob/master/font/build-source-han-sans-font-from-source-on-macos-for-china-user.md)
  * Copy OpenType Collection file(.ttc) file to the fonts dir

    ```shell
    mkdir -p ~/pdf-test/fonts/SourceHanSerif
    mkdir -p ~/pdf-test/fonts/SourceHanSans
    cp /path/to/SourceHanSerifSC.ttc ~/pdf-test/fonts/SourceHanSerif
    cp /path/to/SourceHanSansSC.ttc ~/pdf-test/fonts/SourceHanSans
    ```

#### Create `index.js`

```shell
vi ~/pdf-test/index.js
```

```js
const fs = require('fs');

const PdfPrinter = require('pdfmake');

var fonts = {
    PingFangSC: {
        normal: ['fonts/PingFang/PingFang.ttc', 'PingFangSC-Regular'],
        bold: ['fonts/PingFang/PingFang.ttc', 'PingFangSC-Semibold'],
    },
    SourceHanSerifSC: {
        normal: ['fonts/SourceHanSerif/SourceHanSerifSC.ttc', 'SourceHanSerifSC-Regular'],
        bold: ['fonts/SourceHanSerif/SourceHanSerifSC.ttc', 'SourceHanSerifSC-Bold'],
    },
    SourceHanSansSC: {
        normal: ['fonts/SourceHanSans/SourceHanSansSC.ttc', 'SourceHanSansSC-Regular'],
        bold: ['fonts/SourceHanSans/SourceHanSansSC.ttc', 'SourceHanSansSC-Bold'],
    }
};

let printer = new PdfPrinter(fonts);

let docDefination = {
    content: [
	    'Source Han Serif - An open source Pan-CJK typeface',
        '思源宋体 - 开源的泛 CJK 字体',
        '思源宋體 - 開放原始碼泛 CJK 字體',
        '源ノ明朝 - オープンソース Pan-CJK 書体',
        '본명조 - 오픈 소스 Pan-CJK 서체',
        {text: 'Thanks!', fontSize: 18, bold: true},
        {text: '感谢!', fontSize: 18, bold: true},
        {text: '感謝!', fontSize: 18, bold: true},
        {text: '感謝します!', fontSize: 18, bold: true},
        {text: '감사하다!', fontSize: 18, bold: true}
    ],
    defaultStyle: {
        //font: 'PingFangSC'
	    //font: 'SourceHanSerifSC'
	    font: 'SourceHanSansSC'
    }
}

let pdfDoc = printer.createPdfKitDocument(docDefination, {});
pdfDoc.pipe(fs.createWriteStream('test.pdf'));
pdfDoc.end();
```

#### Create PDF
```shell
cd ~/pdf-test
node index.js
```

It'll output `test.pdf`

## References
* [pdfmake doc](https://pdfmake.github.io/docs/0.1/)
* [GENERATE PDF FILES USING NODEJS AND PDFMAKE](https://xlinesoft.com/blog/2022/11/05/generate-pdf-files-using-nodejs-and-pdfmake/)
* [Working with PDF in Node.JS (pdfmake)](https://tech.bloggernepal.com/2021/12/working-with-pdf-in-nodejs-pdfmake.html)
* [Generating Complex PDF files with Node.js and PDFMake](https://www.appgambit.com/blog/nodejs-with-pdfmake)
* [Source Han Serif 思源宋体](https://source.typekit.com/source-han-sans/cn/)
* [Source Han Serif](https://github.com/adobe-fonts/source-han-serif)
* [Source Han Sans](https://github.com/adobe-fonts/source-han-sans/)
* [Adobe Font Development Kit for OpenType (AFDKO)](https://github.com/adobe-type-tools/afdko/)
* [如何评价思源宋体（Source Han Serif）字族？](https://www.zhihu.com/question/58002706)
* [思源黑体版本指南](https://zhuanlan.zhihu.com/p/526734630)
* [思源黑体 (Source Han Sans) 的各个版本有什么不同？](https://www.zhihu.com/question/24639343)
* [What's the Difference Between TrueType and OpenType Fonts?](https://www.high-logic.com/font-editor/fontcreator/tutorials/the-difference-between-truetype-and-opentype-fonts)
* [如何打包或解包 TrueType Collection (TTC) 文件？](https://www.zhihu.com/question/24071424)
* [Adding page breaks in the doc definition #25](https://github.com/bpampuch/pdfmake/issues/25)
* [Build Source Han Serif Font from Source on macOS for China User](https://github.com/northbright/Notes/blob/master/font/build-source-han-serif-font-from-source-on-macos-for-china-user.md)
* [Build Source Han Sans Font from Source on macOS for China User](https://github.com/northbright/Notes/blob/master/font/build-source-han-sans-font-from-source-on-macos-for-china-user.md)
* [Use otf2otc to Build ttc from Mutiple otfs](https://github.com/northbright/Notes/blob/master/font/use-otf2otc-to-build-ttc-from-mutiple-otfs.md)
