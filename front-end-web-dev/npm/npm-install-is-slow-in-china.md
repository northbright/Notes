# `npm install` is Slow in China

#### Solution
* Use taobao registry

      // set registry permanently
      sudo npm config set registry https://registry.npm.taobao.org

      // check
      npm config get registry

* cnpm is **NOT** recommended because of some weird bugs.

#### References
* [国内优秀npm镜像推荐及使用](http://riny.net/2014/cnpm/)
* [npm 设置淘宝镜像的两个方法](https://www.jianshu.com/p/92116d8d2298)
