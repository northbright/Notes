
# Chrome Can't Go Back After "Google App" Starts

* Steps
    1. Factory reset the device
    2. SKIP WiFi setup
    3. Launch "Chrome"
    4. Launch "Google"(Google Search App)
    5. Click "Back" in "Google" then "Chrome" will popup
    6. Click "Back" in "Chrome" and it does NOT work

* Root Cause  

  * "Google" app will need to be initialized at least once and store intialization settings in `SearchSettings.bin` and `StartupSettings.bin` under `/data/data/com.google.android.googlequicksearchbox/app_shared_prefs`.

  * It will failed to initialize without WiFi connection.
  * It will re-try initialization everty time at startup if `SearchSettings.bin` and `StartupSettings.bin` do not exist.
  * NetworkUtil will throw an "okHttp" exception when the initialization is failed and that will cause Chrome can't go back.  
  
            I/Timeline( 4496): Timeline: Activity_launch_request id:com.google.android.googlequicksearchbox time:254810
            I/Search.RefreshSearchDomainAndCookiesTask( 4496): refreshing search domain
            I/ActivityManager(  842): START u0 {act=android.intent.action.MAIN flg=0x14000000 cmp=com.google.android.googlequicksearchbox/com.google.android.velvet.ui.VelvetActivity (has extras)} from pid 4496
            W/Search.SearchUrlHelper( 4496): Auth token not ready, no auth header set.
            W/NetworkUtils( 4496): OkHttp exception
            W/NetworkUtils( 4496): OkHttp exception
            W/Search.RefreshSearchDomainAndCookiesTask( 4496): Search parameters fetch failed: dhq: Error code: 262146
            W/Search.RefreshSearchDomainAndCookiesTask( 4496): Search parameters fetch failed
  * Once the WiFi connection is OK, "Google" app will initialized successfully. `SearchSettings.bin` and `StartupSettings.bin` will be created. This issue will never be duplicated even if the WiFi connections is closed.

* How to Fix  
Maybe "Force users to compelete WiFi connection(OOBE)" is one solution.

* How about Nexus 7  
Nexus 7 will force users to complete WiFi setup during OOBE(SetupWizard).  
You may try to root it and remove `SearchSettings.bin` and `StartupSettings.bin` to duplicate this issue.