# Got "doesn't support -std=c++11 or -std=c++0x" Error when Compiling MariaDB from Source

## Problem
* Got "doesn't support -std=c++11 or -std=c++0x" Error when Compiling(`cmake`) [MariaDB](https://mariadb.org)

## How to Reproduce
* Download latest [MariaDB](https://mariadb.org) via `git clone`

      // Only fetch specified branch of MariaDB
      git clone --single-branch --branch 10.3 https://github.com/MariaDB/server.git

      // cmake
      cd server
      cmake . -DWITH_SSL=/usr/local/openssl

* Got Error

   > CMake Error at storage/tokudb/PerconaFT/cmake_modules/TokuSetupCompiler.cmake:178 (message):
  /usr/bin/c++ doesn't support -std=c++11 or -std=c++0x, you need one that
  does.

## Root Cause
* TokuDB is enabled by default and it needs c++11 comipler

## Solutions
* Build MariaDB **WITHOUT** TokuDB if you do not need
  
      cmake . -DWITH_SSL=/usr/local/openssl -DWITHOUT_TOKUDB=1

