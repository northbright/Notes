# Remove Lync Client Cache

#### Problem
Can't login Lync client while something on Lync server were changed.

#### Root Cause
Lync client still retrieve information from local cache.

#### Solution
Remove Lync client cache and re-add account.

1. Delete the SIP profile
  * The SIP folder has the prefix `sip_`

  * Lync 2010  
    `%UserProfile%\AppData\Local\Microsoft\Communicator\`

  * Lync 2013
    `%UserProfile%\AppData\Local\Microsoft\Office\15.0\Lync`

  * Skype for Business
    `%UserProfile%\AppData\Local\Microsoft\Office\16.0\Lync`

2. Reset PC and Restart Lync

3. Re-Add Your Account with Email Address and Password



#### References
* [Delete the Lync SIP profile from a Windows computer](https://chinookcommunications.zendesk.com/hc/en-us/articles/203814180-Delete-the-Lync-SIP-profile-from-a-Windows-computer)