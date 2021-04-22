# Force Uninstall Edge on Windows 10

## Solution
* Goto `C:\Program Files (x86)\Microsoft\Edge\Application`
* Find the `xx.xx.xx` folder which its name is the version
* Enter `xx.xx.xx` and copy the full path in the address bar:

  `C:\Program Files (x86)\Microsoft\Edge\Application\xx.xx.xx`
* Run a CMD window as administrator
  * Press `Windows + R` to open a CMD window
  * Right click the icon and select "Run as Administrator"
* Type `cd` in the CMD window and paste the full path

  `cd C:\Program Files (x86)\Microsoft\Edge\Application\xx.xx.xx`
* Run the following command

  `setup.exe -uninstall -system-level -verbose-logging -force-uninstall`

## References
* [How to Uninstall Edge Chromium When Windows 10 Won't Let You](https://lifehacker.com/how-to-uninstall-edge-chromium-when-windows-10-wont-let-1844297854)
