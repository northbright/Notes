# Doc Links in Go Comments

## Refer to exported idendifiers in current packages
```go
[Name] or [Name1.Name2]
```

## Refer to exported identifiers in other packages
```go
[pkg.Name] or [pkg.Name1.Name2]
```

## Examples

```go
// CommandContext converts a [Cmd] to an [os/exec.Cmd].
func CommandContext(ctx context.Context, cmd Cmd) (*exec.Cmd, error) {
    ......
}
```

## References
* [Doc links](https://go.dev/doc/comment#doclinks)
