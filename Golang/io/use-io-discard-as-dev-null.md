# Use io.Discard as /dev/null

## Problem
* Need a writer to write to /dev/null in Go

## Solution
Use [io.Discard](https://pkg.go.dev/io#Writer): a Writer on which all Write calls succeed without doing anything.
