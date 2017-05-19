# Unescape HTML String

#### Problem
* We get esacped strings(e.g. `&#36716;&#23398;`,`&quot;`) while using regexp package to find sub strings in raw HTML.

#### Solution
* Use [UnescapeString](https://godoc.org/html#UnescapeString) to unescape the strings.

#### Example

    package main

    import (
        	"fmt"
        	"html"
    )

    func main() {
        	str := html.UnescapeString(`&#36716;&#23398;&#21040;&quot;&#20108;&#24180;&#32423;10&#29677;&quot;`)
     	        fmt.Printf(str)
    }


