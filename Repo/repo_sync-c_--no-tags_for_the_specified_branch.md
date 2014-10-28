
# repo sync -c --no-tags for specified branch(in manifest) to avoid syncing all remote branches and tags

###### repo init
`repo init -u <manifest repo url> -b <manifest repo branch> -m <manifest name in the repo(default is default.xml)>`

###### repo sync
`repo sync -c --no-tags -j4`

* `-c`:  
only fetch / rebase the branch specified in .repo/manifest.xml

* `--no-tags`  
do not sync tags

* `-jxx`  
concurrent worker number