# Disable Origin Check in [gorilla/websocket](https://github.com/gorilla/websocket/)

## Problem
* Need to debug websocket from other origins

  Start a front-end development server by running [`quasar dev`](https://quasar.dev/quasar-cli/cli-documentation/commands-list#dev)

## Solution
* [Implement the `CheckOrigin` func in [Upgrader](https://godoc.org/github.com/gorilla/websocket#Upgrader)
* Return `false` in `CheckOrigin`  func

## Example

```
// Modify https://github.com/gorilla/websocket/blob/master/examples/chat/client.go
var upgrader = websocket.Upgrader{
        ReadBufferSize:  1024,
        WriteBufferSize: 1024,
        // Add a `CheckOrigin` function, return true to disable origin check.
        CheckOrigin:     func(*http.Request) bool { return true },
}
```

## References
* [Origin Considerations](https://godoc.org/github.com/gorilla/websocket#hdr-Origin_Considerations)
* [client.go of examples/chat](https://github.com/gorilla/websocket/blob/master/examples/chat/client.go)

