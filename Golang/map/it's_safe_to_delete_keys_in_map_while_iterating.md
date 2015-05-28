
# It's Safe to Delete Keys in map while Iterating

    for key := range m {
        if key.expired() {
            delete(m, key)
        }
    }

#### References
* <http://stackoverflow.com/questions/23229975/is-it-safe-to-remove-selected-keys-from-golang-map-within-a-range-loop> 