# Not Show Avatar on Web Chat due to Its Size is Larger than 2M

## Problem
* Send a JPG path to agent and say use it as avatar
* Agent says set avatar successfully but can not see the avatar

## Root Cause
Avatar image size should be smaller than 2M.

## Solution
* Resize the avatar image(< 2M) and it works.

## References
* [[Bug] Webchat avatar endpoint /avatar/{agentId} returns 404 even with valid IDENTITY.md avatar #38439](https://github.com/openclaw/openclaw/issues/38439) 
