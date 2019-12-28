# Show Which Config Files and Rules are Loaded When Run [ESLint](https://eslint.org)

## Problem
* Create a [Quasar](https://quasar.dev) app via [Quasar CLI](https://quasar.dev/start/quasar-cli)
* Selected [ESLint](https://eslint.org)
* Got `Unexpected Console Statement` error when call `console.log()`
* That means ESLint [disallow the use of `console` (no-console)](https://eslint.org/docs/rules/no-console)
* Want to know which config files and rules are loaded when run ESLint

## Solution
* Use `--debug` option when run `ESLint`

      cd my_project
      ./node_modules/.bin/eslint ./src/App.vue --debug

      // Output:
      ...
      eslint:config-file Loading node_modules/eslint/conf/eslint-recommended.js
      ...

* Look into `node_modules/eslint/conf/eslint-recommended.js`
   
   You may find it'll load `node_modules/eslint/lib/built-in-rules-index`:


      const builtInRules = require("../lib/built-in-rules-index");

      module.exports = {
        rules: Object.assign({}, ...Object.keys(builtInRules).map(ruleId => ({
            [ruleId]: builtInRules[ruleId].meta.docs.recommended ? "error" : "off"
        })))
      };

* Look into `node_modules/eslint/lib/built-in-rules-index`
  
   You may find `'no-console'` is in the `'rules'`

       "no-console": require("./rules/no-console"),

## References
* [Eslint default rules](https://stackoverflow.com/questions/34705136/eslint-default-rules)
* [Fix `Unexpected Console Statement` in ESlint](https://github.com/northbright/Notes/blob/master/front-end-web-dev/eslint/fix-unexpected-console-statement-in-eslint.md)

