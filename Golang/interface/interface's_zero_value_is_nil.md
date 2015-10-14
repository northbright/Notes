
# Interface's Zero Value is nil

#### For Example

    package main

    import "fmt"

    type Human interface {
        GetName() string
        GetAge() int
    }

    func f1() {
        var h Human  // h will be intialized with zero value(nil).
        fmt.Printf("h = %v, h is nil: %v\n", h, h == nil)
    }

    func f2() (h *Human) {
        return  // naked return h which is initialized with zero value(nil).
    }

    func main() {
        f1()
        h := f2()
        fmt.Printf("h = %v, h is nil: %v\n", h, h == nil)
    }


#### Go Playground

* <http://play.golang.org/p/ViyPYe43lS>

#### References

* [Named Return Values](https://tour.golang.org/basics/7)
* [Zero Values](https://tour.golang.org/basics/12)

