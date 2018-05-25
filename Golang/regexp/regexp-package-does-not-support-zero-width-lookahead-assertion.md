# regexp Package does NOT Support Zero-width Lookahead Assertion

#### Problem
* Use `(?=re)`(Zero-width Positive Lookahead Assertion) to validate password
* Got error: invalid or unsupported Perl syntax: `(?=` when compile the code

#### Root Cause
* (?=re) before text matching re NOT SUPPORTED by golang

#### Solution
* Method A - [validate the password without RE](https://stackoverflow.com/questions/25159236/panic-when-compiling-a-regular-expression)

* Method B - Use multiple patterns

```
package main

import (
	"fmt"
	"regexp"
)

func ValidPassword(password string) bool {
	var patterns []string

	// Password consists of numbers, letters(lower or upper) and all chars other than numbers, letters and "_".
	// min width: 8, max width: 16
	patterns = append(patterns, `^(\d|[a-z]|[A-Z]|\W){8,16}$`)

	// At least one number.
	patterns = append(patterns, `^.*\d`)

	// At least one lower case letter.
	patterns = append(patterns, `^.*[a-z]`)

	// At least one upper case letter.
	patterns = append(patterns, `^.*[A-Z]`)

	// At least one special char other than numbers, letters and "_".
	patterns = append(patterns, `^.*\W`)

	for _, p := range patterns {
		re := regexp.MustCompile(p)
		if !re.MatchString(password) {
			return false
		}
	}
	return true
}

func main() {
	passwords := []string{
		"abc123",
		"abc12345",
		"Abc12345",
		"abcdefgh",
		"a long long long long password",
		"Abc1234!",
	}

	for _, password := range passwords {
		fmt.Printf("%v: %v\n", password, ValidPassword(password))
	}

	// Output:
	//abc123: false
	//abc12345: false
	//Abc12345: false
	//abcdefgh: false
	//a long long long long password: false
	//Abc1234!: true
}
```

* <https://wide.b3log.org/playground/45eff67b518064cf2b810528dff14158.go>

#### References
* [Panic when compiling a regular expression](https://stackoverflow.com/questions/25159236/panic-when-compiling-a-regular-expression)
* [Regular expression to check if password is “8 characters including 1 uppercase letter, 1 special character, alphanumeric characters”](https://stackoverflow.com/questions/9477906/regular-expression-to-check-if-password-is-8-characters-including-1-uppercase-l)
* [Password Strength Validation with Regular Expressions](https://www.zorched.net/2009/05/08/password-strength-validation-with-regular-expressions/)
