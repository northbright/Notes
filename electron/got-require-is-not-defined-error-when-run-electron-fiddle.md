# Got "require is not defined" Error When Run Electron Fiddle

## Problem
* Download and run [Electron Fiddle](https://www.electronjs.org/fiddle)
* Goto Menu > Show Me > Electron APIs > Clipboard or IPC
* Click "Run"
* For Clipboard example
  * Copy / Paste clipboard and it does not work
  * Activate the app window and goto Menu > View > Toggle Developer Tools > Console
  * Got `Uncaught ReferenceError: require is not defined`
* For IPC example
  * Activate the app window and goto Menu > View > Toggle Developer Tools > Console
  * Got `Uncaught ReferenceError: require is not defined`

  ```
  // index.html
  <!DOCTYPE html>
    <html lang="en">
      <head>
        <title>IPC Example</title>
      </head>
      <body>
        <h1>IPC Example</h1>
        <p>Open the developer tools to see the IPC in action.</p>
        <script>
          require('./renderer.js')
        </script>
      </body>
      </html>
  ```

## Root Cause
* `contextIsolation` defaults to `true` in Electron 12
* `require()` cannot be used in the renderer process unless `nodeIntegration` is `true` and `contextIsolation` is `false`

## Solution
In `main.js`, make sure set `nodeIntegration` to `true` and `contextIsolation` to `false` when new a BrowserWindow.

```
  ......
  const mainWindow = new BrowserWindow({
    height: 600,
    width: 600,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false
    }
  })
  ......
```

## References
* [Breaking Changes](https://www.electronjs.org/docs/breaking-changes#default-changed-contextisolation-defaults-to-true)
* [If you want to follow and create a secure app (adhering to security best-practices), please follow my setup as I describe in this comment](https://github.com/electron/electron/issues/9920#issuecomment-575839738)
* [secure-electron-template](https://github.com/reZach/secure-electron-template)
