
# umask and Permission of New Created Files and Dirs

If you create new files and dirs programmatically, you'll be asked to give a permssion.  
We'll find that the permission of new created file / dir is not same as we expect.

    // Golang, run on Centos 7.0

    package main

    import (
        "fmt"
        "io/ioutil"
        "os/user"
    )

    func main() {
        u, _ := user.Current()
        username := u.Username
        filePath := fmt.Sprintf("/home/%v/my.txt", username)

        // The final created file's permission will be 0664 but not 0666.
        // Final permission = our permission - umask.
        // = 0666 - 002(default by Centos 7) = 0664.
        ioutil.WriteFile(filePath, []byte("test"), 0666)
    }


#### umask

The `user file-creation mode mask(umask)` is use to determine the file permission for newly created files.  
It can be used to control the default file permission for new files. It is a four-digit octal number.

| Octal value | Permission |
| ----------- | ---------- |
| 0 | read, write and execute |
| 1 | read and write |
| 2 | read and execute |
| 3 | read only |
| 4 | write and execute |
| 5 | write only |
| 6 | execute only |
| 7 | no permissions |

#### Get / Set umask

    // Get umask in bash
    umask

    // Set umask in bash
    umask XXX

#### Default umask

|  OS  |  umask  |
| ---- | ------- |
| Centos 7 | 0002 |
| Ubuntu 12.04 | 0002 |

#### References
* [What is Umask and How To Setup Default umask Under Linux?](http://www.cyberciti.biz/tips/understanding-linux-unix-umask-value-usage.html)
* [Change the default umask to 0002](https://blueprints.launchpad.net/ubuntu/+spec/umask-to-0002)