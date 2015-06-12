
# Show Code Blocks in godoc

To use code blocks in godoc, add an extra indent to your comment's text.

    // New creates a new logger.
    //
    //   Params:
    //       debug - address of the boolean flag to enable / disable output debug messages.
    //   Return:
    //       *log.Logger. You can use all log.Logger print functions like Printf(), Println()...
    func New(debug *bool) *log.Logger {

#### References
* <https://godoc.org/github.com/fluhus/godoc-tricks>
* <http://golang.org/pkg/go/doc/#ToHTML>