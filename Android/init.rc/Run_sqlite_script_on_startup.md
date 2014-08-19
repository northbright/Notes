
# Run sqlite3 sql script on startup

* add service in init.rc(or init.xx.rc, xx = platform)
    
        ## init.rc
        service sqlite /system/bin/sqlite.sh
            class main
            oneshot

  + `class main` indicates that the service's class is main and will be started after `/data` is mounted.
  + `oneshot` indicates that the service will be started only once
  + user / group's default value is `root`
  + Because the stdout / stderr will be redirected to /dev/null, you may use logwrapper to debug:
  
            service sqlite /system/bin/logwrapper /system/bin/sqlite.sh  

* `/system/bin/sqlite.sh` must start with `#!/system/bin/sh`

        #!/system/bin/sh

        sqlite3 -version > /data/sqlite3_version.txt

        sqlite3 /data/data/com.android.launcher/databases/launcher.db < /system/bin/update.sql

* Set permission for `/system/bin/sqlite.sh`

        chmod 0777 /system/bin/sqlite.sh

* Copy sqlite.sh to /system/bin if needed

        PRODUCT_COPY_FILES +=
            $(LOCAL_PATH)/sqlite.sh:system/bin/sqlite.sh

* update.sql

        UPDATE favorites SET intent = "#Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.android.dialer/.DialtactsActivity;end" where intent = "#Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.android.contacts/.activities.DialtactsActivity;end";

        DELETE from favorites where intent = "#Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.google.android.gms/.common.settings.GoogleSettingsActivity;end";

        DELETE from favorites where intent = "#Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.google.android.apps.genie.geniewidget/.activities.NewsActivity;end";

