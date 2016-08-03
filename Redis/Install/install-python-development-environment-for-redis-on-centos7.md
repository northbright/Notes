# Install Python Development Environment for Redis on CentOS7

#### Steps

* [Install and Config Redis on CentOS](https://github.com/northbright/Notes/blob/master/Redis/Install/Install_and_Config_Redis_on_CentOS.md)

* Install `python-devel`
    * `yum search python | grep devel` go get the package name(`python-devel`)
    * `sudo yum install -y python-devel`

* Install setuptools via [ez_setup.py](http://peak.telecommunity.com/dist/ez_setup.py)
    * `wget -q http://peak.telecommunity.com/dist/ez_setup.py`

* Install redis client for python and [hiredis(Python wrapper for hiredis)](http://pypi.python.org/simple/hiredis)
    * `sudo python -m easy_install redis hiredis`

#### Test

    python
    >>> import redis
    >>> conn = redis.Redis()
    >>> conn.set('hello', 'world')
    True
    >>> conn.get('hello')
    'world'
