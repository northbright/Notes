# Connect PC Running SDAP Tool to the Same Switch which Hikvision Camera is Connected to Make the SDAP Tool Work

## Problem
* There're 3 VLANs

  | VLAN | Network | Desc |
  | :--: | :--: | :--: |
  | 1 | 10.0.1.0/24 | default VLAN |
  | 2 | 10.0.2.0/24 | for PC |
  | 3 | 10.0.3.0/24 | for Hikvision Network Recorder / Camera |

* Network Topology

                        VLAN 1: 10.0.1.0/24 --> default VLAN
                        VLAN 2: 10.0.2.0/24 --> PC
                        VLAN 3: 10.0.3.0/24 --> Camera
                         ┌───────────────────────┐
                         │ H3C S5500 Core Switch │
                         └───┬────────┬──────────┘
                             │        │
                             │        │
                             │        │
                  ┌──────────┘        │
                  │ Trunk Port        │ Trunk Port
                  │ Permit VLAN 1 3   │ Permit VLAN 1 2
              ┌───┴──────────────┐  ┌─┴────────────────┐
              │  H3C POE Switch  │  │ H3C Access Switch│
              └──┬──────┬────────┘  └──┬───────────────┘
                 │      │              │
┌────────────────┴────┐ │           ┌──┴─────────────────────┐
│       Camera        │ │           │ PC 1                   │
│Old IP: 192.168.1.12 │ │           │IP: 10.0.2.20           │
└─────────────────────┘ │           │Run HikVision SDAP      │
                        │           │Can not find any camera │
                        │           │                        │
 ┌──────────────────────┴─┐         └────────────────────────┘
 │ PC 2                   │
 │IP: 10.0.2.20           │
 │Run HikVision SDAP      │
 │Camera Found!           │
 │Change IP to 10.0.3.11  │
 └────────────────────────┘
