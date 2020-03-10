# List Available Services of firewalld(firewall-cmd)

## Problem
* Want to know all services provides by firewalld(e.g. http, ssh)

## Solution
```
// Use --get-service option to see all available services
firewall-cmd --get-service

// --list-services shows the services which opened ports of current settings
sudo firewall-cmd --zone=public --list-services
```

## References
* [Fedora's firewall-cmd shows more available services than configured](https://serverfault.com/questions/601381/fedoras-firewall-cmd-shows-more-available-services-than-configured)
