# Change Code Page of CMD to ANSI

## Solution
* Use `CHCP` command to change code page to `1252`(ANSI Latin-I):

       // Example
       // Change code page to ANSI and run NET VIEW
       cmd.exe /c CHCP 1252 & NET VIEW

## References
* [How to change the codepage for DOS batch files to ANSI](http://www-01.ibm.com/support/docview.wss?uid=swg21562473)

