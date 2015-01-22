
# Configure Firewall to Enable HTTP Service on CentOS 7

CentOS 7 runs [FirewallD](https://fedoraproject.org/wiki/FirewallD).  
To add HTTP service via `firewall-cmd`:  
`sudo firewall-cmd --permanent --zone=public --add-service=http`  

you may check via:  
`sudo firewall-cmd --zone=public --query-service=http`


For more, see:  
<http://stackoverflow.com/questions/24729024/centos-7-open-firewall-port>