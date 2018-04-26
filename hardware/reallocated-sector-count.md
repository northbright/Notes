# Reallocatedf Sector Count

#### Problem
* Get a message that says "Windows detected a hard disk problem" on disk(WD 3T)
* Run [HD Tune](http://hdtune.com/) to see the health of the disk
* [HD Tune](http://hdtune.com/) highlighted the "Reallocated Sector Count" SMART attribute
  
          Current: 133
          Worst: 133
          Threshold: 140

#### What does it mean?

[9105: S.M.A.R.T. Attribute: Reallocated Sectors Count](https://kb.acronis.com/content/9105)

> Reallocated Sectors Count S.M.A.R.T. parameter indicates the count of reallocated sectors (512 bytes). When the hard drive finds a read/write/verification error, it marks this sector as "reallocated" and transfers data to a special reserved area (spare area). This process is also known as remapping and "reallocated" sectors are called remaps. This is why, on a modern hard disks, you will not see "bad blocks" while testing the surface - all bad blocks are hidden in reallocated sectors.

#### Solution
* Replace it with a new HD

#### References
* ["Reallocated Sector Count".. What to do?](http://www.tomshardware.com/forum/249218-32-reallocated-sector-count)
* [9105: S.M.A.R.T. Attribute: Reallocated Sectors Count](https://kb.acronis.com/content/9105)
* [Windows detected a hard disk problem](https://answers.microsoft.com/en-us/windows/forum/windows_7-hardware/windows-detected-a-hard-disk-problem/4ba3a007-e02d-49ae-a441-132d00fb3c62)
