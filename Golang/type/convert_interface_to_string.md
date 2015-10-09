# Convert Interface Type to String Type in Golang

#### Use Type Assertions(`x.(T)`):

    if str, ok := v.(string); !ok {
        // not string
    } else {
        // string
    }

#### References:
* [cannot convert data (type interface {}) to type string: need type assertion](http://stackoverflow.com/questions/14289256/cannot-convert-data-type-interface-to-type-string-need-type-assertion)