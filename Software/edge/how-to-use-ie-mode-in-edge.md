# How to Use IE Mode in Edge

## Problem
* Some websites support IE only(e.g. Hikvision NVR web portal)
* IE was removed on latest Windows(Windows 11)

## Solution

#### Update: 2025/11/04
IE mode icon was removed in v142.0.3595.53

* Solution
  * Click "..." > Settings > Default browser > Internet Explorer compatibility or visit "edge://settings/defaultBrowser"
  * Internet Explorer Mode Pages > Add specific URLs manually
    Make sure the added URL are the **SAME** as the one you need to visit using IE mode. If the URL will be redirected after visit the original URL, use the redirected URL.

#### Update: 2025/10/06
* "Reload tab in Internet Explorer mode" is removed from the "..." menu in Edge v141.0.3537.57
* Need to add an IE mode "icon" on Toolbar
  * Turn on Settings > Appearance > Toolbar > Internet Explorer Mode(IE Mode)
  * The IE mode icon will be put on the right-top of the toolbar
* Click the IE mode icon to reload the tab in Internet Explorer mode

#### Visit / reload the websites in Internet Explorer Mode

* Goto "Settings" > "Default browser" > "Internet Explorer compatibility"
* "Allow sites to be reloaded in Internet Explorer mode" > "Allow"
* Restart Edge
* Visit the website and click the upper-right "..."(three dots) button
* Select "Reload tab in Internet Explorer mode"

#### To visit the websites in IE mode permanently, add the pages in settings
* Goto "Settings" > "Default browser" > "Internet Explorer compatibility"
* "Internet Explorer mode pages" > "Add" 

## References
* [How to Use Internet Explorer Mode in Edge](https://www.howtogeek.com/791890/how-to-use-internet-explorer-mode-in-edge/)
* [在 Internet Explorer 模式（IE 模式）下重新加载“允许”未显示？（需翻译日文为中文）](https://ilovetrend.hatenablog.com/entry/2025/10/06/122858)
* [微软为防范零日漏洞攻击，收紧 Edge 浏览器 IE 模式访问限制](https://m.ithome.com/html/889219.htm)
* [Reload in Internet explorer mode was just killed off?](https://learn.microsoft.com/en-gb/answers/questions/5607436/reload-in-internet-explorer-mode-was-just-killed-o)
* [MICROSOFT REVAMPS INTERNET EXPLORER MODE IN EDGE AFTER AUGUST ATTACKS](https://securityaffairs.com/183333/security/microsoft-revamps-internet-explorer-mode-in-edge-after-august-attacks.html)
* [MICROSOFT TIGHTENS IE MODE IN EDGE AFTER ATTACKS LEVERAGING CHAKRA ZERO-DAY](https://cybersecurefox.com/en/edge-restricts-ie-mode-after-chakra-zero-day-attacks/)
