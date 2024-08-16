# Use Optional Parameters for Function

## Problem
`Copier` needs 2 optional parameters: buffer Size, refresh rate.

```go
package util

type Copier struct {
    src string
    dst string
    onProgressUpdated func(total, copied uint64)
    bufSize uint
    refreshRate time.Duration
}

func New(
    src string,
    dst string,
    onProgressUpdated func(total, copied uint64),
    bufSize uint,
    refreshRate time.Duration,
) *Copier {
    ......
}
```

We have to pass `bufSize` and `refreshRate` to `New()` as mandatory parameters.

## Solution
Use `func(c *Copier)` as optional parameters.

```go
package util

type Copier struct {
    src string
    dst string
    onProgressUpdated func(total, copied uint64)
    bufSize uint
    refreshRate time.Duration
}

type Option func(c *Copier)

type BufSize func(size uint) func(c *Copier) {
    return func(c *Copier) {
        c.BufSize = size
    }
}

type RefreshRate func(rate time.Duration) func(c *Copier) {
    return func(c *Copier) {
        c.refreshRate = rate
    }
}

var (
    DefaultBufSize = 1024 * 64
    DefaultRefreshRate = 500 * time.Duration
)

func New(
    src string,
    dst string,
    onProgressUpdated func(total, copied uint64),
    options ...Option,
) *Copier {
    c := &Copier {
        src: src,
        dst: dst,
        onProgressUpdated: onProgressUpdated,
        bufSize: DefaultBufSize,
        refreshRate: DefaultRefreshRate, 
    }

    // Set optional parameters.
    for _, option := range options {
        option(c)
    }
}
```

```gp
// Create a Copier with default buffer size and refresh rate.
c := util.New(
    src,
    dst,
    myCallback,
)

// Create a Copier with specified buffer size.
c := util.New(
    src,
    dst,
    myCallback,
    BufSize(1024 * 1024),
)

// Create a Copier with specified refresh rate.
c := util.New(
    src,
    dst,
    myCallback,
    RefreshRate(80 * time.Millisecond),
)
```

## References
* [Functional options for friendly APIs](https://dave.cheney.net/2014/10/17/functional-options-for-friendly-apis)
