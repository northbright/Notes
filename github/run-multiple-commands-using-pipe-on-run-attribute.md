# Run Multiple Commands using `|` Pipe on "run" attribute

## Problem
* Need to run multiple commands on "run" attribute

## Solution
Using `|` pipe on "run" attribute.
`|` is the Literal Block Scalar of YAML: This style preserves the line breaks within the string exactly as they are.

Examples:

```yaml
    - name: Compile and install libiconv
      run: |
        tar -xzvf libiconv-1.18.tar.gz
        cd libiconv-1.18
        ./configure
        make
        sudo RUNNER_ALLOW_RUNASROOT=true make install
        cd ..
```

## References
* [How to Use Multiline Strings in YAML (with Examples)](https://www.heatware.net/devops-cloud/yaml-multiline-string/)
* [How to run multiple commands in one Github Actions Docker](https://stackoverflow.com/questions/56726429/how-to-run-multiple-commands-in-one-github-actions-docker)

