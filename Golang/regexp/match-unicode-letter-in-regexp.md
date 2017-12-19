# Match Unicode Letter in regexp

#### Problem
* Username can contain not only latin letter but Unicode letter(Chinese, Japanese...).
* Need to validate Unicode letter using regexp.

#### Solution
* Use `\p{L}` for Unicode letter class

#### Example
```
package main

import (
	"fmt"
	"regexp"
)

func ValidUsername(username string) bool {
	p := `^(?:\p{L}|\d|-|_){4,64}$`
	re := regexp.MustCompile(p)
	return re.MatchString(username)
}

func main() {
	usernames := []string{
		"世界空明大千",
		"Michael_01",
		"TrueBlueFragment-色褪せぬ蒼青の欠片",
	}

	for _, v := range usernames {
		fmt.Printf("%v: %v\n", v, ValidUsername(v))
	}
        // Output:
        // 世界空明大千: true
        // Michael_01: true
        // TrueBlueFragment-色褪せぬ蒼青の欠片: true
}

```

#### References
* [Syntax](https://godoc.org/regexp/syntax#hdr-Syntax)
* <https://github.com/google/re2/wiki/Syntax>
* [Golang regexp with non-latin characters](https://stackoverflow.com/questions/30482793/golang-regexp-with-non-latin-characters)
