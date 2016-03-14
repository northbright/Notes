# Golang Static File Server


    func main() {
	    // Serve Static Files
	    http.Handle("/static/", http.StripPrefix("/static/", http.FileServer(http.Dir(staticFolderPath))))

	    fmt.Printf("Starting server...\nstatic folder abs path: %v\n", staticFolderPath)
	    if err := http.ListenAndServe(":80", nil); err != nil {
		    log.Fatal(err)
	    }
    }

#### Example
* [https://github.com/northbright/go-static-file-server-example](https://github.com/northbright/go-static-file-server-example)

#### References
* [Serve homepage and static content from root](http://stackoverflow.com/questions/14086063/serve-homepage-and-static-content-from-root)
