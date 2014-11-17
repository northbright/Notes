
# Append a Whole Second Slice

We can use "..." notation to append a whole second slice to the exist slice by calling append().

    package main
    import "fmt"

    func main() {
        arr1 := []int{1,2}
        arr2 := []int{3,4}
        arr1 = append(arr1, arr2...)  // must add "..." after second array
        fmt.Println(arr1)
    }

* reference  
  <http://blog.golang.org/slices>