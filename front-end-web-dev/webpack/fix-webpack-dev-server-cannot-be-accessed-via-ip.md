# Fix `webpack-dev-server` Can ot be Accessed via IP

## Problem
* [webpack-dev-server](https://github.com/webpack/webpack-dev-server) worked for localhost only and can not be accessed via IP.

## Solution
* Add `--host 0.0.0.0` argument for `webpack-dev-server`

        // Example package.json
        {
          ...
          "scripts": {
            "start": "webpack-dev-server --host 0.0.0.0",
            ...
          },
          ...
        }

## References
* [Server can't be accessed via IP](https://github.com/webpack/webpack-dev-server/issues/147)
