# Output Colored Text to Terminal on Linux

## Solution
Use ANSI Color Codes to control the terminal text color.
There're 2 types of Codes: Format Codes and Color Codes.

1. Select format code

| Format | Code | Comment |
| :--: | :--: | :--: | 
| reset | 0 | everything back to normal |
| bold/bright | 1 | often a brighter shade of the same colour |
| underline | 4 | |
| inverse | 7 | swap foreground and background colours | |
| bold/bright off | 21 | |
| underline off | 24 | |
| inverse off | 27 | |

2. Select color code

| Color | Foreground Code | Background Code |
| :--: | :--: | :--: |
| black | 30 | 40 |
| red | 31 | 41 |
| green | 32 | 42 |
| yellow | 33 | 43 |
| blue | 34 | 44 |
| magenta | 35 | 45 |
| cyan | 36 | 46 |
| white | 37 | 47 |

3. Put one or more codes(use `;` as separator) between `\033]` and `m` to make a string
4. Run `printf` + `STRING` in terminal

## Example
```
// Reset it to default style(color), then set foreground color to red
printf "\033[0;31m"

// Set the style to BOLD, underline, then set foreground color to yellow
printf "\033[1;4;33m"

// Reset everything
printf "\033[0m"
```

## References
* [How do I output coloured text to a Linux terminal?](https://stackoverflow.com/questions/2616906/how-do-i-output-coloured-text-to-a-linux-terminal)
* [colorizing golang test run output](https://stackoverflow.com/questions/27242652/colorizing-golang-test-run-output)
