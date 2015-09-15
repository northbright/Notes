
# Install DNS Lookup Tools on Centos

#### Check the package that provides `host` and `dig` on Centos:

    yum provides host
    yum provides dig

    // bind-utils is the package we want

#### Install

    sudo yum install bind-utils -y


