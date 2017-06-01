# Count the Number of Matches in vim

#### Problem
* Search with pattern(e.g. `/xxx`).
* Need to count the number of matches.

#### Solution
* Use `%s/ANY//gn` to show the count of matches of "ANY".

* This is the substitution command, but the `n` flag avoids the actual substitution.


#### References
* [Unable to count the number of matches in Vim](https://stackoverflow.com/questions/647049/unable-to-count-the-number-of-matches-in-vim)
