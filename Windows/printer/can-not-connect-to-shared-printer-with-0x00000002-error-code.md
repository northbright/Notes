# Can not Connect to Shared Printer with 0x00000002 Error Code

## Problem
* One PC installed Epson 730KII printer and shared it to other PCs
* Other PCs connected to the printer successfully and worked well
* Suddenly, the shared printer were **OFF-LINE**
* Delete the shared printer and try to re-connect / add the shared printer
* It failed to connect to the shared printer with **0x00000002** error code

## Solution
* Right click "Computer" > "Management" > "Services and Applications" > "Services"
* Find **"Print Spooler"** Service and **Restart** it
