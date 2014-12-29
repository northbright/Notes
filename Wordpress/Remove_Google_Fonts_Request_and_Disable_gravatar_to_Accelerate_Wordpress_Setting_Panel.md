
# Remove Google Fonts Request and Disable gravatar to Accelerate Wordpress Setting Panel

Wordpress sites in China can't access fonts.googleapis.com and gravatar website.  
To reduce the response time, we need to remove the requests of fonts.googleapi.com and gravatar.

* Remove fonts.googleapis.com

        //wp-includes/script-loader.php:602

        // Comment this line to disable fonts.googleapis.com request
        // ----------------------------------------------------------------
        //$open_sans_font_url = "//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,300,400,600&subset=$subsets";

* Disable gravatar

Enter "Settings"->"Discussion"->"Avatars"->Disable "Show Avatars"