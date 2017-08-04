# Check if a Rune is Chinese Character

#### Problem
* Username can contain Latin and Chinese character.
* Each Chinese character's length is recognized as 2.
* Because the font width of Chinese character is 2x than Latin(number) in most case.
        
        e.g.
        "中文汉字" -> 4 Chinese Characters: display width = 8
        "abcd1234" -> 8 Latin chars and numbers mixed: display width = 8.5      

* Need to calculate the total length of username.
* Need to check if a UTF-8 Rune is Chinese character.

#### Solution
* Use `unicode.Is(unicode.Scripts["Han"], r) in for...range`

#### Example

```
for _, r := range username {
		switch {
		case unicode.Is(unicode.Scripts["Han"], r):
			l += 2
		default:
			l++
		}
}
```

#### References
* [golang - 如何判断字符是不是中文？](https://segmentfault.com/q/1010000000595663)
* [为什么淘宝和京东会员注册的时候用户名一个汉字算两个字符，有什么考虑吗？](https://www.zhihu.com/question/22295828/answer/82576462)
* <https://github.com/northbright/validate>
