# Setup Firewall on Ubuntu Using `ufw`

## Steps
1. Check `ufw` service status

   ```
   systemctl status ufw

   // Output:
   // ● ufw.service - Uncomplicated firewall
   //     Loaded: loaded (/lib/systemd/system/ufw.service; enabled; vendor preset: enabled)
   //     Active: active (exited)    
   ......
   ```

   * If `ufw` is not installed, run `sudo apt install ufw` to install it
   * If it's inactive, start ufw service and make the service enabled to start automatically with system boot:

     ```
     sudo systemctl enable --now ufw
     ```

2. Check `ufw` firewall status

   ```
   sudo ufw status verbose
   
   // Output:
   // Status: inactive / active
   ```

3. Setup Firewall Policies

   * Setting Up Default Policies

     ```
     sudo ufw default deny incoming
     sudo ufw default allow outgoing
     ```
   * Allow SSH

     ```
     sudo ufw allow ssh

     // or you may specify the SSH port
     sudo ufw allow 22
     ```

   * Allow HTTP and HTTPS(Optional)

     ```
     sudo ufw allow http
     sudo ufw allow https

     // or you may specify the HTTP / HTTPS port
     sudo ufw allow 80
     sudo ufw allow 443 
     ```

   * Allow Samba(optional)

     ```
     sudo ufw allow samba
     ```

4. Enable `ufw` if firewall is disabled(`inactive`)

   ```
   sudo ufw enable
   ```

   * If it's the first time to enable `ufw` with ssh login, you may get the warnning:

     > Command may disrupt existing ssh connections. Proceed with operation (y|n)?

     You should enable ufw **AFTER** setting up the firewall policies including allow SSH

5. Check `ufw` status

   Use `ufw status` or `ufw status verbose` to show firewall status.

   ```
   sudo ufw status

   // Output:
   To                         Action      From
   --                         ------      ----
   22                         ALLOW       Anywhere                  
   22/tcp                     ALLOW       Anywhere                  
   80/tcp                     ALLOW       Anywhere                  
   443/tcp                    ALLOW       Anywhere                  
   ```

   ```
   sudo ufw status verbose

   To                         Action      From
   --                         ------      ----
   22/tcp                     ALLOW IN    Anywhere                  
   137,138/udp (Samba)        ALLOW IN    Anywhere                  
   139,445/tcp (Samba)        ALLOW IN    Anywhere                  
   22/tcp (v6)                ALLOW IN    Anywhere (v6)             
   137,138/udp (Samba (v6))   ALLOW IN    Anywhere (v6)             
   139,445/tcp (Samba (v6))   ALLOW IN    Anywhere (v6)     
   ```

## References
* [How To Set Up a Firewall with UFW on Ubuntu 20.04](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-firewall-with-ufw-on-ubuntu-20-04)
