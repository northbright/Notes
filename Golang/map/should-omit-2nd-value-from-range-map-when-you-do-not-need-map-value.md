# Should Omit 2nd Value from `range` Map when You Do not Need map Value  

#### Problem
* Only need keys when `range` map:

        for k, _ := range myMap {
            ......
        }
* Get golint warnning:

        should omit 2nd value from range; this loop is equivalent to `for k := range ...`

#### Solution
* Omit 2nd value from range.

        for k := range myMap {
            ......
        }
