# Setup Firewall on Ubuntu Using `ufw`

## Steps
1. Install `ufw`

   ```
   sudo apt install ufw
   ```
2. Setup Firewall Policies

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

     WARNING: you need to install `samba` before add this profile.

     ```
     sudo ufw allow samba
     ```

     If you got "ERROR: Could not find a profile matching 'samba'",
     That means the 'samba' application is NOT installed on the server yet.
     Run `sudo apt install samba` to install it.

3. Enable `ufw` if firewall is disabled(`inactive`)

   ```
   sudo ufw enable
   ```

   * If it's the first time to enable `ufw` with ssh login, you may get the warnning:

     > Command may disrupt existing ssh connections. Proceed with operation (y|n)?

     You should enable ufw **AFTER** setting up the firewall policies including allow SSH

4. Check `ufw` status

   Use `ufw status verbose` to show firewall status.

   ```
   sudo ufw status verbose

   // Output:
   Status: active
   Logging: on (low)
   Default: deny (incoming), allow (outgoing), disabled (routed)
   New profiles: skip

   To                         Action      From
   --                         ------      ----
   22/tcp                     ALLOW IN    Anywhere                  
   80/tcp                     ALLOW IN    Anywhere                  
   443                        ALLOW IN    Anywhere                  
   22/tcp (v6)                ALLOW IN    Anywhere (v6)             
   80/tcp (v6)                ALLOW IN    Anywhere (v6)             
   443 (v6)                   ALLOW IN    Anywhere (v6)  
   ```

## References
* [How To Set Up a Firewall with UFW on Ubuntu 20.04](https://www.digitalocean.com/community/tutorials/how-to-set-up-a-firewall-with-ufw-on-ubuntu-20-04)
* [UFW Essentials: Common Firewall Rules and Commands](https://www.digitalocean.com/community/tutorials/ufw-essentials-common-firewall-rules-and-commands)
