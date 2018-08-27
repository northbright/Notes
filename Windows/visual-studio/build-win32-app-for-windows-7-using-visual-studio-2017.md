# Build Win32 App(C++) for Windows 7 on Visual Studio 2017 Community
  
## Steps
1. Install Visual Studio 2017 Community
   * Check "C++" Desktop App Developement
   * Check "Windows 8.1 SDK and UCRT SDK" in "Installation Details"
     * Windows 8.1 SDK is backward compatible to Windows 7

2. [Modifying WINVER and _WIN32_WINNT](https://msdn.microsoft.com/en-us/library/6sehtctf.aspx)
     define `WINVER` and _`WIN32_WINNT` before `#include <windows.h>`

     ```
      // MyApp.cpp
      // define WINVER and _WIN32_WINNT before #include <windows.h>
      
      #define WINVER 0x0601
      #define _WIN32_WINNT 0x0601

      #include <windows.h>
      ......

      // Libraries to link
      #pragma comment(lib, "xx.lib")
  
   ```

3. Disable `Precompiled Headers`
    `Project` -> `Properties` -> `C/C++` -> `Precompiled Headers` -> `Not Using Precompiled Headers`

4. Disable `Conformance Mode`
    `Project` -> `Properties` -> `C/C++` -> `Language` -> `Conformance Mode` -> `No`

6. Select `Windows 8.1 SDK` as `Windows SDK Version`
    `Project` -> `Properties` -> `Gerneral` -> `Windows SDK Version` -> `8.1`

## References
* [Change target platform version to Windows 7](https://social.msdn.microsoft.com/Forums/vstudio/en-US/08aaf316-f901-4385-82b2-537c2f6b2cde/change-target-platform-version-to-windows-7)
* [Error C2760 in combaseapi.h with Windows SDK 8.1 and compiler flag /permissive-](https://developercommunity.visualstudio.com/content/problem/185399/error-c2760-in-combaseapih-with-windows-sdk-81-and.html)
* [What is _WIN32_WINNT and how does it work?](https://stackoverflow.com/questions/15111799/what-is-win32-winnt-and-how-does-it-work)
