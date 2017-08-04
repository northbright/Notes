# Why Chinese Charater's length is 2 in Username

#### Root Cause
* Each Chinese character's length is recognized as 2.
* Because the font width of Chinese character is 2x than Latin(number) in most case.
    
        // e.g.
        // "中文汉字" -> 4 Chinese Characters: display width = 8
        // "abcd1234" -> 8 Latin chars and numbers mixed: display width = 8.5

#### References
* [为什么淘宝和京东会员注册的时候用户名一个汉字算两个字符，有什么考虑吗？](https://www.zhihu.com/question/22295828/answer/82576462)
* <https://github.com/northbright/validate>
