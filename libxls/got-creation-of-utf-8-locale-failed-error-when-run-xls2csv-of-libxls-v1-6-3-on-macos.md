# Got "creation of UTF-8 locale failed" Error when Run xls2csv of libxls v1.6.3 on macOS

## Update
* Created an issue: [Got "creation of UTF-8 locale failed" when run "xls2csv" to convert an UTF-8 encoded XLS #151](https://github.com/libxls/libxls/issues/151)
* Created a [PR](https://github.com/libxls/libxls/commit/ffe363c42887eab96a30d20a3dd3eb6e99cce7e7) and it was merged

## Problem
* Download [latest release(v1.6.3)](https://github.com/libxls/libxls/releases/download/v1.6.3/libxls-1.6.3.tar.gz) of [libxls](https://github.com/libxls/libxls)
* Compile libxls on macOS(Sonoma 14.0, iMac, Intel i7) without [libiconv](https://www.gnu.org/software/libiconv/) installed

  ```
  ./configure
  make
  sudo make install
  ```

* Create an UTF-8 encoded XLS looks like:

  | English | Chinese | Japanese |
  | :--: | :--: | :--: |
  | Hello | 你好 | こんにちは |
  | Goodbye | 再见 | さようなら |

* Run `xls2csv` to convert an UTF-8 encoded XLS file to CSV

  ```sh
  xls2csv hello-goodbye.xls
  ```

* It failed to show the UTF-8 string and got error:

  > creation of UTF-8 locale failed
  > "*failed to decode utf16*"

## Root Cause
* [unicode_decode()](https://github.com/libxls/libxls/blob/v1.6.3/src/xlstool.c#L351) calls [xls_createlocale](https://github.com/libxls/libxls/blob/v1.6.3/src/locale.c#L35) if [libiconv](https://www.gnu.org/software/libiconv/) is not installed when compiling libxls.

```c
// Convert unicode string to the encoding desired by the workbook
char* unicode_decode(const char *s, size_t len, xlsWorkBook *pWB)
{
#ifdef HAVE_ICONV
#if defined(_AIX) || defined(__sun)
    const char *from_enc = "UTF-16le";
#else
    const char *from_enc = "UTF-16LE";
#endif
    if (!pWB->utf16_converter) {
        iconv_t converter = iconv_open(pWB->charset, from_enc);
        if (converter == (iconv_t)-1) {
            printf("conversion from '%s' to '%s' not available\n", from_enc, pWB->charset);
            return NULL;
        }
        pWB->utf16_converter = (void *)converter;
    }
    return unicode_decode_iconv(s, len, pWB->utf16_converter);
#else
    if (!pWB->utf8_locale) {
        xls_locale_t locale = xls_createlocale();
        if (locale == NULL) {
            printf("creation of UTF-8 locale failed\n");
            return NULL;
        }
        pWB->utf8_locale = (void *)locale;
    }
    return unicode_decode_wcstombs(s, len, pWB->utf8_locale);
#endif
}

```

* [xls_createlocale](https://github.com/libxls/libxls/blob/v1.6.3/src/locale.c#L35) calls `newlocale(LC_CTYPE_MASK, "C.UTF-8", NULL)` on macOS

```c
xls_locale_t xls_createlocale(void) {
#if defined(_WIN32) || defined(WIN32) || defined(_WIN64) || defined(WIN64) || defined(WINDOWS)
    return _create_locale(LC_CTYPE, ".65001");
#else
    return newlocale(LC_CTYPE_MASK, "C.UTF-8", NULL);
#endif
}
```

* It fails on macOS Sonoma 14.0 due to "C.UTF-8" is not found

## Solution
* Method A: Install libiconv on macOS
  * [Install libiconv from Source on macOS](https://github.com/northbright/Notes/blob/master/libiconv/install-libiconv-from-source-on-macos.md)

* Method B: Use "UTF-8" instead of "C.UTF-8" when call `newlocale()` on macOS

  ```c
  xls_locale_t xls_createlocale(void) {
  #if defined(_WIN32) || defined(WIN32) || defined(_WIN64) || defined(WIN64) || defined(WINDOWS)
      return _create_locale(LC_CTYPE, ".65001");
  #elif defined(__APPLE__)
      return newlocale(LC_CTYPE_MASK, "UTF-8", NULL);
  #else
      return newlocale(LC_CTYPE_MASK, "C.UTF-8", NULL);
  #endif
  }
  ```

## References
* [GNU gettext utilities: AM_ICONV](https://getdocs.org/Gettext/docs/latest/AM_005fICONV)
* [locale.getdefaultlocale() fails on Mac OS X with default language set to English](https://bugs.python.org/issue18378#msg215215)
