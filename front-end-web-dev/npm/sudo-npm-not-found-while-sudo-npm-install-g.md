# sudo `npm` not Found while Run `sudo npm install xx -g`

#### Solution
Append `/usr/local/bin/` to `secure_path` of `visudo`

    sudo visudo

    // Find secure_path
    // Append /usr/local/bin/
    Defaults    secure_path = /sbin:/bin:/usr/sbin:/usr/bin:/usr/local/bin/

#### References
* [sudo: xx command not found](https://github.com/northbright/Notes/blob/master/Linux/Commands/sudo-command-not-found.md)
