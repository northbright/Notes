# Show Complete Usage for "h" or "help"

## Problem
* When run the program with "-h" or "--help", it calls `flag.PrintDefaults()` to displays default values of all defined command-line flags in the set.
* Want to add more details in the usage when "-h" or "--help" is set. 

## Solution
* Define "h" flag to override default one.
* When "h" is set, display your own usage.

## Example
```
        usage := "Usage:\nhashgo [-md5 | -sha1 | -sha256 | -sha512] [File]...\n"

        // Initialize help arguments.
        h := flag.Bool("h", false, "this help")

        // Initialize other arguments.
        ......

        // Parse flags.
        flag.Parse()

        // Show usage for "-h" or "--help"
        if *h {
                fmt.Println(usage)
                flag.PrintDefaults()
                return
        }

```

## Reference
* [golang flag包使用笔记](https://www.jianshu.com/p/f9cf46a4de0e)
