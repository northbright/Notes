# Use Compass to Explore mongoDB of Unifi

#### Problem
* Use Unifi API to authorize guest
    * `/api/s/$site/cmd/stamgr`
    * the site name is **NOT** the one in Unifi GUI.
* Need to know the names of sites created in Unifi

#### Solution
* Download and run [Compass](https://www.mongodb.com/products/compass)
* Set `Port` to `27117`.
    * The MongoDB instance started by the UniFi Controller runs on 27117

    ![](img/01.png)

* Click "Connect".
* Select "ace" db -> "site" on the left side bar.
* Select "DOCUMENTS" tab to explore all sites.
    * `name` is the **REAL** name can used by Unifi APIs(`$site`).
    * `desc` is **ONLY** the description of site that is the "site name" can be set in Unifi GUI.

    ![](img/02.png)

#### References
* [UniFi controller data ports and Mongod ports ?](https://community.ubnt.com/t5/UniFi-Wireless/UniFi-controller-data-ports-and-Mongod-ports/td-p/1109887)
