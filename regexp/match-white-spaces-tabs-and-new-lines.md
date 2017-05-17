# Use `\s` to Match White Spaces, Tabs and New Lines

#### Example(written in [Golang](https://golang.org)

    package main

    import (
    	"fmt"
	"regexp"
    )

    var str = `
        <td>Comments
        </td>

         <td>

            Frank Xu, 
 
            Programming Languages:
            Golang, c

         </td>
    `

    func main() {
	    p := `<td>Comments\s*</td>\s*<td>((.|\s)*?)</td>`
	    re := regexp.MustCompile(p)
	    matched := re.FindStringSubmatch(str)
	    fmt.Printf("Comments: %v\n", matched[1])

	    // Output:
	    /* Comments:

	       Frank Xu,

	       Programming Languages:
	       Golang, c

	    */
    }

#### References
* [what does this ( \S ) regex mean in javascript?](http://stackoverflow.com/questions/4377480/what-does-this-s-regex-mean-in-javascript)
