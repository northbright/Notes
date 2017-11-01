# Reduce Size of Uploaded Images for Wordpress

#### Solution
* Use  [convert](http://www.imagemagick.org/script/convert.php) tool provided by [imagemagick](http://www.imagemagick.org):

#### Steps
1. Download [ImageMagick.tar.gz](https://www.imagemagick.org/download/ImageMagick.tar.gz) on the [source of imagemagick](http://www.imagemagick.org/script/install-source.php)
2. Build imagemagick from source

        tar -zvxf ImageMagick.tar.gz
        cd ImageMagick-7.0.6-10
        ./configure
        make
        sudo make install
        // make shared libraries under /usr/local/lib can be searched
        sudo ldconfig /usr/local/lib
3. Write a shell to reduce the image size when it's > 200KB.

* `vi /var/www/mysite/wordpress/wp-content/uploads/reduce-img.sh`

        #!/bin/sh 
        echo "resize image who is bigger than 200k -> 200k";
        for i in `find . -size +200k`
        do
          convert $i -define jpeg:extent=200kb $i;
          echo "resize image $i to 200kb";
        done

*  `chmod +x `

#### References
* [ImageMagick: scale JPEG image with a maximum file-size](https://stackoverflow.com/questions/6917219/imagemagick-scale-jpeg-image-with-a-maximum-file-size)
* [ImageMagick和脚本批量压缩图片 ](http://blog.csdn.net/doubleselect/article/details/40191437)

