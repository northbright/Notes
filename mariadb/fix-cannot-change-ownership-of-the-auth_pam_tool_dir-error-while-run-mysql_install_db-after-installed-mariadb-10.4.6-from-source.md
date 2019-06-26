# Fix `Cannot change ownership of the 'auth_pam_tool_dir'` Error while Run `mysql_install_db` after Installed MariaDB(10.4.6) from Source

## How to Reproduce
* Install MariaDB Source(10.4.6) following [Install MariaDB from Source on CentOS 7](https://github.com/northbright/Notes/blob/master/mariadb/install-mariadb-from-source-on-centos7.md)
* Initialize MariaDB following the command metiond in the article

       sudo /usr/local/mysql/scripts/mysql_install_db \
       --user=mysql \
       --basedir=/usr/local/mysql/ \
       --datadir=/var/lib/mysql

* Got error messages:

   >  Cannot change ownership of the '/auth_pam_tool_dir' directory"
   to the 'mysql' user. Check that you have the necessary permissions and try again."

## Root Cause
* Look into `/scripts/mysql_install_db`

       ......
       plugindir=`find_in_dirs --dir auth_pam.so $basedir/lib*/plugin $basedir/lib*/mysql/plugin`
       pamtooldir=$plugindir
       ......
       if test -n "$user"
       then
         chown $user "$pamtooldir/auth_pam_tool_dir"
         if test $? -ne 0
         then
             echo "Cannot change ownership of the '$pamtooldir/auth_pam_tool_dir' directory"
             echo " to the '$user' user. Check that you have the necessary permissions and try again."
             exit 1
         fi

   `plugindir/pamtooldir` is the dir which contains `auth_pam.so` and it's empty now that means `auth_pam.so` is **NOT** found

* Look into `/plugin/auth_pam/CMakeLists.txt`

       CHECK_INCLUDE_FILES (security/pam_appl.h HAVE_PAM_APPL_H)

       IF(HAVE_PAM_APPL_H)
         IF(HAVE_STRNDUP)
           ADD_DEFINITIONS(-DHAVE_STRNDUP)
         ENDIF(HAVE_STRNDUP)
         FIND_LIBRARY(PAM_LIBRARY pam)
         ADD_DEFINITIONS(-D_GNU_SOURCE)
         MYSQL_ADD_PLUGIN(auth_pam_v1 auth_pam_v1.c LINK_LIBRARIES pam MODULE_ONLY)
         MYSQL_ADD_PLUGIN(auth_pam auth_pam.c LINK_LIBRARIES pam dl MODULE_ONLY)
         MYSQL_ADD_EXECUTABLE(auth_pam_tool auth_pam_tool.c DESTINATION ${INSTALL_PLUGINDIR}/auth_pam_tool_dir COMPONENT Server)
         TARGET_LINK_LIBRARIES(auth_pam_tool pam)
         INSTALL(CODE "EXECUTE_PROCESS(
                          COMMAND chmod u=rwx,g=,o= auth_pam_tool_dir
                          COMMAND chmod u=rwxs,g=rx,o=rx auth_pam_tool_dir/auth_pam_tool
                          WORKING_DIRECTORY \$ENV{DESTDIR}\${CMAKE_INSTALL_PREFIX}/${INSTALL_PLUGINDIR}/)"
                        COMPONENT Server)
       ENDIF(HAVE_PAM_APPL_H)

   * It'll look up `security/pam_appl.h` and set `HAVE_PAM_APPL_H` to 1 if it exists.
   * `auth_pam.so` will be compiled and installed **ONLY** if `HAVE_PAM_APPL_H=1`

* Look into `CMakeFiles/CMakeError.log`
  * It reported `security/pam_appl.h` is missing
  * `auth_pam` plugin is NOT compiled / installed

## Solution
* Install `pam-devel` package which provides `security/pam_appl.h` and other dependencies

       yum install -y pam-devel

* Run `scripts/mysql_install_db` with `--auth-root-authentication-method=normal` option for 10.4.6 and later

       sudo /usr/local/mysql/scripts/mysql_install_db \
       --user=mysql \
       --basedir=/usr/local/mysql/ \
       --datadir=/var/lib/mysql \
       --auth-root-authentication-method=normal \
