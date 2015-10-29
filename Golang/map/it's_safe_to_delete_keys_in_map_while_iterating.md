
# It's Safe to Delete Keys in map while Iterating

    for key := range m {
        if key.expired() {
            delete(m, key)
        }
    }

See [For Statements in Go spec](https://golang.org/ref/spec#For_statements):  

* "The range expression is evaluated once before beginning the loop."
* "If map entries that have not yet been reached are deleted during
iteration, the corresponding iteration values will not be produced."

#### References
* <http://stackoverflow.com/questions/23229975/is-it-safe-to-remove-selected-keys-from-golang-map-within-a-range-loop>
* [deleting from a map](https://groups.google.com/forum/#!topic/golang-nuts/eJqwQLONhLs)
* <https://golang.org/ref/spec#For_statements>