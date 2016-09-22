# iOS Excel App Can not Open File on OneDrive with 'User does not have access privileges' Error

#### Problems
* iOS Excel App can not open the excel files uploaded to OneDrvie.

#### Root Cause
* Maybe iOS Excel app cached login credentials of other Office 365 accounts.

#### Solution
* Delete the Login Credentials of iOS Excel App
    1. Goto iOS Settings
    2. Find "Excel" App
    3. Enable "Delete Login Credentials"
    4. Close "Excel" App - Press Home button twice and swipe "Excel" screen up.
    5. Restart "Excel" App

#### Reference
* [Office for iPad - "Word cannot open the document: user does not have access privileges"](http://answers.microsoft.com/en-us/msoffice/forum/msoffice_word-mso_imobile/office-for-ipad-word-cannot-open-the-document-user/4f48b09f-5d28-4e2a-8aea-5024fe3de819)
