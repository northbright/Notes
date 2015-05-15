
# 1s Letter of Interface Function Name Should be Uppercase if You Want Other Packages Use it

    type MyProcessor interface {
        // not exported to permit access from other packages.
        // This means it can't implement this function from other packages.
        onError()
                   
        // It's OK for other packages to implemnt this function / interface
        OnError()
    }

#### References
* <https://golang.org/ref/spec#Exported_identifiers>