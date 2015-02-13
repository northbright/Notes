
# Enable "install non market apps"(unknown sources) by default

The default value is set to false under:  
`frameworks/base/packages/SettingsProvider/res/values/defaults.xml`:  
 
`<bool name="def_install_non_market_apps">false</bool>`

You may put a `defaults.xml` under your overlay folder and set `def_install_non_market_apps` to `true`
