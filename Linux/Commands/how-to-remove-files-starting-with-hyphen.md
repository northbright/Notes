# How to Remove Files Starting with Hyphen

#### Problem
* Need to remove files starting with hyphen(e.g. `-myfile`)

#### Solutions

* Solution A
Use `rm -- FILENAME`

        // -- option tells rm to treat all further arguments as file names but not options.
        rm -- -myfile

* Solution B
Use `rm ./FILENAME`

        rm ./-myfile

#### References
* [How to remove files starting with double hyphen?](https://stackoverflow.com/questions/706196/how-to-remove-files-starting-with-double-hyphen)
