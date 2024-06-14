# Use `netplan` to Configure 2 Interfaces

## Problem
* Server(ubuntu server 24.04) has 2 Network Interface Card(NIC)
* Each Interface is Connected to a Different Subnet

  | NIC Name | Planned Static IP for NIC | Connected Subnet |
  | :--: | :--: | :--: |
  | eth0 | `10.0.10.3/24` | `10.0.10.0/24` |
  | eth1 | `10.0.20.3/24` | `10.0.20.0/24` |

* By default, administrators can define a single, default route (on eth0). However, if you receive traffic (i.e., ICMP pings) on eth1, the return traffic will go out eth0 by default.
* Need traffic going into eth0 goes out only on eth0, as well as enforce all traffic going into eth1 goes out only on eth1.

## Solution
Use `netplay` to configure 2 interfaces with adding route table and routing-policy.

#### Backup netplan Config File(e.g. `/etc/netplan/50-cloud-init.yaml`)
```bash
sudo cp /etc/netplan/50-cloud-init.yaml /etc/netplan/50-cloud-init.yaml.bk
```

#### Configure Networks

* Modify Config File

```
sudo vi /etc/netplan/50-cloud-init.yaml
```

```
network:
  ethernets:
    eth0:
      addresses:
      - 10.0.10.3/24
      routes:
      - to: default
        via: 10.0.10.1
      nameservers:
        addresses:
        - 223.5.5.5
        - 223.6.6.6
    eth1:
      addresses:
      - 10.0.20.3/24
      routes:
      - to: default
        via: 10.0.20.1
        table: 2
      routing-policy:
      - from: 10.0.20.3
        table: 2
  version: 2
```

* Apply Configuration

```bash
sudo netplan try
```

#### Check Route Table

* Method A: Using `route -n`

  ```bash
  sudo apt install net-tools
  ```

  ```bash
  route -n
  ```

  | Destination | Gateway | Genmask | Flags | Interface |
  | :--: | :--: | :--: | :--: | :--: |
  | `0.0.0.0` | `10.0.10.1` | `0.0.0.0` | UG | `eth0` |
  | `10.0.10.0` | `0.0.0.0` | `255.255.255.0` | U | `eth0` |
  | `10.0.20.0` | `0.0.0.0` | `255.255.255.0` | U | `eth1` |

  * U: means up and 'G' means: Gateway is used
  * Destination IP: `10.0.10.x`(x: 0 - 255) --> Send It to `eth0`
  * Destination IP: `10.0.20.x`(x: 0 - 255) --> Send It to `eth1`
  * Else IP --> Send It to Default Gateway: `10.0.10.1`

* Method B: Using `ip route`

  ```bash
  ip route
  ```

  ```bash
  // Output:
  default via 10.0.10.1 dev enp1s0f0 proto static
  10.0.10.0/24 dev eth0 proto kernel scope link src 10.0.10.3
  10.0.20.0/24 dev eth1 proto kernel scope link src 10.0.20.3
  ```

## References
* [How to use netplan to create two separate routing tables?](https://askubuntu.com/questions/1169002/how-to-use-netplan-to-create-two-separate-routing-tables)
* [Undestanding the output of route -n](https://unix.stackexchange.com/questions/76379/undestanding-the-output-of-route-n)
