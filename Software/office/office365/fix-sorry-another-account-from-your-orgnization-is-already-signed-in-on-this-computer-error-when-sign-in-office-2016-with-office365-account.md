# Fix "Sorry, another account from your organization is already signed in on this computer" in Office 2016

## Problem
* Got error while sign in Office 2016 with Office 365 account

  > "Sorry, another account from your organization is already signed in on this computer"

## Solution
* Open Excel / Word > "account" > sign out all accounts
* Modify Registry
  * Run "Regedit"
    * Win + R > type "regedit"
  * Goto `HKEY_CURRENT_USER\Software\Microsoft\Office\15.0\Common\Identity\Identities`
  * Delete office account you don't need
  * Also Delete the account data under "Profiles"
* Control Panel Settings
  * Goto "Control Panel" > "Credentials Managers" > "Windows Credentials" > "Generic Credentials"
  * Remove the credentials related to Office accounts of others
* Reboot
* Open Excel / Word > Sign in again

## References
* ["Sorry, another account from your organization is already signed in on this computer" in Office 2013](https://docs.microsoft.com/en-us/office/troubleshoot/office-suite-issues/another-account-already-signed-in)
* ["很抱歉，您的组织中的另一个帐户已登录此计算机" Office 2013](https://docs.microsoft.com/zh-cn/office/troubleshoot/office-suite-issues/another-account-already-signed-in)
