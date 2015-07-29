# Virtualbox can not use VT-x if Hyper-V is installed

We can't run two VM applications at the same time if both want to use VT-x.  
Hyper-V permanently takes over VT-x and doesn't let anyone else use it.

#### Reference
* <https://forums.virtualbox.org/viewtopic.php?f=6&t=58698>