# `npm install` is Slow in China

#### Solution
* Use taobao registry

        // for temp use
        npm install --registry=https://registry.npm.taobao.org

        // set registry permanently
        npm config set registry https://registry.npm.taobao.org
        // check
        npm config get registry

* cnpm is **NOT** recommended because of some weird bugs.

#### References
* [国内优秀npm镜像推荐及使用](http://riny.net/2014/cnpm/)
