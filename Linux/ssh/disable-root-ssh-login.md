# Disable root SSH Login

## Problem
* To secure the system, it's better to use a separate account to login via SSH and disable `root` SSH login

## Steps
* Login as `root`
* Add User and Set Password
  
      adduser xx
      passwd xx 


* Allow Added User to Run Any Commands Anywhere 
   
      visudo
      ## Find Allow root to run any commands anywhere
      ## Add xx under root
      root    ALL=(ALL)       ALL
      xx      ALL=(ALL)       ALL

* Disable Root SSH Login
   * Modify `/etc/ssh/sshd_config`
      
         vi /etc/ssh/sshd_config
         ## Find PermitRootLogin and set it to no
         PermitRootLogin no

   * Restart `sshd` Service
     
         service sshd restart

* Re-login as new user: xx
