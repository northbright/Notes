# Generate CSV File on Linux and Use Excel to Open it On Windows

## Background
* Using Golang program to output data(using `,` as dilimiter) to stdout and save them in a simple CSV file
   ```
   ./MyApp > data.csv
   
   Student Name, ID, PhoneNum
   John, 310104198002010000, 13800138000
   Mary, 310104198101010000, 13600136000
   ```
* Want to open the CSV in Excel 2007 on Windows
   
## Problem
* Use Excel 2007 to open the CSV directly will fail to recognize the UTF-8 encoding

## Solution
* Run `unix2dos` to convert line breaks
   ```
  unix2dos data.csv
  ```

* Rename `data.csv` to `data.txt`
* Open the `data.txt` via `Notepad`
* Save as the `data.txt` with `UTF-8 encoding` option
  * Find "Tools" at right-bottom -> "Web Options" -> "Encoding" Tab
* Create a **new** Excel File
* Goto "Data" tab > "From Text" > Select your text file
  * Select "Using delimiter" option  for "Data type"
  * Click "next"
  * Select the "delimiter"(e.g. `","`)
  * Click "next"
  * Select "column data format" for each column
     * Set it to `"Text"` for the long number text such as ID Card Number
  * Click "Done"
