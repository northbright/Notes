# Got TLS Cert Expired Error when Visit Any Site Due to Incorrect System Time

## Problem
* Got TLS Cert Expired Error when Visit Any Site in Browser

## Root Cause
* Cleared the CMOS to fix the boot failure problem
* System time was incorrect after CMOS cleared
* System time could not fall into the validity period for which the certificate has been issued

## Solution
* Set correct system time

## References
* [System time and certificates](https://security.stackexchange.com/questions/24704/system-time-and-certificates)
* [6 Reasons Why invalid SSL certificate Error happens and How to Fix?](https://sslhow.com/why-invalid-ssl-certificate-error-happens-and-how-to-fix)

