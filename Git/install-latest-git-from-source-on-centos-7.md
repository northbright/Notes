# Install Latest Git from Source on CentOS 7

#### Purpose
* `sudo yum install git` may install the old version of Git.
* To get latest version of Git, install git from source is a good idea.

#### Steps
1. Install "Development Tools"

        sudo yum groupinstall "Development Tools"

* It'll install tools to build Git(e.g. autoconf, gcc, make...)
* It'll also install an old version git(we need to run `git clone` for [git repo](https://github.com/git/git/)

2. Install Extra Dependencies
    * `sudo yum install zlib-devel perl-ExtUtils-MakeMaker asciidoc xmlto`

3. Install `libcurl-devel` to add HTTPS support for Git
    * `sudo yum install libcurl-devel`

4. Get source of git

   Goto <https://github.com/git/git/releases> to download latest release

         // e.g. v2.21.0
         wget https://github.com/git/git/archive/v2.21.0.tar.gz

5. Make git

        make configure
        ./configure --prefix=/usr/local/git
        make all
        sudo make install

6. Add New Binary Path of Git
* `sudo vi /etc/profile`

      # Append these lines:
      # Use New Version of Git
      export PATH=/usr/local/git/bin:$PATH
* `source /etc/profile`
* Run `git --version` to check

7. Setup git

        git config --global user.name "Your Name"
        git config --global user.email "xx@example.com"
        git config --global color.ui true

8. Set VISUAL and EDITOR env variables
  
        // Ex: /etc/profile or ~/.bashrc
        export VISUAL=vim
        export EDITOR="$VISUAL"

#### References
* [How To Install Git on a CentOS 6.4 VPS](https://www.digitalocean.com/community/tutorials/how-to-install-git-on-a-centos-6-4-vps)
 

