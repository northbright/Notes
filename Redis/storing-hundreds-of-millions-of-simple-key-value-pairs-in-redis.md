# Storing hundreds of millions of simple key-value pairs in Redis

When transitioning systems, sometimes you have to build a little scaffolding. At Instagram, we recently had to do just that: for legacy reasons, we need to keep around a mapping of about 300 million photos back to the user ID that created them, in order to know which shard to query (see more info about our sharding setup). While eventually all clients and API applications will have been updated to pass us the full information, there are still plenty who have old information cached. We needed a solution that would:

Look up keys and return values very quickly
Fit the data in memory, and ideally within one of the EC2 high-memory types (the 17GB or 34GB, rather than the 68GB instance type)
Fit well into our existing infrastructure
Be persistent, so that we wouldn’t have to re-populate it if a server died
One simple solution to this problem would be to simply store them as a bunch of rows in a database, with “Media ID” and “User ID” columns. However, a SQL database seemed like overkill given that these IDs were never updated (only inserted), didn’t need to be transactional, and didn’t have any relations with other tables.

Instead, we turned to Redis, an advanced key-value store that we use extensively here at Instagram (for example, it powers our main feed). Redis is a key-value swiss-army knife; rather than just normal “Set key, get key” mechanics like Memcached, it provides powerful aggregate types like sorted sets and lists. It has a configurable persistence model, where it background saves at a specified interval, and can be run in a master-slave setup. All of our Redis deployments run in master-slave, with the slave set to save to disk about every minute.

At first, we decided to use Redis in the simplest way possible: for each ID, the key would be the media ID, and the value would be the user ID:

    SET media:1155315 939
    GET media:1155315
    > 939

While prototyping this solution, however, we found that Redis needed about 70 MB to store 1,000,000 keys this way. Extrapolating to the 300,000,000 we would eventually need, it was looking to be around 21GB worth of data—already bigger than the 17GB instance type on Amazon EC2.

We asked the always-helpful Pieter Noordhuis, one of Redis’ core developers, for input, and he suggested we use Redis hashes. Hashes in Redis are dictionaries that are can be encoded in memory very efficiently; the Redis setting ‘hash-zipmap-max-entries’ configures the maximum number of entries a hash can have while still being encoded efficiently. We found this setting was best around 1000; any higher and the HSET commands would cause noticeable CPU activity. For more details, you can check out the zipmap source file.

To take advantage of the hash type, we bucket all our Media IDs into buckets of 1000 (we just take the ID, divide by 1000 and discard the remainder). That determines which key we fall into; next, within the hash that lives at that key, the Media ID is the lookup key *within* the hash, and the user ID is the value. An example, given a Media ID of 1155315, which means it falls into bucket 1155 (1155315 / 1000 = 1155):

    HSET "mediabucket:1155" "1155315" "939"
    HGET "mediabucket:1155" "1155315"
    > "939"

The size difference was pretty striking; with our 1,000,000 key prototype (encoded into 1,000 hashes of 1,000 sub-keys each), Redis only needs 16MB to store the information. Expanding to 300 million keys, the total is just under 5GB—which in fact, even fits in the much cheaper m1.large instance type on Amazon, about 1/3 of the cost of the larger instance we would have needed otherwise. Best of all, lookups in hashes are still O(1), making them very quick.

If you’re interested in trying these combinations out, the script we used to run these tests is available as a [Gist on GitHub](https://gist.github.com/1329319)(we also included Memcached in the script, for comparison—it took about 52MB for the million keys). And if you’re interested in working on these sorts of problems with us, drop us a note, we’re hiring!.

#### About
* This article is a copy of [original post on instagram](http://engineering.instagram.com/posts/1613245832251302/storing-hundreds-of-millions-of-simple-key-value-pairs-in-redis/).
* Accessing instagram is blocked in China.

