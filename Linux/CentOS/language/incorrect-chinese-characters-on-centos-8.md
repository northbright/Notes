# Incorrect Chinese Characters on CentOS 8

## Background
* Clean installed CentOS 8
* Use default language(EN)
* Minimal Install
* Set timezone to `Asia/Shanghai`

## Problem
* It displays Chinese characters incorrectly in `vim`, `git`...
* It reports errors when run `locale` command:
   > locale: Cannot set LC_CTYPE to default locale: No such file or directory
locale: Cannot set LC_MESSAGES to default locale: No such file or directory
locale: Cannot set LC_ALL to default locale: No such file or directory

## Root Cause
* Not all language packages are installed by default on CentOS 8
* Need to install langpack for Chinese(zh_CN)
* Currently, all locales are stored in the `/usr/lib/locale/`

## Solution
Install langpacks for your language

* Method A - Install `glibc-langpack-<locale_code>` package
  * It'll install locales to `/usr/lib/locale`
  * Example: install langpacks for Chinese

    ```
    sudo yum install glibc-langpack-zh
    ```

* Method B(recommended) - Install `langpacks-<locale_code>` package
  * It includes `glibc-langpack-<locale_code>`
  * And provides more extra packages(e.g. for libreoffice)

    ```
    yum repoquery --whatsupplements langpacks-zh_CN

    // Output:
    glibc-langpack-zh-0:2.28-72.el8.x86_64
    glibc-langpack-zh-0:2.28-72.el8_1.1.x86_64
    libreoffice-langpack-zh-Hans-1:6.0.6.1-19.el8.x86_64
    tesseract-langpack-chi_sim-0:4.0.0-6.el8.noarch
    tesseract-langpack-chi_sim_vert-0:4.0.0-6.el8.noarch
    ```

  * Example: install langpacks for Chinese
    * List available langpacks or search the langpack for your language
 
      ```
      // List
      yum list available langpacks*

      // or Search
      yum search Chinese

      // Output:
      langpacks-zh_CN.noarch
       ```

    * Install

      ```
      sudo yum install langpacks-zh_CN.noarch
      ```

## References
* [Chapter 10. Using langpacks](https://access.redhat.com/documentation/en-us/red_hat_enterprise_linux/8/html/configuring_basic_system_settings/using-langpacks_configuring-basic-system-settings#checking-languages-that-provide-langpacks_using-langpacks)
* [CentOS8 试用结论](https://segmentfault.com/a/1190000021559967)
