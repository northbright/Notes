# Fix `Unexpected Console Statement` in [ESLint](https://eslint.org)

## Problem
* Create a [Quasar](https://quasar.dev/) project via [Quasar CLI](https://quasar.dev/start/quasar-cli)
  * [ESLint](https://eslint.org) was selected during the installation
  * Picked [Prettier](https://prettier.io/) as  [ESLint](https://eslint.org) **Preset**
* Got `Unexpected Console Statement` error when call `console.log()` in any function

## Root Cause
* ESLint [disallow the use of `console` (no-console)](https://eslint.org/docs/rules/no-console)

## Solution
Set `'no-console'` to `'off'` for development environment in `.eslintrc.js`

    // Open .eslintrc.js
    vi .eslintrc.js

    rules: {
        "no-console": process.env.NODE_ENV === "production" ? "error" : "off"
    }
