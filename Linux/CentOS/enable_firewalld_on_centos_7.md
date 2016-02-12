# Enable firewalld on Centos 7

## Problem
Sometimes `firewall-cmd` will failed: `FirewallD is not running`

## Root Cause
`firewalld` is not running or disabled.

## Solution

    sudo systemctl status firewalld
    sudo systemctl enable firewalld
    sudo systemctl start firewalld