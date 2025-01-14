# Export Site and Migrate Devices from Old Unifi Network Server to a New One

## Problem
* Need to export a site from old Unifi Network Server to a new one

## Steps

#### Export Site Data File
* Go to old server > Settings > System > Site Management > Export Site
* Click "Download the Site Export File"

#### Create a New Site via Import Site Data File on New Unifi Network Server
* Go to new server > Site Switcher(Top-Left Icon) > Add New
* Input "Site Name"
* Click "Import Site"
* After site imported, all devices will appear as "offline"

#### Migrate Devices
* Go to old server > Settings > System > Site Management > Export Site > Continue > Migrate Devices
* Enter inform URL of new server(e.g. `http://10.0.2.3:8080/inform`)
* Select all devices > Click "Migrate Devices"

#### Wait All Devices Adopted by New Server
* Go to new server > Site > Devices >
* Monitor device status: "Getting Ready" -> "Connected"(up to date)

#### Remove All Migrated Devices on Old Server
* Make sure all devices are adopted on new server
  * If some devices are not visible or offline, need to login device via ssh and run "set-inform"
    ```
    // SSH to UAP
    ssh admin@10.0.2.x

    // Show information
    info
    // Output: Status:      Connected (http://IP_of_old_server:8080/inform)
    

    // Run set-inform
    set-inform http://IP_of_new_server:8080/inform
    ```
  * Monitor the device status on new server

  * If it still appears offline, retart the device on old server and run `set-inform` again
    * Go to old server > devices > select device > settings > restart

* Go to old server > Settings > System > Site Management > Export Site > Continue > Migrate Devices > Remove Devices


## References
* [How-to Migrate Unifi Controller](https://lazyadmin.nl/home-network/migrate-unifi-controller/)
* [How to Migrate Your UniFi Devices to a New Controller](https://www.unihosted.com/docs/migrate-unifi-devices-new-controller-guide)
