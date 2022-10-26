# Use [Hugo Module](https://gohugo.io/hugo-modules/) to Import Theme

## Hugo Theme Module
* Hugo Modules are powered by Go Modules
* Themes can be imported and used as Hugo Modules

## Steps
* Install [Go](https://golang.org)
  
  * [Set Golang Development Environment on Mac OS X in China](https://github.com/northbright/Notes/blob/master/Golang/Install/setup-golang-dev-env-on-mac-os-x.md)  
* Install [Hugo](https://gohugo.io/)

  * [Install Hugo from Source and Run Hugo Site on Ubuntu](https://github.com/northbright/Notes/blob/master/hugo/install-hugo-from-source-and-run-hugo-site-on-ubuntu.md)

* Create main project dir

  ```
  cd ~/
  mkdir mysite
  ```

* Initalize our main project(site) as Hugo Module too

  ```
  cd ~/mysite
  hugo mod init github.com/YOUR_USER/mysite
  ```

* Import the theme as Hugo Module

  * Make sure the theme to import is a Hugo Module

    * If the theme is a Hugo Module, `go.mod` should be in the repo root.
    * e.g. <gitlab.com/kaushalmodi/hugo-mwe-theme>

  * Create `config.yml` and add the `module` section

    ```
    module:
      imports:
      - path: gitlab.com/kaushalmodi/hugo-mwe-theme
    ```

  * Clean & Update the module

    ```
    hugo mod tidy
    ```
* Start the server and test

  ```
  hugo server
  // Output:
  // Web Server is available at //localhost:1313/ (bind address 127.0.0.1)
  // ...
  ```

  Visit `localhost:1313` in the browser and check

## References
* [Hugo Modules: Getting Started](https://scripter.co/hugo-modules-getting-started/)
* [Hugo Modules: Importing a Theme](https://scripter.co/hugo-modules-importing-a-theme/)
