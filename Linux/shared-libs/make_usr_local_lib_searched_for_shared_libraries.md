# Make `/usr/local/lib` Searched for Shared Libraries

#### Create a conf file under `/etc/ld.so.conf.d/`:
   
    sudo vi /etc/ld.so.conf.d/usrlocallib.conf
    ## add below line:
    /usr/local/lib

#### Reload ldconfig cache

    sudo ldconfig

#### Check

    sudo ldconfig -p | grep xx.so

#### References
* <http://stackoverflow.com/questions/4743233/is-usr-local-lib-searched-for-shared-libraries>
