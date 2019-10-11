# setup.py Uninstall

## Problem
* Remove all files installed from Python setup.py

## Solution
* Use `--record LOGFILE` option with `python setup.py` to record all installed files


## Example
```
python setup.py install --record log.txt
sudo rm $(log.txt)
```

## References
* [python setup.py uninstall](https://stackoverflow.com/questions/1550226/python-setup-py-uninstall)
