# [http.ServeMux](https://pkg.go.dev/net/http#ServeMux) Handles Method and Path-Parameter Routing Natively Since Go 1.22

## Example

```go
mux := http.NewServeMux()
mux.HandleFunc("GET /users", listUsers)
mux.HandleFunc("POST /users", createUser)
mux.HandleFunc("GET /users/{id}", func(w http.ResponseWriter, r *http.Request) {
    id := r.PathValue("id")
    // ...
})
```

## References
* [七、标准库优先：LLM 最容易漏掉的那部分知识](https://tonybai.com/2026/07/13/spf13-idiomatic-go/#%E4%B8%83%E6%A0%87%E5%87%86%E5%BA%93%E4%BC%98%E5%85%88llm-%E6%9C%80%E5%AE%B9%E6%98%93%E6%BC%8F%E6%8E%89%E7%9A%84%E9%82%A3%E9%83%A8%E5%88%86%E7%9F%A5%E8%AF%86)
