# Windows Detected a Hard Disk Problem

#### Problem
* Got a message says "Windows detected a hard disk problem" after startup

#### Root Cause
* HD has some problems and windows report the problem due to built-in SMART diagnostic system

#### Solution
* Run [HDTune](http://hdtune.com/) to see the health of the disk and perform a disk check
* [HDTune](http://hdtune.com/) highlighted the "Reallocated Sector Count"(bad sectors)
* Backup data and replace HD

#### References
* [Reallocated Sector Count](reallocated-sector-count.md)
* [Windows detected a hard disk problem](https://answers.microsoft.com/en-us/windows/forum/windows_7-hardware/windows-detected-a-hard-disk-problem/4ba3a007-e02d-49ae-a441-132d00fb3c62)
* [9105: S.M.A.R.T. Attribute: Reallocated Sectors Count](https://kb.acronis.com/content/9105)
* ["Reallocated Sector Count".. What to do?](http://www.tomshardware.com/forum/249218-32-reallocated-sector-count)
