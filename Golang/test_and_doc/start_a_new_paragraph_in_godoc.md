
# Start a New Paragraph in godoc

To start a new paragraph, add an empty line in the comment between the 2 paragraphs.

    /*
    package dbglog implments the writer of log.Logger with these features:
    
    * Follow log to make the debug message thread safe in defferent goroutines while output to the same writer(eg: os.Stdout).
    
    * Use a boolean flag to control if output debug message or not at runtime.

    * Show function name in debug message.
    */

or 

    // MyFunc is ....
    //
    // It ....
    Func MyFunc() {}
#### References
* <https://godoc.org/github.com/fluhus/godoc-tricks>