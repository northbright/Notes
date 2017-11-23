# Use `strings.SplitN` if Substring Contains Separator

#### Problem
* Want to use `:` as separator for **existing** strings: `Campus:Category:Period`
* 3rd part of the string is "period" which also contains the separator `:`
   `"新校区:高中:周六8:00-17:30"`

#### Solution
* Use [strings.SplitN](https://godoc.org/strings#SplitN) to specify the count of substrings(in this case is 3).

#### Example

```
package main

import (
	"fmt"
	"strings"
)

func main() {
	s := "新校区:高中:周六8:00-17:30"
	arr := strings.SplitN(s, ":", 3)
	for _, v := range arr {
		fmt.Printf("%v\n", v)
	}
}

// output:
//新校区
//高中
//周六8:00-17:30

```
