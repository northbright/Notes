# Congiure Passwordless Login

## Solution
Setup public key authentication
  
* Configure sshd service on remote server

  ```
  sudo vi /etc/ssh/sshd_config
  ```

  ```
  PermitRootLogin no
  PasswordAuthentication no
  PubkeyAuthentication yes
  AuthorizedKeysFile     .ssh/authorized_keys .ssh/authorized_keys2
  ```

  ```
  // Restart sshd service
  sudo service sshd restart
  ```

* Create an SSH key on local
    
  ```
  # Create a 3072-bit RSA key pair by default
  # It will store the key in ~/.ssh/id_rsa.pub
  #
  ssh-keygen
  ```

* Copy the key to a remote server(e.g. `mysite.com`)

  ```
  ssh-id-copy -i ~/.ssh/id_rsa.pub user@mysite.com
  ```

* Open a new terminal to test passwordless login

  ```
  ssh user@mysite.com
  ```

## References
* [Ssh-copy-id for copying SSH keys to servers](https://www.ssh.com/academy/ssh/copy-id)
* [How To Configure SSH Key-Based Authentication on a Linux Server](https://www.digitalocean.com/community/tutorials/how-to-configure-ssh-key-based-authentication-on-a-linux-server)
