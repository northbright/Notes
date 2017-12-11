# Sort Golang map by Values and Keys

#### Problem
* Need to sort Golang map by keys or values.

#### Solution
* Use [sort.Slice(require Go1.8)](https://godoc.org/sort#Slice)

#### Example

```
package main

import (
	"fmt"
	"sort"
)

type pair struct {
	key   string
	value int
}

func main() {
	var arr []pair

	m := map[string]int{
		"a": 2,
		"b": 1,
		"c": 3,
	}

	for k, v := range m {
		arr = append(arr, pair{k, v})
	}

	sort.Slice(arr, func(i, j int) bool {
		return arr[i].value < arr[j].value
	})

	for _, v := range arr {
		fmt.Printf("%v: %v\n", v.key, v.value)
	}

	// Output:
	// b: 1
	// a: 2
	// c: 3
}
```

[Playground](https://wide.b3log.org/playground/7a5f83a9ac8d2168ccbd5070ad4100b2.go)

#### References
* [How to sort a Map[string]int by its values?](https://stackoverflow.com/questions/18695346/how-to-sort-a-mapstringint-by-its-values)
* [map按key和按value排序](http://www.jianshu.com/p/01adb0e2a69f)
* <https://github.com/northbright/maphelper>
