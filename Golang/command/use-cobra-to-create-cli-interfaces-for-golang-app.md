# Use Cobra to Create CLI Interfaces for Golang App

## Install Cobra
* Install Latest [Golang](https://golang.org)
  * [Set Golang Development Environment on Mac OS X in China](https://github.com/northbright/Notes/blob/master/Golang/Install/setup-golang-dev-env-on-mac-os-x.md)

* Get [Cobra](https://github.com/spf13/cobra) Package

  ```
  go get -u github.com/spf13/cobra
  ```

* Check
  
  ```
  which cobra
  // Output:
  /Users/XX/go/bin/cobra
  ```

  ```
  cobra
  // Output:
  // Cobra is a CLI library for Go that empowers applications.
  // This application is a tool to generate the needed files
  // to quickly create a Cobra application.
  // ......
  ```

## Create a Demo Go Module(App)
```
mkdir ~/demo
cd ~/demo
go mod init
```

## Init Go Module with [Cobra](https://github.com/spf13/cobra) and [Viper](https://github.com/spf13/viper)
Use `cobra init` command to initialize a go module, run `cobra init -h` for more help

```
cd ~/demo
// Create a new app and use viper for configuration
cobra init --viper
```

It'll create `main.go` and `cmd/root.go`

## Custimze Root Command
* Go to `cmd/root.go` and find `rootCmd`, set `Short` / `Long` for brief / long description and implement the function for `Run`.

```
var rootCmd = &cobra.Command{
        Use:   "demo",
        Short: "my demo app",
        Long: `my demo app, used to demo how to use cobra
to create CLI interfaces for Golang app.
        // Uncomment the following line if your bare application
        // has an action associated with it:
        Run: func(cmd *cobra.Command, args []string) {
                fmt.Printf("Hello World!\n")
        },
}
```

* Check
```
go run main.go
```

## Create a Sub Command
Create a sub command(`new`) to create a text file.

```
cobra add create
```

Go to `cmd/create.go` to customize `createCmd`
* `Run` func: Write `Hello World!` to the created file
* `Args`: accept only 1 argument for the name of file to create
* Local Flag: `--name` / `-n`: output name in the created file
  * If no name is specified, it'll read name in config file(default: $HOME/.demo.yaml) via Viper
  * Check the code of `init()` and `initConfig()` in `cmd/root.go`

```
package cmd

import (
        "fmt"
        "os"

        "github.com/spf13/cobra"
        "github.com/spf13/viper"
)

var name string

// createCmd represents the create command
var createCmd = &cobra.Command{
        Use:   "create",
        Short: "create a text file",
        Long: `create a text file which contains "Hello NAME"
Name can be passed by argument '--name' / '-n',
if no name specified, it'll try to read the name in '$HOME/.demo.yml'`,
        Args: cobra.ExactArgs(1),
        Run: func(cmd *cobra.Command, args []string) {
                p := args[0]
                fmt.Printf("creating file %v...\n", p)
                f, err := os.Create(p)
                if err != nil {
                        fmt.Printf("Create file(%v) error: %v\n", p, err)
                        return
                }
                if len(name) == 0 {
                        // No name flag specified, try to read name from config file($HOME/.demo.yaml)
                        name = viper.GetString("name")
                        fmt.Printf("viper: read name in config file: %v\n", name)
                        // No name found in the config file, use everyone as name.
                        if len(name) == 0 {
                                name = "everyone"
                        }
                }
                s := fmt.Sprintf("Hello, %v\n", name)
                f.WriteString(s)
        },
}

func init() {
        rootCmd.AddCommand(createCmd)

        createCmd.Flags().StringVarP(&name, "name", "n", "", "name to say hello")
}
```

* Test

```
// Run create sub command with filename and name flag.
go run main.go create example.txt --name Frank
// Output:
Hello, Frank
```

```
// Create global config file and set name to Luke
echo "name: Luke" > ~/.demo.yaml
```

```
// Run create sub command without name flag(read name in config file)
go run main.go create example.txt
// Output:
Hello, Luke
```

## References
* [Golang | 使用 Cobra 构建命令行工具](https://www.jianshu.com/p/63dd2075eb22)
* [Using the Cobra Library](https://github.com/spf13/cobra/blob/master/user_guide.md#using-the-cobra-library)
