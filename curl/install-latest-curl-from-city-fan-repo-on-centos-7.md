# Install Latest cURL from city-fan.org Reop on CentOS 7

## Problem
* It reported that one ECS(CentOS 7) running on [Aliyun](https://aliyun.com) need to fix [CVE-2019-5482](https://nvd.nist.gov/vuln/detail/CVE-2019-5482)
* cURL on the ECS is 7.29
* To fix it, need to update cURL to 7.66 and later
* The latest version of cURL yum can update is 7.29

## Solution
Use 3rd party repo: city-fan.org

* Install rpm

  ```
  sudo rpm -Uvh http://www.city-fan.org/ftp/contrib/yum-repo/city-fan.org-release-2-1.rhel7.noarch.rpm
  ```

* Enable city-fan repo

  ```
  sudo /etc/yum.repos.d/city-fan.org.repo
  ```

  ```
  ## Goto "city-fan.org" section and replace "enabled=0" to "enabled=1"

  [city-fan.org]
  name=city-fan.org repository for Red Hat Enterprise Linux (and clones) $releasever ($basearch)
  #baseurl=http://mirror.city-fan.org/ftp/contrib/yum-repo/rhel$releasever/$basearch
  mirrorlist=http://mirror.city-fan.org/ftp/contrib/yum-repo/mirrorlist-rhel$releasever
  enabled=1
  gpgcheck=1
  gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-city-fan.org
  ```

* Update cURL

  ```
  // Check current cURL info
  yum info curl

  // Update cURL
  sudo yum update curl
  ```

* Check cURL version

  `curl --version`

## References
* [How to yum update curl 7.29 to 7.61 - CentOS 7.X](https://qiita.com/tkprof/items/5460b8d603cbbc542c8c)


