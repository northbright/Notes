
#  Edit Ntuser.dat Hive to Set Default Reg Keys for Different Users

Modifying Ntuser.dat hive so new users get defined settings(Ex: Mouse Speed)

#### Sample CMD
This will set default mouse speed from 10 to 20 for each user.

    echo Load HKEY_USERS\TempHive
    reg load HKEY_USERS\TempHive "C:\Users\Default\NTUSER.DAT"
    echo Change Control Panel\Mouse\MouseSensitivity from 10 to 20
    reg add "HKEY_USERS\TempHive\Control Panel\Mouse" /v "MouseSensitivity" /t REG_SZ /d 20 /f
    echo Unload HKEY_USERS\TempHive
    reg unload HKEY_USERS\TempHive

#### References
* [Modifying Ntuser.dat Hive So New Users Get Defined Settings](https://support.microsoft.com/en-us/kb/146050)
* [How to make changes to the default users hive as a post deployment task](http://www.itninja.com/blog/view/how-to-make-changes-to-the-default-users-hive-as-a-post-taks)