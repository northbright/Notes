# Install `gcc` / `g++` 8 on CentOS 7

## Problem
* Got error while building [Node.js](https://nodejs.org) from source on CentOS 7
* Building [Node.js](https://nodejs.org) requires `gcc` >= `6.3`
* Default version of `gcc` / `g++` on CentOS 7 is `4.8.5`

## Solution

Install `gcc` / `g++` 8 from Developer Toolset.

* Enable the Software Collections repository
   
      sudo yum install centos-release-scl

* Install Developer Toolset

      sudo yum install devtoolset-8-gcc devtoolset-8-gcc-c++

* Switch to a Shell which defaults `gcc` and `g++` to this version
  
      scl enable devtoolset-8 -- bash

## References
* [How to install GCC/G++ 8 on CentOS](https://stackoverflow.com/questions/55345373/how-to-install-gcc-g-8-on-centos)
