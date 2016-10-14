# ISMEMBER for Sorted Set in Redis

#### Problem
* Need a command to check if the "MEMBER" is a member of sorted set like `SISMEMBER` for set.

#### Solution
* Use `ZSCORE` command
* It'll return th score of the "MEMBER" and nil if the "MEMBER" is not a member of sorted set.

        redis>ZSCORE salary peter
        redis>"3500"

        redis>ZSCORE salary XX
        redis>

#### References
* [Redis - Ismember Operation On Sorted Set?](https://qnalist.com/questions/5766028/ismember-operation-on-sorted-set)
