# Install nslookup on CentOS

## Problem
* run `nslookup` on CentOS 8 and reported `nslookup not found`

## Solution
* Find the package which provides `nslookup`

  ```
  yum provides nslookup

  // Output:
  bind-utils-32:9.11.4-26.P2.el8.x86_64 : Utilities for querying DNS name
                                        : servers

  ```

* Install `bind-utils`

  ```
  sudo yum install -y bind-utils
  ```
