# Install and Configure Nginx on CentOS 7

#### Install Nginx

    sudo yum install -y nginx

#### Configure Firewall for Nginx

    // default HTTP service on port 80:
    sudo firewall-cmd --permanent --zone=public --add-service=http
    
    // or other ports like 8080:
    sudo firewall-cmd --permanent --zone=public --add-port=8080/tcp
    
    // Reload firewalld
    sudo firewall-cmd --reload
    // Check
    sudo firewall-cmd --list-all

####  Configure SELinux if you use a new directory as Nginx server root
* See [Fix 403 Forbidden Error of Nginx on CentOS 7](https://github.com/northbright/Notes/blob/master/nginx/fix-403-forbidden-error-of-nginx-on-centos.md)
