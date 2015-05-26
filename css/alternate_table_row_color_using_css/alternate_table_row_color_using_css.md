
# Alternate Table Row Color Using CSS

Use `tr:nth-child(even) or tr:nth-child(odd)` CSS pseudo-selector:

    tr:nth-child(even) {
        background-color: #000000;
    }

#### Example

[sample.html](./sample.html)  

    <html>
    <head>
      <meta charset="UTF-8">
      <link href="./mytable.css" rel="stylesheet" />
    </head>
    
    <body>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Count</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>iPhone 4S 8 GB</td>
          <td>10</td>
        </tr>
        <tr>
          <td>iPhone 5S 32 GB</td>
          <td>20</td>
        </tr>
      </tbody>
    </table>
    </body>

[mytable.css](./mytable.css)  

    table {
        border-collapse: collapse;
        width: 100%;
    }
    
    table, th, td {
       border: 1px solid #DDDDDD;
       color: #333333;
       padding-top: 5px;
       padding-bottom: 5px;
       padding-left: 5px;
    }
    
    th {
        text-align: left;
        background-color: #F8F8F8;
    }
    
    tr:nth-child(even) {
        background-color: #F8F8F8;
    }

#### Reference

* <http://stackoverflow.com/questions/3084261/alternate-table-row-color-using-css>