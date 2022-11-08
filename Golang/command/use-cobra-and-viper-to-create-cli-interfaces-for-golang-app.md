# Use Cobra and Viper to Create CLI Interfaces for Golang App

## Install Cobra CLI
* Install Latest [Golang](https://golang.org)
  * [Set Golang Development Environment on Mac OS X in China](https://github.com/northbright/Notes/blob/master/Golang/Install/setup-golang-dev-env-on-mac-os-x.md)

* Get [cobra-cli](https://github.com/spf13/cobra-cli) command

  ```
  go install github.com/spf13/cobra-cli@latest
  ```

  Go will automatically install it in your `$GOPATH/bin` directory which should be in your `$PATH`.

* Check
  
  ```
  which cobra-cli

  // Output:
  /Users/XX/go/bin/cobra-cli
  ```

  ```
  cobra-cli
  // Output:
  // Cobra is a CLI library for Go that empowers applications.
  // This application is a tool to generate the needed files
  // to quickly create a Cobra application.
  // ......
  ```

## Create a Demo Go Module(App)
```
mkdir ~/cobra-viper-demo
cd ~/cobra-viper-demo
go mod init demo
```

## Init Go Module with [Cobra](https://github.com/spf13/cobra) and [Viper](https://github.com/spf13/viper)
Use `cobra init` command to initialize a go module, run `cobra init -h` for more help

```
cd ~/demo
// Create a new app and use viper for configuration
cobra-cli init --viper
```

It'll create `main.go` and `cmd/root.go`

## Implement Root Command
* Go to `cmd/root.go` and find `rootCmd`, set `Short` / `Long` for brief / long description and implement the function for `Run`.

```
var rootCmd = &cobra.Command{
        Use:   "demo",
        Short: "My demo app",
        Long: `My demo app, used to show how to create CLI interfaces for Golang apps using cobra and viper.

It outputs "Hello World!" for root command`,
        Run: func(cmd *cobra.Command, args []string) {
                fmt.Println("Hello World!")
        },
}
```

* Check
```
go run main.go
```

## Create a sub command: `demo goodbye [Name]`

```
cobra-cli add goodbye
```

Goto `cmd/goodbye.go` to implement `goodbyeCmd`

```
var goodbyeCmd = &cobra.Command{
        Use:   "goodbye [Name]",
        Short: "Say Goodbye",
        Long:  `Output "Goodbye, NAME"`,
        // goodbye command must have 1 arg: name to say goodbye.
        Args: cobra.ExactArgs(1),
        Run: func(cmd *cobra.Command, args []string) {
                name := args[0]
                fmt.Printf("Goodbye, %v\n", name)
        },
}
```

* Test

```
go run main.go goodbye Frank
// Output:
Goodbye, Frank
```

## Create another Sub Command with Flags: `demo goodnight [Name] --moon --sleepingface`

```
cobra-cli add goodnight
```

Goto `cmd/goodnight.go` to implement `goodnightCmd`

```
var (
        showMoon         bool
        showSleepingFace bool
)

var goodnightCmd = &cobra.Command{
        Use:   "goodnight [Name]",
        Short: "Say Goodnight",
        Long:  `Ouput "Goodnight, Name"`,
        // goodnight command must have 1 arg: name to say goodnight.
        Args: cobra.ExactArgs(1),
        Run: func(cmd *cobra.Command, args []string) {
                name := args[0]
                s := "goodnight, %v"
                if showMoon {
                        s += `🌙`
                }
                if showSleepingFace {
                        s += `😴`
                }
                s += "\n"
                fmt.Printf(s, name)
        },
}

func init() {
        rootCmd.AddCommand(goodnightCmd)

        goodnightCmd.Flags().BoolVarP(&showMoon, "moon", "m", false, "show moon emoji")
        goodnightCmd.Flags().BoolVarP(&showSleepingFace, "sleepingface", "s", false, "show sleeping face emoji")
}
```

* Test
```
go run main.go goodnight Frank --moon --sleepingface
// Output:
goodnight, Frank🌙😴
```

## Create another Sub Command with Flag which Can Be Read From Config File Using Viper: `demo hi [Name] --emoji [emoji]`

```
cobra-cli add hi
```

Goto `cmd/hi.go` to implement `hiCmd`

```
import (
        ...
        // Import viper
        "github.com/spf13/viper"
)

var (
        showSmilingFace bool
        emoji           string
)

var hiCmd = &cobra.Command{
        Use:   "hi [Name]",
        Short: "Say Hi",
        Long:  `Output "Hi, NAME"`,
        // hi command must have 1 arg: name to say hi.
        Args: cobra.ExactArgs(1),
        Run: func(cmd *cobra.Command, args []string) {
                name := args[0]
                // Emoji flag is not set(--emoji), read emoji from config file.
                // default config file: $HOME/.demo.yaml(set in initConfig() in cmd/root.go)
                if len(emoji) == 0 {
                        emoji = viper.GetString("emoji")
                }
                fmt.Printf("Hi, %v%v\n", name, emoji)
        },
}

func init() {
        rootCmd.AddCommand(hiCmd)

        hiCmd.Flags().StringVarP(&emoji, "emoji", "e", "", "Emoji to show")
}
```

* Download dependencies: viper
```
go mod tidy
```

* Init default config file:
```
echo "emoji: 🐱" > ~/.demo.yaml
```

* Test
```
// With --emoji flag
go run main.go hi Frank --emoji 😼
// Output:
Hi, Frank😼
```

```
// Without --emoji flag and read "emoji" from config file(`~/.demo.yaml`)
go run main.go hi Frank
// Output:
Hi, Frank🐱
```

## Source Code
* [cobra-viper-demo](https://github.com/northbright/cobra-viper-demo)

## References
* [Golang | 使用 Cobra 构建命令行工具](https://www.jianshu.com/p/63dd2075eb22)
* [Using the Cobra Library](https://github.com/spf13/cobra/blob/master/user_guide.md#using-the-cobra-library)
* [Cobra Generator](https://github.com/spf13/cobra-cli)
