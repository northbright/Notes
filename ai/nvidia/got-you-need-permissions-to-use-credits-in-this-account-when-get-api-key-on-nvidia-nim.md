# Got "You need permissions to use credits in this account" when Get API Key on NVIDIA NIM

## Problem
* Use an enterprise email account(e.g. `xx@my_company.com`) to register NVIDIA NIM account
* Visit <https://build.nvidia.com/deepseek-ai/deepseek-r1>
* Click "Get API Key" and got "You need permissions to use credits in this account"

## Root Cause
* NVIDIA NIM checks if the emaill address is enterprise and require admin's approve to use credits

## Solution
* Use email address from email providers(e.g. QQ, 163) to register a new NVIDIA NIM account
