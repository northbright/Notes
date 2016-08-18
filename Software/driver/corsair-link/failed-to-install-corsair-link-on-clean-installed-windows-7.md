# Failed to Install Corsair Link on Clean Installed Windows 7

#### Problem
* It failed to install [Corsair Link](http://www.corsair.com/linksw) after we did a fresh installation of Windows 7.

#### Root Cause
* Corsair Link requires [.NET Framework](https://www.microsoft.com/net/) 4.5 or later.
* Latest Corsair Link(4.2.3.41) won't check if .Net Framework is installed or not.
* Clean installed Windows 7 need to run Windows Update to get .NET framework 4.5 and later version.

#### How to Fix
* Download latest [.NET Framework](https://www.microsoft.com/net/)
* Run "Windows Update" to get patches on latest [.NET Framework](https://www.microsoft.com/net/)

