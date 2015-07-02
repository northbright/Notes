
# Run Golang Web App(HTTP Service) as Normal User

#### Why

If your golang app run as `root` and allows users to upload files,  
The owner of the uploaded files will be `root` and it may have the permission issue to process the uploaded files.

#### Run Golang App as Normal User

Ports below `1024` can be opened only by `root`.  
We need to use another port(ex: `8080`).

    server := http.Server{
        Addr:    ":8080",  // Run golang web app as normal user
        Handler: &MyHandler{},
    }

#### Configure Firewall to Allow HTTP Service on This Port
* [Configure Firewall to Enable HTTP Service on CentOS 7](https://github.com/northbright/Notes/blob/master/Linux/CentOS/Configure_Firewall_to_Enable_HTTP_Service_on_CentOS_7.md)