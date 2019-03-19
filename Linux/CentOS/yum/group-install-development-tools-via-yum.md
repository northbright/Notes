# Group Install "Development Tools" via yum

## Solution
* List Groups

      yum list group
      // Output:
      // ...
      // Development Tools
   If you use `ssh`, It may be localized string for "Development Tools"(e.g. "开发工具")

*  Group Install "Development Tools"

       sudo yum group install -y "Development Tools"
       
       // if you use ssh, use 开发工具 instead
       sudo yum group install -y 开发工具
