# Get Local Location in Golang

#### Problem
* Get local [Location](http://godoc.org/time#Location) in Golang

#### Solution
# Use [LoadLocation](http://godoc.org/time#LoadLocation) with `"Local"` parameter:

        loc, _ := time.LoadLocation("Local")

#### References
* [LoadLocation](http://godoc.org/time#LoadLocation)

