# Encrypt a Text Using AES-256-CBC Like crypto-js in Golang

## Problem
* Need to encrypt a text using AES-256 with CBC mode like [crypto-js](https://github.com/brix/crypto-js/) in Golang

  ```js
  var Encrypt = function (str) {

      // key string in HTML: "3c00754e2f814cb8866f7a1d2b4d98cd"
      var _key = $("#key").val();

      // iv string in HTML: "0df2ad5de62c11ed"
      var _iv = $("#iv").val();

      var key = CryptoJS.enc.Utf8.parse(_key);
      var iv = CryptoJS.enc.Utf8.parse(_iv);

      var encrypted = "";
      var srcs = CryptoJS.enc.Utf8.parse(str);
      encrypted = CryptoJS.AES.encrypt(srcs, key, {
          iv: iv,
          mode: CryptoJS.mode.CBC,
          padding: CryptoJS.pad.Pkcs7 
      });

      return encrypted.ciphertext.toString();
  }
  ```

## Solution

See [aes-example](https://github.com/northbright/aes-example).
