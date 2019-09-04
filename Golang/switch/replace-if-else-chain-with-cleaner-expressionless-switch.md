# Replace if-else Chain with Cleaner Expressionless switch

#### Expressionless switch
* The expression in a switch is optional and it can be omitted.
* If the expression is omitted, the switch is considered to be switch true and each of the case expression is evaluated for truth and the corresponding block of code is executed.

#### Example

        for _, r := range password {
                switch {
                case unicode.IsDigit(r):
                        oneNum = true
                case unicode.IsUpper(r):
                        oneUpper = true
                case unicode.IsLower(r):
                        oneLower = true
                case unicode.IsSymbol(r), unicode.IsPunct(r):
                        oneSpecial = true
                }
        }

#### References
* [Missing expression](https://github.com/golang/go/wiki/Switch#missing-expression)
* [Part 10: Switch Statement](https://golangbot.com/switch/)

