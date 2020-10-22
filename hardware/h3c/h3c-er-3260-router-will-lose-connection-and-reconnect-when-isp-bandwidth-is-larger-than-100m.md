# H3C ER3260 Router Will Lose Connection and Reconnect(PPPOE) when ISP Bandwidth is Larger than 100m

#### Problem
* ISP speeded up the bandwidth from 100m to 200m
* Set WAN mode to "AUTO"(it was set to 100M previously for 100Mbps)
* The router will lose connection and re-connect via PPPOE

#### Root Cause
* The gateway(Raisecom MSG2200-T4) has the known issue(lose connection)

#### Solution
* Replace the Raisecom MSG2200-T4 with modem(only 1 LAN interface)

