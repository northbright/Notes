# The HTTP `Content-Length` Header is Optional

## Problem
* The Size of Downloading File is Unknown in Some Case

## Root Cause
* The HTTP `Content-Length` Header is NOT Mandatory and May be Omitted by the Server
* The Downloading File is Created on the Fly and the Size Can NOT be Known before

## References
* [Why do some downloading files not know their own size?](https://superuser.com/questions/617327/why-do-some-downloading-files-not-know-their-own-size)
