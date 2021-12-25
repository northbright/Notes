# Congiure Passwordless Login

## Solution
Setup public key authentication
  
* Configure sshd service on remote server

  ```
  sudo vi /etc/ssh/sshd_config
  ```

  ```
  # Go the the end of the file
  # Append or modify these lines
  PubkeyAuthentication yes
  AuthorizedKeysFile     .ssh/authorized_keys .ssh/authorized_keys2
  ```

  ```
  // Restart sshd service
  sudo service sshd restart
  ```

* Create an SSH key on client(local)
    
  ```
  # Create a 3072-bit RSA key pair by default
  # It will store the key in ~/.ssh/id_rsa.pub
  #
  ssh-keygen
  ```

* Copy the key to a remote server(e.g. `mysite.com`)

  ```
  ssh-copy-id -i ~/.ssh/id_rsa.pub user@mysite.com
  ```

* Open a new terminal to test passwordless login

  ```
  ssh user@mysite.com
  ```

* Configure Server to Disable Password Authentication and Disable Root Login(Optional) 

  ```
  sudo vi /etc/ssh/sshd_config
  ```

  ```
  # Go the the end of the file
  # Append or modify these lines
  PermitRootLogin no
  PasswordAuthentication no
  ```

  ```
  // Restart sshd service
  sudo service sshd restart
  ```

## References
* [Ssh-copy-id for copying SSH keys to servers](https://www.ssh.com/academy/ssh/copy-id)
* [How To Configure SSH Key-Based Authentication on a Linux Server](https://www.digitalocean.com/community/tutorials/how-to-configure-ssh-key-based-authentication-on-a-linux-server)
* [ssh-copy-id - permission denied (publickey)](https://serverfault.com/questions/684346/ssh-copy-id-permission-denied-publickey)
* [Permission denied (publickey) while copying id](https://askubuntu.com/questions/1356521/permission-denied-publickey-while-copying-id)
