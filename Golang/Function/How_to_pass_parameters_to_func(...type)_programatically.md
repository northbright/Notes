
# How to Pass Parameters to a func(...type) Programmatically

Sometimes, you need to pass parameters to a function with variadic parameter.  
Ex:  
`func (j *Json) GetPath(branch ...string) *Json`

You may pass a xxx slice with "..." suffix to the function:  

        
        func f(args ...string) {
            fmt.Println(args)
        }

        a := []string{"p1", "p2"}
        f(a...)

For more, see:  
<http://stackoverflow.com/questions/12907653/what-is-difference-between-string-and-string-in-golang>