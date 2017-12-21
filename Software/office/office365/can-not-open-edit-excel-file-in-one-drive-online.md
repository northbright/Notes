# Can not Open and Edit Excel File in OneDrive(Office 365)  Online

#### Problem
* Failed to open the Excel file stored in OneDrive(Office 365) online
* It'll open it via local Excel app with **READ ONLY** mode

#### Root Cause
* The Excel file format is XLS(Excel 2003 - 2007) but **NOT** XLSX(Excel Workbook)

#### Solution
* Save the Excel file as XLSX and upload it to OneDrive
* Now it can be opened/ edited online

