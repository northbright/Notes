# Install PostgreSQL from Source on CentOS 7

## Building PostgresSQL

1. Install Requirements of PostgreSQL.

        sudo yum install readline-devel systemd-devel zlib-devel bison flex

2. Clone Repository of PostgreSQL.

        git clone git://git.postgresql.org/git/postgresql.git

3. Checkout Source Code of Specified Release Tag.

        cd postgresql

        // Update Remote.
        git remote update
        
        // List All Release Tags.
        git tag -l
        
        // Select One Release Tag and Checkout Source Code. e.g. "REL_10_3".
        git checkout -b 10.3 REL_10_3

4. Configure and Build

        // Use "git clean -dfx" to clean existing build
        git clean -dfx

        ./configure --with-systemd
        make clean
        make
        sudo make install

## Set Envionment Variables

    sudo vi /etc/profile

    # PostgreSQL
    export PATH=$PATH:/usr/local/pgsql/bin
    export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/pgsql/lib

## Initialize PostgreSQL

1. Create `postgres` User

        sudo adduser postgres

2. Create `/usr/local/pgsql/data` and Set its Owner to `postgres`

        sudo mkdir /usr/local/pgsql/data
        sudo chown postgres /usr/local/pgsql/data

3. Login with New Created `postgres` User and Initialize PostgreSQL

        sudo su - postgres
        /usr/local/pgsql/bin/initdb -D /usr/local/pgsql/data/

## Configure PostgreSQL as systemd Service

* Logout `postgres` and login previous one

        exit

* Create a new systemd Service

        sudo vi /etc/systemd/system/postgresql.service

        [Unit]
        Description=PostgreSQL database server
        Documentation=man:postgres(1)

        [Service]
        Type=notify
        User=postgres
        ExecStart=/usr/local/pgsql/bin/postgres -D /usr/local/pgsql/data
        ExecReload=/bin/kill -HUP $MAINPID
        KillMode=mixed
        KillSignal=SIGINT
        TimeoutSec=0

        [Install]
        WantedBy=multi-user.target

* Start and Enable postgresql.service

        sudo systemctl start postgresql.service
        sudo systemctl status postgresql.service
        sudo systemctl enable postgresql.service
        
## Test
* Login as `postgres` User to Run PostgreSQL Client: `psql`

        sudo su - postgres
        /usr/local/pgsql/bin/psql
    
* Run Commands

    * Type `\l` to list databases
        
                postgres=# \l

    * Type `\h` for help        
        
                postgres=# \h

    * Type `\q` to exit

                postgres=# \q

## References
* [Manuals](https://www.postgresql.org/docs/manuals/)
* [readline, library, not found and so on](https://www.postgresql.org/message-id/19715894.1058735473157.JavaMail.root@moeve)

