# Get Font Name in CIDFont File

## Problem
* Use [afdko](https://github.com/adobe-type-tools/afdko/) to build [Source Han Serif](https://github.com/adobe-fonts/source-han-serif) from source
* Need to know the font name when build OTF

## Solution
Find `CIDFontName` in `cidfont` file.

e.g. for language-specific font, check `Masters/XX/OTC/cidfont.ps.OTC.SC` where XX is weight.

```shell
vi Masters/Regular/OTC/cidfont.ps.OTC.SC
```

```shell
14 dict begin
/CIDFontName /SourceHanSerifSC-Regular def
......
end def
```

`SourceHanSerifSC-Regular` is the font name.
