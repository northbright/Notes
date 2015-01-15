
# Exclude Files when Use tar

Sometimes, you may not want some folder / files(Ex: `.git`) to be in the tar file.  
Use `--exclude=PATH/xx` to exclude them:  

`tar -cvf Launcher.tar Launcher/ --exclude=Launcher/.git`

If you want to exclude specified type(Ex: `*.txt`):  
`tar -cvf Launcher.tar Launcher/ --exclude=Launcher/*.txt`